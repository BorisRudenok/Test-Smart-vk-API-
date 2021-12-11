package tests;


import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import page.PageHomeVk;
import page.PageMyPage;
import page.PageNewsFeed;
import utils.*;
import org.testng.annotations.BeforeClass;
import workWithApi.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


public class TestLogIn {
    private final GenerateRandomText generateRandomText = new GenerateRandomText();
    private final PageHomeVk pageHomeVk = new PageHomeVk();
    private final PageNewsFeed pageNewsFeed = new PageNewsFeed();
    private final RegularExpressionsForId regularExpressionsForId = new RegularExpressionsForId();
    private final PageMyPage pageMyPage = new PageMyPage();
    private final Browser browser = AqualityServices.getBrowser();
    private final GetObj getObj = new GetObj();
    private final ApiAppRequest apiAppRequest = new ApiAppRequest();
    private final ApiAppRequestPhoto apiAppRequestPhoto = new ApiAppRequestPhoto();
    private final Photo photo = new Photo();
    private final String randomTextForPost = generateRandomText.generatingLetters(TestDataConst.numberOfSymbolsForPost);
    private final String randomTextForEdit = generateRandomText.generatingLetters(TestDataConst.numberOfSymbolsForEdit);
    private static final String CHECK_CORRECT_RESULT_METHOD = "1";
    private static final String CODING_STANDARD = "UTF-8";
    private static final String PATTERN_ID_AUTHOR = "(?<=id).*$";
    private static final String PATTERN_ID_PHOTO = "(?<=_).*$";
    private static final int NUMBER_OF_POST = 0;


    @BeforeClass
    private void setUp() {
        browser.maximize();
        browser.goTo(ConfigData.urlVk);
        pageHomeVk.state().waitForDisplayed();
    }

    @Test
    public void TestVk() throws UnsupportedEncodingException {
        pageHomeVk.inputEmailOrPhoneNumber(TestDataConst.login);
        pageHomeVk.inputPassword(TestDataConst.password);
        pageHomeVk.pressButtonLogIn();
        pageNewsFeed.pushButtonMyPage();
        Posts PostObj = getObj.objPost(apiAppRequest.postTextToWall(ApiMethod.POST, TestDataConst.ownerId, randomTextForPost)
                                                                    .getBody()
                                                                    .getObject()
                                                                    .getJSONObject(TestDataConst.keyJsonObj));
        Assert.assertEquals(regularExpressionsForId.getIdPattern(pageMyPage.getIdAuthor(NUMBER_OF_POST),
                        PATTERN_ID_AUTHOR), TestDataConst.ownerId,
                "id does not match");
        Assert.assertEquals(pageMyPage.getTextPost(NUMBER_OF_POST), randomTextForPost,"text does not match");

        String uploadUrl = photo.getWallPhotoUploadServer();
        List<String> photoObj = apiAppRequestPhoto.uploadPhotoOnTheWall(uploadUrl);
        String photo1 = photoObj.get(0);
        String server = photoObj.get(1);
        String hash = photoObj.get(2);
        String photoId = photo.saveUploadWallPhoto(URLEncoder.encode(photo1, CODING_STANDARD), server, hash);

        apiAppRequest.editPhotoOnTheWall(photoId, ApiMethod.EDIT.getMethod(), TestDataConst.ownerId, randomTextForEdit,
                PostObj.post_id, TestDataConst.accessToken, ConfigData.apiVersion);
        Assert.assertEquals(photoId, regularExpressionsForId.getIdPattern(pageMyPage.getIdPhoto(NUMBER_OF_POST),
                        PATTERN_ID_PHOTO),
                "id does not match");
        Assert.assertEquals(pageMyPage.getTextPost(NUMBER_OF_POST), randomTextForEdit,"text does not match");
        apiAppRequest.addCommentToPostOnTheWall(ApiMethod.ADD_COMMENT, PostObj.post_id, TestDataConst.ownerId, randomTextForPost);

        pageMyPage.pushButtonLike(NUMBER_OF_POST);
        Assert.assertEquals(apiAppRequest.isLikedToPostOnTheWall(ApiMethod.IS_LIKED, PostObj.post_id, TestDataConst.ownerId,
                                TestDataConst.typeForLike)
                                .getBody()
                                .getObject()
                                .getJSONObject(TestDataConst.keyJsonObj)
                                .getString(TestDataConst.keyForCheckPostLike),
                                CHECK_CORRECT_RESULT_METHOD,"the post is not liked");
        Assert.assertEquals(regularExpressionsForId.getIdPattern(pageMyPage.getIdAuthorCommentToPost(NUMBER_OF_POST),
                        PATTERN_ID_AUTHOR),
                TestDataConst.ownerId, "id does not match");
        Assert.assertEquals(apiAppRequest.deletePostFromTheWall(ApiMethod.DELETE_POST, PostObj.post_id, TestDataConst.ownerId)
                        .getBody()
                        .getObject()
                        .getString(TestDataConst.keyJsonObj),
                         CHECK_CORRECT_RESULT_METHOD,"post not deleted");
    }

    @AfterClass
    private void out() {
        browser.quit();
    }
}

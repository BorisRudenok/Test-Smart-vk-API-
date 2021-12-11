package page;

import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.TestDataConst;

import java.util.List;


public class PageMyPage extends Form {

    public PageMyPage() {
        super(By.className("page_name"), "name profile");
    }

    private final IButton showNextComments = getElementFactory().getButton(By.xpath("//a[contains(@class,'replies_next  replies_next_main')]"),
            " button show next comments");

    public String getIdAuthor(Integer numberOfPost) {
        List<ILink> author = getElementFactory().findElements(By.className("author"),
                ElementType.LINK,
                ElementsCount.MORE_THEN_ZERO);
        return author.get(numberOfPost).getElement().getAttribute(TestDataConst.getAttributeIdAuthor);
    }

    public String getTextPost(Integer numberOfPost) {
        List<ITextBox> author = getElementFactory().findElements(By.xpath("//div[contains(@class,'wall_post_cont _wall_post_cont')]"),
                ElementType.TEXTBOX,
                ElementsCount.MORE_THEN_ZERO);
        return author.get(numberOfPost).getText();
    }

    public String getIdPhoto(Integer numberOfPost) {
        List<ILink> author = getElementFactory().findElements(By.xpath("//div[contains(@class,'page_post_sized_thumbs  clear_fix')]/a"),
                ElementType.LINK,
                ElementsCount.MORE_THEN_ZERO);
        return author.get(numberOfPost).getElement().getAttribute(TestDataConst.getAttributeIdPhoto);
    }


    public String getIdAuthorCommentToPost(Integer numberOfPost) {
        List<ILink> author = getElementFactory().findElements(By.xpath("//div[@class='reply_content']//a[@class='author']"),
                ElementType.LINK);
        if (showNextComments.state().isClickable()) {
            showNextComments.click();
        }
        return author.get(numberOfPost).getElement().getAttribute(TestDataConst.getAttributeIdAuthor);
    }

    public void pushButtonLike(Integer numberOfPost) {
        List<IButton> buttonLike = getElementFactory().findElements(By.xpath("//div[contains(@class,'PostButtonReactions__icon ')]"),
                ElementType.BUTTON);
        buttonLike.get(numberOfPost).click();
    }
}

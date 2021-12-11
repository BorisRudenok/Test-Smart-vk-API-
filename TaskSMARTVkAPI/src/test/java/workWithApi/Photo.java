package workWithApi;

import apiModels.JsonResponse;
import utils.ApiMethod;
import utils.ConfigData;
import utils.TestDataConst;


public class Photo {
    private final VkApiUtils vkApiUtils = new VkApiUtils();

    public String getWallPhotoUploadServer() {
        String request = String.format("%s?user_id=%s&access_token=%s&v=%s",
                ApiMethod.GET_WALL_UPLOAD_SERVER.getMethod(), TestDataConst.ownerId, TestDataConst.accessToken,
                ConfigData.apiVersion);
        JsonResponse jsonResponse = vkApiUtils.postPhoto(request);
        return jsonResponse.getBody().getObject().getJSONObject("response").getString("upload_url");
    }

    public String saveUploadWallPhoto(String photo, String server, String hash) {
        String request = String.format("%s?user_id=%s&photo=%s&server=%s&hash=%s&access_token=%s&v=%s",
                ApiMethod.SEVE_WALL_PHOTO.getMethod(), TestDataConst.ownerId, photo, server, hash, TestDataConst.accessToken,
                ConfigData.apiVersion);
        JsonResponse jsonResponse = vkApiUtils.postPhoto(request);
        return jsonResponse.getBody().getObject().getJSONArray("response").getJSONObject(0).getString("id");
    }
}

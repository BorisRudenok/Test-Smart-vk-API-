package workWithApi;

import apiModels.JsonResponse;

import java.util.LinkedList;
import java.util.List;

public class ApiAppRequestPhoto {
    private final VkApiUtils vkApiUtils = new VkApiUtils();
    public List<String> uploadPhotoOnTheWall(String uploadUrl) {
        JsonResponse jsonResponse = vkApiUtils.upLoad(uploadUrl, "src/test/resources/upload_photo.png", "photo");
        List<String> photoObj = new LinkedList<>();
        photoObj.add(jsonResponse.getBody().getObject().getString("photo"));
        photoObj.add(jsonResponse.getBody().getObject().getString("server"));
        photoObj.add(jsonResponse.getBody().getObject().getString("hash"));
        return photoObj;
    }
}

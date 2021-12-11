package workWithApi;

import apiModels.JsonResponse;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import utils.ApiMethod;

import java.util.HashMap;
import java.util.Map;

public class ApiAppRequest {
    private final VkApiUtils vkApiUtils = new VkApiUtils();

    public JsonResponse postTextToWall(ApiMethod method, String id, String text) {
        Map<String, Object> params = new HashMap<>();
        params.put("owner_id", id);
        params.put("message", text);
        HttpResponse<JsonNode> response = vkApiUtils.post(method, params);
        return new JsonResponse(response.getStatus(), response.getBody());
    }

    public JsonResponse addCommentToPostOnTheWall(ApiMethod method, String postId, String id, String text) {
        Map<String, Object> params = new HashMap<>();
        params.put("owner_id", id);
        params.put("post_id", postId);
        params.put("message", text);
        HttpResponse<JsonNode> response = vkApiUtils.post(method, params);
        return new JsonResponse(response.getStatus(), response.getBody());
    }

    public JsonResponse isLikedToPostOnTheWall(ApiMethod method, String postId, String id, String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("type", type);
        params.put("owner_id", id);
        params.put("item_id", postId);
        HttpResponse<JsonNode> response = vkApiUtils.post(method, params);
        return new JsonResponse(response.getStatus(), response.getBody());
    }

    public JsonResponse deletePostFromTheWall(ApiMethod method, String postId, String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("owner_id", id);
        params.put("post_id", postId);
        HttpResponse<JsonNode> response = vkApiUtils.post(method, params);
        return new JsonResponse(response.getStatus(), response.getBody());
    }

    public JsonResponse editPhotoOnTheWall(String photoId,
                                           String methodName,
                                           String id,
                                           String text,
                                           String postId,
                                           String token,
                                           String apiV) {
        String request = String.format("%s?owner_id=%s&post_id=%s&message=%s&attachments=photo%s_%s&access_token=%s&v=%s",
                methodName, id, postId, text, id, photoId, token, apiV);
        return vkApiUtils.postPhoto(request);
    }


}

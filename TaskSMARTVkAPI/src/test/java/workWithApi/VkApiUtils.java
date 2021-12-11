package workWithApi;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import utils.ApiMethod;
import utils.ConfigData;
import utils.TestDataConst;

import java.util.Map;

public class VkApiUtils extends ApiUtils {
    public VkApiUtils() {
        super(ConfigData.apiBaseUrl);
    }

    public HttpResponse<JsonNode> get(ApiMethod method, Map<String, Object> params) {
        return get(method.getMethod(), params).queryString("access_token", TestDataConst.accessToken).queryString("v",
                ConfigData.apiVersion).asJson();
    }

    public HttpResponse<JsonNode> post(ApiMethod method, Map<String, Object> params) {
        return post(method.getMethod(), params).queryString("access_token", TestDataConst.accessToken).queryString("v",
                ConfigData.apiVersion).asJson();
    }
}

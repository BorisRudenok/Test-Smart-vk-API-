package workWithApi;

import apiModels.JsonResponse;
import kong.unirest.*;


import java.io.File;
import java.util.Map;


public class ApiUtils {
    private final String baseUrl;

    public ApiUtils(String baseUrl) {
        this.baseUrl = baseUrl;
        Unirest.config().defaultBaseUrl(baseUrl);
    }

    public GetRequest get(String route, Map<String, Object> params) {
        return Unirest.get(route).queryString(params);
    }

    public JsonResponse postPhoto(String requestPath) {
        HttpResponse<JsonNode> response = Unirest.post(requestPath).asJson();
        Unirest.shutDown();
        return new JsonResponse(response.getStatus(), response.getBody());
    }

    public HttpRequestWithBody post(String route, Map<String, Object> params) {
        return Unirest.post(route).queryString(params);
    }

    public JsonResponse upLoad(String requestPath, String filePath, String typeOfFile) {
        HttpResponse<JsonNode> response = Unirest.post(requestPath).field(typeOfFile, new File(filePath)).asJson();
        Unirest.shutDown();
        return new JsonResponse(response.getStatus(), response.getBody());
    }

}

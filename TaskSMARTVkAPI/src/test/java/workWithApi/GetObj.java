package workWithApi;

import com.google.gson.Gson;
import kong.unirest.json.JSONObject;

public class GetObj {
    private final Gson g = new Gson();

    public Posts objPost(JSONObject jsonObject) {
        return g.fromJson(String.valueOf(jsonObject), Posts.class);
    }
}

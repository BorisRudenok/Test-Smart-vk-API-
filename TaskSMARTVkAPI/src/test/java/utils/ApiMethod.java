package utils;

public enum ApiMethod {

    POST("wall.post"),
    EDIT("wall.edit"),
    ADD_COMMENT("wall.createComment"),
    IS_LIKED("likes.isLiked"),
    DELETE_POST("wall.delete"),
    GET_WALL_UPLOAD_SERVER("photos.getWallUploadServer"),
    SEVE_WALL_PHOTO("photos.saveWallPhoto");
    private final String method;

    ApiMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}

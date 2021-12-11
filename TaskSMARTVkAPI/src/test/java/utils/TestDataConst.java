package utils;

public class TestDataConst {
    public static final String password = ConfigManager.getPropertyTestData("pass");
    public static final String login = ConfigManager.getPropertyTestData("login");
    public static final String ownerId = ConfigManager.getPropertyTestData("OWNER_ID");
    public static final String accessToken = ConfigManager.getPropertyTestData("ACCESS_TOKEN");
    public static final String typeForLike = ConfigManager.getPropertyTestData("typeForLike");
    public static final Integer numberOfSymbolsForPost = Integer.parseInt(ConfigManager.getPropertyTestData("numberOfSymbolsForPost"));
    public static final Integer numberOfSymbolsForEdit = Integer.parseInt(ConfigManager.getPropertyTestData("numberOfSymbolsForEdit"));
    public static final String getAttributeIdAuthor = ConfigManager.getPropertyTestData("getAttributeIdAuthor");
    public static final String keyForCheckPostLike = ConfigManager.getPropertyTestData("keyForCheckPostLike");
    public static final String keyJsonObj = ConfigManager.getPropertyTestData("keyJsonObj");
    public static final String getAttributeIdPhoto = ConfigManager.getPropertyTestData("getAttributeIdPhoto");
}

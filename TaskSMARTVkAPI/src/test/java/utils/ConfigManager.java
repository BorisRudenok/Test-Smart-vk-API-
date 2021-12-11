package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static aquality.selenium.browser.AqualityServices.getLogger;

public class ConfigManager {
    private static Properties PROPERTIESTestData;
    private static final String PathTestData = "src/test/resources/testData.properties";
    private static final String PathConf = "src/test/resources/conf.properties";
    private static Properties PROPERTIESConf;

    static {
        try (FileReader fileInputStreamTestData = new FileReader(PathTestData);
             FileReader fileInputStreamConf = new FileReader(PathConf)) {
            PROPERTIESConf = new Properties();
            PROPERTIESConf.load(fileInputStreamConf);
            PROPERTIESTestData = new Properties();
            PROPERTIESTestData.load(fileInputStreamTestData);

        } catch (IOException e) {
            getLogger().info("file data failed!", e);
        }
    }

    public static String getPropertyTestData(String key) {
        return PROPERTIESTestData.getProperty(key);
    }

    public static String getPropertyConf(String key) {
        return PROPERTIESConf.getProperty(key);
    }
}

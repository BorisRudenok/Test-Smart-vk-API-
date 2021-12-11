package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsForId {
    public String getIdPattern(String url, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(url);
        String id = "";
        while (m.find()) {
            id = m.group();
        }
        return id;
    }
}

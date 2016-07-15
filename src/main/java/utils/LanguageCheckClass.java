package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageCheckClass {

    public static String setMainGreeting(String correct) {
        Pattern pt = Pattern.compile("(.*[\\s])");
        Matcher m = pt.matcher(correct);
        m.find();
        return m.group();
    }
}

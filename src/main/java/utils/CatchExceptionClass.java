package utils;

import java.net.MalformedURLException;
import java.net.URL;

public class CatchExceptionClass {

    public static URL catchExceptionMethodForBaseTest() {
        URL testStream = null;
        try {
            testStream = new URL("http://localhost:4445/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return testStream;
    }
}

package utils;

import org.openqa.selenium.WebElement;
import pages.Page;
import org.openqa.selenium.interactions.Actions;


public class ActionsUtils {

    private static Actions action = new Actions(Page.getDriver());

    public static void actionClick(WebElement actionClick) {
        action.click(actionClick).build().perform();
    }

    public static void sendKeysMethod(WebElement send, String sendKeys) {
        send.sendKeys(sendKeys);
    }
}
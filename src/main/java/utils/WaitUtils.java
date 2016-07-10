package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class WaitUtils {
    public static WebElement waitForElement(WebDriver driver, By by, int timeOutInSeconds) {
        WebElement element;
        FluentWait wait = new FluentWait(driver)
                .withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }
    public static WebElement waitForElementForAddingCart(WebDriver driver,WebElement add ,int timeOutInSeconds) {
        WebElement element;
        FluentWait wait = new FluentWait(driver)
                .withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        element = (WebElement) wait.until(ExpectedConditions.visibilityOf(add));
        return element;
    }
}


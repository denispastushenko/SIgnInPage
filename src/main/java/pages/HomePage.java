package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static pages.AddToCartPage.action;

public class HomePage extends Page {

    @FindBy(xpath = "//span[text()='Sign In']")
    private static WebElement dropDowListSignIn;

    @FindBy(xpath = "//span[text()='SIGN IN']")
    private static WebElement linkSignIn;

    public HomePage(WebDriver webDriver) {super(webDriver);
    }

    public  SignInPage actionButtonSignIn() throws NoSuchFieldException {
        action.click(dropDowListSignIn).build().perform();
        action.click(linkSignIn).build().perform();
        return new SignInPage(Page.getDriver());
    }

}



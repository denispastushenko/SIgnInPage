package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;
import static utils.ActionsUtils.*;

public class HomePage extends Page {

    @FindBy(xpath = "//span[text()='Sign In']")
    private static WebElement dropDowListSignIn;

    @FindBy(xpath = "//span[text()='SIGN IN']")
    private static WebElement linkSignIn;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public SignInPage actionButtonSignIn() {
        WaitUtils.waitForElementForWebElem(dropDowListSignIn, 5);
        actionClick(dropDowListSignIn);
        WaitUtils.waitForElementForWebElem(linkSignIn, 5);
        actionClick(linkSignIn);
        return new SignInPage(driver.get());
    }
}



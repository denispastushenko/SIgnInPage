package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

public class SignInPage extends Page {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='sign-in-form__form-button']")
    private WebElement signInButton;

    public SignInPage(WebDriver webDriver) {super(webDriver);}

    public CheckPage signInMetod(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
        String locator = "//div[@class='dashboard-welcome__welcome-msg']";
        WaitUtils.waitForElement(Page.getDriver(), By.xpath(locator), 5);
        return new CheckPage(Page.getDriver());
    }
}

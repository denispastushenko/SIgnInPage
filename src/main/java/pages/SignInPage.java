package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;
import static utils.ActionsUtils.*;

public class SignInPage extends Page {

    private By waiterOfElementVisibility = By.xpath("//div[@class='dashboard-welcome__welcome-msg']");

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='sign-in-form__form-button']")
    private WebElement signInButton;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public FindItemPage signInMethod(String email, String password) {
        sendKeysMethod(emailInput, email);
        sendKeysMethod(passwordInput, password);
        actionClick(signInButton);
        WaitUtils.waitForElementBy(waiterOfElementVisibility, 5);
        return new FindItemPage(driver.get());
    }
}

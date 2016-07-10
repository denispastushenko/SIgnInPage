package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckPage extends Page {

    @FindBy(xpath = "//div[@class='dashboard-welcome__welcome-msg']")
    private WebElement autorizationLoginLable;

    @FindBy(xpath = "//h1[@class = 'checkout-order-summary__panel__header__heading']")
    private WebElement checkCart;

    public CheckPage(WebDriver webDriver) {
        super(webDriver);
    }

    public FindItemPage checkTestDone() {
        Assert.assertEquals(autorizationLoginLable.getText(), "Welcome, dpastushenko1996@gmail.com");
        return new FindItemPage(Page.getDriver());
    }

    public ViewCartPage cartCheck() {
        Assert.assertEquals(checkCart.getText(), "ORDER SUMMARY");
        return new ViewCartPage(Page.getDriver());
    }
}

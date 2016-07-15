package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

import static utils.ActionsUtils.*;


public class ViewCartPage extends Page {

    @FindBy(xpath = "//a[@class = 'global_minicart__content__subtotal-view__view-cart-link']")
    private WebElement viewCart;

    @FindBy(xpath = "//div[@class = 'checkout-order-summary__panel__header']")
    private WebElement checkForItemsInTheCart;

    public ViewCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ViewCartPage viewCartPage() {
        actionClick(viewCart);
        WaitUtils.waitForElementForWebElem(checkForItemsInTheCart, 10);
        return new ViewCartPage(Page.getDriver());
    }

    public ViewCartPage checkForItemsInTheCart() {
        Assert.assertEquals(checkForItemsInTheCart, checkForItemsInTheCart);
        return new ViewCartPage(driver.get());
    }
}

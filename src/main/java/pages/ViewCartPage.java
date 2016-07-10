package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartPage extends Page {

    @FindBy(xpath = "//a[@class = 'global_minicart__content__subtotal-view__view-cart-link']")
    private WebElement viewCart;

    public ViewCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckPage viewCartPage(){
        viewCart.click();
        return new CheckPage(Page.getDriver());
    }
}

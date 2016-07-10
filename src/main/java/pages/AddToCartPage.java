package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

public class AddToCartPage extends Page {

    public static Actions action = new Actions(Page.getDriver());

    @FindBy(xpath = "//a[@href = '/en/pdp/olympic-soccer-ball-size-5-0844194p.html#srp']")
    private WebElement addToCart;

    @FindBy(xpath = "//button[@class = 'add-to-cart__button']")
    private WebElement addToCartConformation;

    @FindBy(xpath = "//a[@class = 'popup-component__container__body__footer__text-link']")
    private WebElement continueShopping;

    @FindBy(xpath = "//button[@title ='Cart']")
    private static WebElement cartCheck;

    public AddToCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ViewCartPage addToCart() {
        addToCart.click();
        WaitUtils.waitForElementForAddingCart(Page.getDriver(), addToCartConformation, 15);
        addToCartConformation.click();
        WaitUtils.waitForElementForAddingCart(Page.getDriver(), continueShopping, 15);
        continueShopping.click();
        action.click(cartCheck).build().perform();
        WaitUtils.waitForElement(Page.getDriver(), By.xpath("//a[@class = 'global_minicart__content__subtotal-view__view-cart-link']"), 5);
        return new ViewCartPage(Page.getDriver());
    }
}

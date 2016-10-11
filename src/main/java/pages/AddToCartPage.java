package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;
import static utils.ActionsUtils.*;

public class AddToCartPage extends Page {

    private By waitingForCartButVis = By.xpath("//a[@class = 'global_minicart__content__subtotal-view__view-cart-link']");

    @FindBy(xpath = "//a[@data-anchor = '0403008P']")
    private WebElement addToCart;

    @FindBy(xpath = "//button[@class = 'add-to-cart__button']")
    private WebElement addToCartConformation;

    @FindBy(xpath = "//a[@class = 'popup-component__container__body__footer__text-link']")
    private WebElement continueShopping;

    @FindBy(xpath = "//button[@aria-controls='global-minicart']")
    private static WebElement cartCheck;

    public AddToCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ViewCartPage addToCart() {
        actionClick(addToCart);
        WaitUtils.waitForElementForWebElem(addToCartConformation, 50);
        actionClick(addToCartConformation);
        WaitUtils.waitForElementForWebElem(continueShopping, 50);
        actionClick(continueShopping);
        actionClick(cartCheck);
        WaitUtils.waitForElementBy(waitingForCartButVis, 50);
        return new ViewCartPage(driver.get());
    }
}

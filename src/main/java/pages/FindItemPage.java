package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.WaitUtils;

import static utils.ActionsUtils.actionClick;
import static utils.ActionsUtils.sendKeysMethod;
import static utils.LanguageCheckClass.setMainGreeting;


public class FindItemPage extends Page {

    private By waitCategoriesVis = By.xpath("//a[@class = 'search-results-grid__load-more-results__link']");

    @FindBy(xpath = "//div[@class='dashboard-welcome__welcome-msg']")
    private WebElement autorizationLoginLable;

    @FindBy(id = "global-search__input")
    private WebElement serchItemField;

    @FindBy(id = "global-search__submit")
    private WebElement serchItemButton;

    public FindItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public FindItemPage checkTestForSignIn(String accountChecking) {
        Assert.assertEquals(setMainGreeting(autorizationLoginLable.getText()) + accountChecking,
                String.format(setMainGreeting(autorizationLoginLable.getText()) + "%s", accountChecking));
        return new FindItemPage(driver.get());
    }

    public AddToCartPage printItemName(String item) {
        sendKeysMethod(serchItemField, item);
        WaitUtils.waitForElementForWebElem(serchItemButton, 5);
        actionClick(serchItemButton);
        WaitUtils.waitForElementBy(waitCategoriesVis, 5);
        return new AddToCartPage(driver.get());
    }


}

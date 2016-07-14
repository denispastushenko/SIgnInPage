package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;
import static utils.ActionsUtils.*;


public class FindItemPage extends Page {

    private By waitCategoriesVis = By.xpath("//span[text()='CATEGORIES']");

    @FindBy(xpath = "//div[@class='dashboard-welcome__welcome-msg']")
    private WebElement autorizationLoginLable;

    @FindBy(id = "global-search__input")
    private WebElement serchItemField;

    @FindBy(id = "global-search__submit")
    private WebElement serchItemButton;

    public FindItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public FindItemPage checkTestForSignIn( String accountChecking) {
        Assert.assertEquals(autorizationLoginLable.getText(), String.format("Welcome, %s", accountChecking));
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

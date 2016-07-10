package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;


public class FindItemPage extends Page {

    @FindBy(id = "global-search__input")
    private WebElement serchItemField;

    @FindBy(id = "global-search__submit")
    private WebElement serchItemButton;

    public FindItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddToCartPage printItemName(String item) {
        serchItemField.sendKeys(item);
        serchItemButton.click();
        WaitUtils.waitForElement(Page.getDriver(), By.xpath("//span[text()='CATEGORIES']"), 7);
        return new AddToCartPage(Page.getDriver());
    }
}

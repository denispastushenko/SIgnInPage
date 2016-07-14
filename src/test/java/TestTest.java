import org.junit.Test;
import pages.Page;

public class TestTest extends BaseTest {

    @Test
    public void signInToWebsite() {
        Page.getDriver().get(SITE);
        signInPage = homePage.actionButtonSignIn();
        findItemPage = signInPage.signInMethod("dpastushenko1996@gmail.com", "1996baba");
        findItemPage.checkTestForSignIn("dpastushenko1996@gmail.com");
        addToCartPage = findItemPage.printItemName("soccer ball");
        viewCartPage = addToCartPage.addToCart();
        viewCartPage.viewCartPage();
        viewCartPage.checkForItemsInTheCart();
    }
}

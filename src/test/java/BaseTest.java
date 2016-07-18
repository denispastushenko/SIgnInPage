import anotation.Proxy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.WebDriwerSetUp;

import java.lang.reflect.Method;

public class BaseTest {
    public static final String SITE = "http://www.canadiantire.ca/en.html";
    protected HomePage homePage;
    protected SignInPage signInPage;
    protected FindItemPage findItemPage;
    protected AddToCartPage addToCartPage;
    protected ViewCartPage viewCartPage;

    @BeforeMethod
    public void setUp(Method method) {
        System.setProperty("webdriver.chrome.driver", "Z:/Downloads/ChromeDriver/chromedriver.exe");
        homePage = new HomePage(WebDriwerSetUp.createDriver(method.isAnnotationPresent(Proxy.class)));
        Page.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void shoutDown() {
        if (Page.getDriver() != null) {
            Page.getDriver().quit();
        }
    }
}



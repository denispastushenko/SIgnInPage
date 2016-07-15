import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;
import static utils.CatchExeptionClass.*;

public class BaseTest {
    public static final String SITE = "http://www.canadiantire.ca/en.html";
    protected HomePage homePage;
    protected SignInPage signInPage;
    protected FindItemPage findItemPage;
    protected AddToCartPage addToCartPage;
    protected ViewCartPage viewCartPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Z:/Downloads/ChromeDriver/chromedriver.exe");
        homePage = new HomePage(new RemoteWebDriver(catchExeptionMethodForBaseTest(), DesiredCapabilities.chrome()));
        Page.getDriver().manage().window().maximize();
    }

    @After
    public void shoutDown() {
        if (Page.getDriver() != null) {
            Page.getDriver().quit();
        }
    }
}



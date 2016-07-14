import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;
import java.net.URL;
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
        URL test = testStream;
        System.setProperty("webdriver.chrome.driver", "Z:/Downloads/ChromeDriver/chromedriver.exe");
        homePage = new HomePage(new RemoteWebDriver(test, DesiredCapabilities.chrome()));
        Page.getDriver().manage().window().maximize();
    }

    @After
    public void shoutDown() {
        if (Page.getDriver() != null) {
            Page.getDriver().quit();
        }
    }
}



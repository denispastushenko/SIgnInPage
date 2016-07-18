package utils;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriwerSetUp {

        public static DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();

        public static WebDriver createDriver(boolean isProxy) {
            setCapabilities(isProxy);
            try {
                return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Driver cannot be created!");
            }
        }

        private static void setCapabilities(boolean isProxy) {
            if (isProxy) {
                Proxy proxy = new Proxy();
                proxy.setHttpProxy("http://localhost:1128");
                proxy.setSslProxy("http://localhost:1128");
                desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);
            }
            desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        }
}

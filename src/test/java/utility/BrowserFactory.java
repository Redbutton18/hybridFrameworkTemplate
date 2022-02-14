package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.util.TimeUtils;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appURL){
        if (browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browserName.equals("Firefox")){
            //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver = new FirefoxDriver();
        } else if(browserName.equals("IE")){
            //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("We  don't support this browser");
        }
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);

        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}

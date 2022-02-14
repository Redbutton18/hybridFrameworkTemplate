package pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.BrowserFactory;
import utility.ConfigDataProvider;
import utility.ExcelDataProvider;
import utility.Helper;

import java.io.IOException;

public class BaseClass {
    public WebDriver driver;
    public ConfigDataProvider config;

    public ExcelDataProvider excel = new ExcelDataProvider();;

    public BaseClass() throws IOException {
    }

    @BeforeSuite
    public void setupExcelDataProvider() throws IOException {
        config = new ConfigDataProvider();
    }

    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL()); //Param usage from config file
    }

//    @Parameters
//    @BeforeClass
//    public void setUp(String browser) {
////        driver = BrowserFactory.startApplication(driver, browser, config.getURL()); //mvn install -Dbrowser=Chrome -DxmlFiles=testng.xml
//    }

    @AfterClass
    public  void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE)
        Helper.captureScreenshot(driver);
    }
}

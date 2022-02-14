package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;
import utility.ExcelDataProvider;
import utility.Helper;

import java.io.IOException;

public class LoginCRMTest extends BaseClass{
    String userName = excel.getStringData("Login", 0, 0);
    String password = excel.getStringData("Login", 0, 1);

    public LoginCRMTest() throws IOException {
    }

    @Test
    public void loginApp() throws InterruptedException, IOException {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.loginToCRM(userName, password);

        Thread.sleep(2000);
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    public LoginPage (WebDriver ldriver){
        this.driver = ldriver;
    }

    @FindBy(name = "username") WebElement username;
    @FindBy(name = "password") WebElement password;
    @FindBy(className = "btn") WebElement loginButton;

    public void loginToCRM(String name, String userPassword) {
        username.sendKeys(name);
        password.sendKeys(userPassword);
        loginButton.click();
    }
}

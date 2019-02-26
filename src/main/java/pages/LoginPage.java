package pages;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject{

    @FindBy(id = "edit-name-des")
    private WebElement userNameInputField;

    @FindBy(id = "edit-pass-des")
    private WebElement passwordInputField;

    @FindBy(id = "edit-submit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    protected void isLoaded() {
        // check page is Loaded if needed
    }

    public HomePage login(){
        enterUserName(Config.USER_NAME);
        enterPassword(Config.PASSWORD);
        submitButton.click();
        return new HomePage(driver);
    }
    private void enterUserName(String userName){
        logInputAction("user name field", userName);
        userNameInputField.click();
        driver.findElement(By.id("edit-name")).sendKeys(userName);
    }
    private void enterPassword(String password){
        logInputAction("password field", password);
        passwordInputField.click();
        driver.findElement(By.id("edit-pass")).sendKeys(password);
    }

    @Override
    protected String getTitle() {
        return "Qmarkets Innovation Management";
    }
}

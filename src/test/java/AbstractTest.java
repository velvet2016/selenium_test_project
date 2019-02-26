

import config.Config;
import enums.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public abstract   class AbstractTest {
    protected static WebDriver driver;

    @BeforeSuite
    public static void setUp() {
        driver = Browser.valueOf(Config.BROWSER).getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }

    protected HomePage loadQmarketsAndLogin() {
        driver.get(Config.URL);
        if (isProfileIconPresented(driver)) {
            return new HomePage(driver);
        }
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.login();
    }

    private boolean isProfileIconPresented(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Config.ZERO, TimeUnit.SECONDS);
        int size = driver.findElements(By.xpath(".//*[@id='user-nav']/div/div[1]")).size();
        driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return size > 0;
    }

    protected String getRandomString() {
        return UUID.randomUUID().toString();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException
    {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target\\screenshots\\"+testResult.getName()+".jpg"));
        }
    }
}
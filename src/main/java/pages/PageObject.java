package pages;

import config.Config;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public abstract class PageObject{
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        logger.info("loading page: " + this.getClass().getSimpleName());
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("chekcing page title");
        String actualTitle = driver.getTitle();
        if (isCheckTitleNeeded() && !actualTitle.equals(getTitle())){
            throw new IllegalStateException("Page was not loaded. Expected page title "+getTitle()+"but actual: "+actualTitle);
        }
        logger.info("chekcing page title: Success");
        logger.info("Page loaded: " + this.getClass().getSimpleName());
    }
    abstract protected  void isLoaded();

    public Logger logger = Logger.getLogger(this.getClass());

    protected void waitForVisibility(WebElement element) throws Error{
        logger.debug("waiting till element " + element.toString() + " loaded");
        turnOffImplicitWait();
        waitForWisibilityExplicitly(element);
        turnOnImplicitWait();
    }

    private void waitForWisibilityExplicitly(WebElement element) {
        int secondsToWait = Config.EXPLICIT_WAIT_SMALL;
        logger.debug("waiting till element " + element.toString() + " become visible. Explicit wait = "+secondsToWait);
        new WebDriverWait(driver, secondsToWait).until(ExpectedConditions.visibilityOf(element));
    }

    protected WebDriver.Timeouts turnOnImplicitWait() {
        logger.debug("turning ON implicit wait:"+ Config.IMPLICIT_WAIT);
        return driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    protected void turnOffImplicitWait() {
        logger.debug("turning OFF implicit wait");
        driver.manage().timeouts().implicitlyWait(Config.ZERO, TimeUnit.SECONDS);
    }

    protected void logInputAction(String inputFieldName, String inputValue){
        logger.info("typing \""+inputValue+"\" to  \""+ inputFieldName+"\"");
    }

    protected void logClick(String objectToClick){
        logger.info("click  on "+"\""+ objectToClick+"\"");
    }
    protected abstract String getTitle();

    protected  boolean isCheckTitleNeeded(){
        return true;
    };
}

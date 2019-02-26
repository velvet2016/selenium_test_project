package pages.spontaneousIdea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FillInYourIdeaPage extends SpontaneousIdeasPage {
    @FindBy(xpath = ".//*[@id='edit-title']")
    private WebElement titleInputField;

    @FindBy(xpath = ".//*[@id='edit-confidential']")
    private WebElement isConfidentialCheckBox;

    @FindBy(xpath = ".//*[@id='edit-qm-anonymous-is-anonymous']")
    private WebElement isAnonymousCheckBox;

    @FindBy(xpath = ".//*[@id='edit-qm-node-wizard-next']")
    private WebElement nextButton;

    public FillInYourIdeaPage(WebDriver driver) {
        super(driver);
    }

    public void enterDescription(String desc) {
        logInputAction("Description", desc);
        WebDriver frameDriver = driver.switchTo().frame(0);
        frameDriver.findElement(By.xpath("//body")).sendKeys(desc);
        driver.switchTo().defaultContent();

    }

    public void enterTitle(String title) {
        logInputAction("Title", title);
        titleInputField.sendKeys(title);
    }

    public void markIsConfidential() {
        logClick("is Confidential");
        isConfidentialCheckBox.click();
    }

    public void markIsAnonymous() {
        logClick("is Anonymous");
        isAnonymousCheckBox.click();
    }

    public DuplicateCheckIdeaPage clickNext() {
        logClick("Next Button");
        nextButton.click();
        return new DuplicateCheckIdeaPage(driver);
    }

    @Override
    protected String getTitle() {
        return "Spontaneous Ideas - Submit Idea";
    }
}

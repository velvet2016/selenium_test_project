package pages.spontaneousIdea;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DuplicateCheckIdeaPage extends SpontaneousIdeasPage {

    @FindBy(xpath = ".//*[@id='messages-wrapper']/div")
    private WebElement submitStatusMessage;

    @FindBy(xpath = ".//*[@id='qm-node-wizard-build-form']/div")
    private WebElement duplicateStatusMessage;

    @FindBy(xpath = ".//*[@id='edit-qm-node-wizard-finish']")
    private WebElement publishButton;


    public DuplicateCheckIdeaPage(WebDriver driver) {
        super(driver);
    }

    public String getSubmitStatusMessage(){
        logger.info("getting Submit Status message");
        try {
            String status = submitStatusMessage.getText();
            logger.info("submit Status message is :" + status);
            return status;
        } catch (NoSuchElementException e) {
            logger.warn("Submit status message is absent");
        }
        return "";
    }
    public String getDuplicateStatusMessage(){
        logger.info("getting Duplicate Status message");
        try {
            String status = duplicateStatusMessage.getText();
            logger.info("duplicate Status message is :" + status);
            return status;
        } catch (NoSuchElementException e) {
            logger.warn("duplicate status message is absent");
        }
        return "";
    }

    @Override
    protected void isLoaded() {
        System.out.println("askdjhlakjsdha");
        super.isLoaded();
        waitForVisibility(submitStatusMessage);
        waitForVisibility(duplicateStatusMessage);
    }

    public DiscussionIdeaPage clickOnPublishButton(){
        logger.info("click on Publish button");
        publishButton.click();
        return new DiscussionIdeaPage(driver);
    }

    @Override
    protected String getTitle() {
        return "Spontaneous Ideas";
    }
}

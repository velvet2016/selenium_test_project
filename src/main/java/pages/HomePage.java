package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.spontaneousIdea.FillInYourIdeaPage;

public class HomePage extends Header{

    @FindBy(xpath = ".//*[@id='random-campaign']/div/div[2]/a")
    private WebElement submitYourRandomIdeaButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public FillInYourIdeaPage clickOnSubmitYourRandomIdeaButton(){
        logClick("Submit Your Random Idea");
        submitYourRandomIdeaButton.click();
        return new FillInYourIdeaPage(driver);
    }

    @Override
    protected String getTitle() {
        return "Qmarkets Innovation Management";
    }
}

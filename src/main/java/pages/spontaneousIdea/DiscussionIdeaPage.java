package pages.spontaneousIdea;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiscussionIdeaPage extends SpontaneousIdeasPage {

    @FindBy(xpath = ".//tbody//h2[@class='art-postheader']")
    private WebElement ideaIdField;

    public DiscussionIdeaPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected boolean isCheckTitleNeeded() {
        return false;
    }

    public Long getIdeaId(){
        String rawId = ideaIdField.getText();
        Pattern p = Pattern.compile("\\(#(\\d+)\\)");
        Matcher m = p.matcher(rawId.trim());
        return m.find() ? Long.parseLong(m.group(1)) : null;

    }
}

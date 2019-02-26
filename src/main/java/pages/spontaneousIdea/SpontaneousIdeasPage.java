package pages.spontaneousIdea;

import org.openqa.selenium.WebDriver;
import pages.Header;


public class SpontaneousIdeasPage extends Header {
    public SpontaneousIdeasPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getTitle() {
        return "Spontaneous Ideas";
    }
    //common staff for Spontaneous Idea pages
}

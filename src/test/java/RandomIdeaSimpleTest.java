import domainObjects.Idea;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import pages.search.AdvancedSearchPage;
import pages.spontaneousIdea.DuplicateCheckIdeaPage;
import pages.spontaneousIdea.DiscussionIdeaPage;
import pages.spontaneousIdea.FillInYourIdeaPage;

@Listeners(ListenerClass.class)
public class RandomIdeaSimpleTest extends AbstractTest {

    @Test
    public void testSubmitRandomIdea() throws Exception {
        Idea idea = getIdeaForTest();
        HomePage homePage = loadQmarketsAndLogin();
        FillInYourIdeaPage fillIdeaPage = homePage.clickOnSubmitYourRandomIdeaButton();
        fillIdeaPage.enterTitle(idea.getTitle());
        fillIdeaPage.enterDescription(idea.getDescription());
        fillIdeaPage.markIsConfidential();
        fillIdeaPage.markIsAnonymous();
        DuplicateCheckIdeaPage checkDuplicatePage = fillIdeaPage.clickNext();
        checkDuplicatePage.getSubmitStatusMessage();
        checkDuplicatePage.getDuplicateStatusMessage();
        DiscussionIdeaPage discussionIdeaPage = checkDuplicatePage.clickOnPublishButton();
        idea.setId(discussionIdeaPage.getIdeaId());
        AdvancedSearchPage advancedSearchPage = discussionIdeaPage.gotoAdvancedSearch();
        Idea actualIdea = advancedSearchPage.getIdeaById(idea.getId());
        advancedSearchPage.logOut();
        Assert.assertEquals(idea,actualIdea); // used simplified equals, just for demo
    }

    private Idea getIdeaForTest() {
        return new Idea(
                getRandomString(),
                "Confidential",
                "Anonymous",
                "Spontaneous Ideas",
                "Discussion",
                getRandomString()
        );
    }

}

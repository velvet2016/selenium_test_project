package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.search.AdvancedSearchPage;

public abstract class Header extends PageObject {

    @FindBy(xpath = ".//*[@id='menu-356']/a/span[3]")
    private WebElement home;

    @FindBy(xpath = ".//*[@id='search-nav']/div/div[1]")
    private WebElement searchIcon;

    @FindBy(xpath = ".//a[text()='Advanced Search']")
    private WebElement advancedSearchDropdownMenu;

    @FindBy(xpath = ".//a[text()='Logout']")
    private WebElement logoutDropDownMenu;

    @FindBy(xpath = ".//*[@id='user-nav']/div/div[1]")
    private WebElement profileIcon;

    public Header(WebDriver driver) {
        super(driver);
    }

    protected void isLoaded() {
        //check is loaded if needed
    }

    public AdvancedSearchPage gotoAdvancedSearch(){
        logClick("Search Icon");
        searchIcon.click();
        waitForVisibility(advancedSearchDropdownMenu);
        logClick("Advanced Search Drop Down Menu");
        advancedSearchDropdownMenu.click();
        return new AdvancedSearchPage(driver);
    }

    public LoginPage logOut(){
        logClick("Profile Icon");
        profileIcon.click();
        waitForVisibility(logoutDropDownMenu);
        logClick("Log Out Drop Down Menu");
        logoutDropDownMenu.click();
        return new LoginPage(driver);
    }

}

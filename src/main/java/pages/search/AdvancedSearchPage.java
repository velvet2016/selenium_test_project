package pages.search;

import domainObjects.Idea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.util.Strings;
import pages.Header;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedSearchPage extends Header {

    @FindBy(xpath = "//div[@class='view-content view-content-advanced-search-basic']//tbody")
    private WebElement searchResultTable;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public Idea getIdeaById(Long id){
        logger.info("getting data from first row of result search");
        WebElement searchResultRow = searchResultTable.findElement(By.xpath("tr/td[text()='"+id+"']/.."));
        return getIdeaFromResultSearchRow(searchResultRow);
    }


    public Idea getFirstIdea(){
        logger.info("getting data from first row of result search");
        WebElement searchResultRow = searchResultTable.findElement(By.xpath("./tr[1]"));
        return getIdeaFromResultSearchRow(searchResultRow);
    }

    public Map<Long, Idea> getAllSearchResult(){
        turnOffImplicitWait();
        List<WebElement> searchResultRows = searchResultTable.findElements(By.xpath("./tr"));
        Map<Long, Idea> map = searchResultRows.stream().map(this::getIdeaFromResultSearchRow).collect(Collectors.toMap(Idea::getId, idea -> idea));
        turnOnImplicitWait();
        return map;
    }


    private Idea getIdeaFromResultSearchRow(WebElement searchResultRow) {
        turnOffImplicitWait();
        List<WebElement> elements = searchResultRow.findElements(By.xpath("./td"));
        turnOnImplicitWait();
        return getRecordFromElements(elements);
    }

    private Idea getRecordFromElements(List<WebElement> elements){
        Idea record = new Idea();
        record.setId(getLong(elements.get(0).getText()));
        record.setTitle(elements.get(1).getText());
        record.setConfidentiality(elements.get(2).getText());
        record.setAutor(elements.get(3).getText());
        record.setCampaign(elements.get(4).getText());
        record.setSubmissionDate(elements.get(5).getText());
        record.setState(elements.get(6).getText());
        record.setDescription(elements.get(7).getText());
        WebElement commentColumn = elements.get(8);
        turnOffImplicitWait();
        List<WebElement> commentElements = commentColumn.findElements(By.xpath("./div"));
        turnOnImplicitWait();
        record.setComments(commentElements.stream().map(WebElement::getText).collect(Collectors.toList()));
        record.setDiscussionAvgRating(getDouble(elements.get(9).getText()));
        record.setDiscussionRaters(getLong(elements.get(10).getText()));
        return record;
    }

    private Double getDouble(String text) {
        return text!=null && !Strings.isNullOrEmpty(text) ? Double.parseDouble(text): null;
    }
    private Long getLong(String text) {
        return text!=null && !Strings.isNullOrEmpty(text) ? Long.parseLong(text): null;
    }

    @Override
    protected String getTitle() {
        return "Advanced Search";
    }
}

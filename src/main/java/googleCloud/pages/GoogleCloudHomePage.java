package googleCloud.pages;

import defaultPage.DefaultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.VisibleAjaxElementFactory;
import java.util.List;

public class GoogleCloudHomePage extends DefaultPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    @FindBy(tagName = "input")
    private List<WebElement> searchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new VisibleAjaxElementFactory(driver, 10), this);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
        logger.info("Homepage opened");
    }

    public void enterSearchTerm(String value) {
        searchInput.get(0).click();
        searchInput.get(0).sendKeys(value);
        logger.info("Search term entered");
    }

    public void runSearch() {
        searchInput.get(0).submit();
        logger.info("Search ran");
    }
}
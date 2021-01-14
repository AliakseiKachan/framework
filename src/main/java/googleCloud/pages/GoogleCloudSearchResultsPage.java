package googleCloud.pages;

import defaultPage.DefaultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.VisibleAjaxElementFactory;

public class GoogleCloudSearchResultsPage extends DefaultPage {

    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator'" +
            "and parent::div[@class='gs-title']]/b")
    private WebElement calculatorPageLocator;

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new VisibleAjaxElementFactory(driver, 10), this);
    }

    public void goToCalculatorPage() {
        calculatorPageLocator.click();
        logger.info("Switching to google cloud calculator page");
    }
}
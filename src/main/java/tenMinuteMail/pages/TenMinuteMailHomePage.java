package tenMinuteMail.pages;

import defaultPage.DefaultPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.VisibleAjaxElementFactory;
import java.util.ArrayList;
import java.util.List;

public class TenMinuteMailHomePage extends DefaultPage {

    @FindBy(id = "mail_address")
    private WebElement copyEmailLocator;

    @FindBy(className = "message_top")
    private WebElement messageLocator;

    @FindBy(tagName = "h3")
    private List<WebElement> totalCostInEmailLocator;

    public TenMinuteMailHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new VisibleAjaxElementFactory(driver, 10), this);
    }

    public void copyEmail() {
        for (int i = 0; i < 10; i++) {
            copyEmailLocator.sendKeys(Keys.CONTROL + "c");
        }
        logger.info("Email address copied");
    }

    public void switchToCalculator() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        logger.info("Switched to calculator");
    }

    public void openMailMessage() {
        new WebDriverWait(driver, 30).until(ExpectedConditions
                .visibilityOf(messageLocator)).click();
        logger.info("Email message opened");
    }

    public String getTotalEstimatedCostFromEmailAsString() {
        logger.info("Total estimated cost in email: " + totalCostInEmailLocator.get(2).getText());
        return totalCostInEmailLocator.get(2).getText();
    }
}
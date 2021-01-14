package googleCloud.pages;

import defaultPage.DefaultPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.VisibleAjaxElementFactory;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoogleCloudCalculatorPage extends DefaultPage {

    private String currentText;

    @FindBy(xpath = "//iframe[starts-with(@src, '/products')]")
    private WebElement parentFrame;

    @FindBy(id = "myFrame")
    private WebElement childFrame;

    @FindBy(id = "input-0")
    private WebElement searchForAProduct;

    @FindBy(xpath = "//span[@class='highlight']/..")
    private List<WebElement> computeEngine;

    @FindBy(xpath = "//label[contains(text(), 'Number of instances')]/../input[@name='quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//label[text()='Operating System / Software']/../md-select")
    private WebElement operatingSystem;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='md-text']")
    private List<WebElement> requiredOSValue;

    @FindBy(xpath = "//label[text()='Machine Class']/../md-select")
    private WebElement machineClass;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='md-text']")
    private List<WebElement> requiredMachineClass;

    @FindBy(xpath = "//label[text()='Series']/following-sibling::md-select")
    private WebElement series;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='md-text ng-binding']")
    private List<WebElement> requiredSeries;

    @FindBy(xpath = "//label[text()='Machine type']/following-sibling::md-select")
    private WebElement machineType;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='md-text ng-binding']")
    private List<WebElement> requiredMachineType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/" +
            "child::div[starts-with(@class, 'md-container')]")
    private WebElement addGPUCheckbox;

    @FindBy(xpath = "//label[text()='Number of GPUs']/../md-select")
    private WebElement gpuCount;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='md-text ng-binding']")
    private List<WebElement> requiredGPUCount;

    @FindBy(xpath = "//label[text()='GPU type']/../md-select")
    private WebElement gpuType;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='md-text ng-binding']")
    private List<WebElement> requiredGPUType;

    @FindBy(xpath = "//label[text()='Local SSD']/../md-select")
    private List<WebElement> localSSD;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='md-text ng-binding']")
    private List<WebElement> requiredLocalSSD;

    @FindBy(xpath = "//label[text()='Datacenter location']/../md-select")
    private List<WebElement> location;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='md-text ng-binding']")
    private List<WebElement> requiredLocation;

    @FindBy(xpath = "//label[text()='Committed usage']/../md-select")
    private List<WebElement> committedUsage;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='md-text']")
    private List<WebElement> requiredCommittedUsage;

    @FindBy(css = "button[ng-click^='listingCtrl.addComputeServer(ComputeEngineForm)']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//h2/b[@class='ng-binding']")
    private WebElement totalEstimateCost;

    @FindBy(xpath = "//body[@type='marketing']")
    private WebElement body;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//md-dialog-actions/child::button")
    private List<WebElement> sendEmailButton;

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new VisibleAjaxElementFactory(driver, 10), this);
    }

    public void activateComputeEngine() {
        driver.switchTo().frame(parentFrame);
        driver.switchTo().frame(childFrame);
        searchForAProduct.click();
        computeEngine.get(0).click();
        logger.info("Compute Engine activated");
    }

    public void enterInstancesNumber(Keys keys) {
        numberOfInstances.sendKeys(keys);
        logger.info("Instances number entered: " + keys.name());
    }

    public void enterOSType(int value) {
        operatingSystem.click();
        currentText = requiredOSValue.get(value).getText();
        requiredOSValue.get(value).click();
        logger.info("OS type entered: " + currentText);
    }

    public void enterMachineClass(int value) {
        machineClass.click();
        currentText = requiredMachineClass.get(value).getText();
        requiredMachineClass.get(value).click();
        logger.info("Machine class entered: " + currentText);
    }

    public void enterSeries(int value) {
        series.click();
        currentText = requiredSeries.get(value).getText();
        requiredSeries.get(value).click();
        logger.info("Series entered: " + currentText);
    }

    public void enterMachineType(int value) {
        machineType.click();
        currentText = requiredMachineType.get(value).getText();
        requiredMachineType.get(value).click();
        logger.info("Machine type entered: " + currentText);
    }

    public void markAddGPUCheckbox() {
        addGPUCheckbox.click();
        logger.info("GPU checkbox marked");
    }

    public void enterNumberOfGPUs(int value) {
        gpuCount.click();
        currentText = requiredGPUCount.get(value).getText();
        requiredGPUCount.get(value).click();
        logger.info("GPUs number entered: " + currentText);
    }

    public void enterGPUType(int value) {
        gpuType.click();
        currentText = requiredGPUType.get(value).getText();
        requiredGPUType.get(value).click();
        logger.info("GPU type entered: " + currentText);
    }

    public void enterLocalSSD(int value) {
        localSSD.get(0).click();
        currentText = requiredLocalSSD.get(value).getText();
        requiredLocalSSD.get(value).click();
        logger.info("Local SSD entered: " + currentText);
    }

    public void enterDatacenterLocation(int value) {
        location.get(0).click();
        currentText = requiredLocation.get(value).getText();
        requiredLocation.get(value).click();
        logger.info("Datacenter location entered: " + currentText);
    }

    public void enterCommittedUsage(int value) {
        committedUsage.get(0).click();
        requiredCommittedUsage.get(value).click();
        logger.info("Committed usage entered");
    }

    public void addToEstimate() {
        addToEstimateButton.click();
        logger.info("All forms filled & added to estimate");
    }

    public void openLinkInNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
        logger.info("Switched to mail service in new tab");
    }

    public void emailEstimate() {
        driver.switchTo().activeElement();
        driver.switchTo().frame(parentFrame);
        driver.switchTo().frame(childFrame);
        emailEstimateButton.click();
        logger.info("Email form opened");
    }

    public void enterEmail() {
        try {
            inputEmail.sendKeys((String) Toolkit.getDefaultToolkit().getSystemClipboard()
                    .getData(DataFlavor.stringFlavor));
            logger.info("Email entered: " + Toolkit.getDefaultToolkit().getSystemClipboard()
                    .getData(DataFlavor.stringFlavor));
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
    }

    public void sendEmail() {
        sendEmailButton.get(1).click();
        logger.info("Email sent");
    }

    public void switchToTenMinuteMail() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        logger.info("Switched to mail service");
    }

    public String getTotalEstimateCostAsString() {
        logger.info("Received " + totalEstimateCost.getText());
        return totalEstimateCost.getText();
    }
}
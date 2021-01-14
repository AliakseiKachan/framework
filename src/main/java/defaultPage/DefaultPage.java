package defaultPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DefaultPage {

    protected WebDriver driver;
    protected Logger logger = LogManager.getRootLogger();

    public DefaultPage(WebDriver driver) {
        this.driver = driver;
    }
}
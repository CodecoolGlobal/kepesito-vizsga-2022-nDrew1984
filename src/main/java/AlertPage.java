import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {
    public AlertPage(WebDriver driver) {
        super(driver);
    }

    private final String url = "https://demo.seleniumeasy.com/bootstrap-modal-demo.html";
    private final By modal1 = By.xpath("(//*[@class=\"btn btn-primary\"])[1]");
    private final By modal1Text = By.xpath("(//*[@class=\"modal-body\"])[1]");
    private final By alertCloseButton = By.xpath("(//*[@class=\"btn\"])[1]");

    public void navigate() {
        driver.get(url);
    }
    public void clickModal1() {
        driver.findElement(modal1).click();
    }
    public String getAlertText() {
        return driver.findElement(modal1Text).getText();
    }
    public void clickAlertClose() {
        driver.findElement(alertCloseButton).click();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicFirstFormDemoPage extends BasePage {
    public BasicFirstFormDemoPage(WebDriver driver) {
        super(driver);
    }

    private final String url = "https://demo.seleniumeasy.com/basic-first-form-demo.html";
    private final By sum1Field = By.id("sum1");
    private final By sum2Field = By.id("sum2");
    private final By getTotal = By.xpath("(//*[@class=\"btn btn-default\"])[2]");
    private final By total = By.id("displayvalue");

    public void navigate() {
        driver.get(url);
    }
    public void enterA(String s) {
        driver.findElement(sum1Field).sendKeys(s);
    }
    public void enterB(String s) {
        driver.findElement(sum2Field).sendKeys(s);
    }
    public void clickGetTotal() {
        driver.findElement(getTotal).click();
    }
    public String totalString() {
        return driver.findElement(total).getText();
    }

}

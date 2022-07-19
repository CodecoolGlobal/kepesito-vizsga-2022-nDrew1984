import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectPage extends BasePage {
    public SelectPage(WebDriver driver) {
        super(driver);
    }

    private final String url = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    private final By selectDay = By.id("select-demo");
    private final By resultDay = By.xpath("//*[@class=\"selected-value\"]");

    public void navigate() {
        driver.get(url);
    }
    public void selectDay(String s) {
        Select select = new Select(driver.findElement(selectDay));
        select.selectByVisibleText(s);
    }
    public String getDayResult() {
        return driver.findElement(resultDay).getText();
    }
}

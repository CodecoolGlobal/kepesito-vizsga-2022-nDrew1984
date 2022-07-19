import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NameCardsPage extends BasePage {
    public NameCardsPage(WebDriver driver) {
        super(driver);
    }

    private final String url = "https://demo.seleniumeasy.com/data-list-filter-demo.html";
    private final By nameCards = By.xpath("//*[@class=\"searchable-container\"]/div/div");
    private final By names = By.xpath("./h4");

    public void navigate() {
        driver.get(url);
    }

    public List<String> getNames() {
        List<String> namesList = new ArrayList<>();
        List<WebElement> nameCardList = driver.findElements(nameCards);
        for (int i = 0; i < nameCardList.size(); i++) {
            String name = nameCardList.get(i).findElement(names).getText();
            name = name.replace("Name: ", "");
            namesList.add(name);
        }
        return namesList;
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TablePage extends BasePage {
    public TablePage(WebDriver driver) {
        super(driver);
    }

    private final String url = "https://demo.seleniumeasy.com/table-data-download-demo.html";
    private final By rows = By.xpath("//*[@id=\"example\"]/tbody/tr");
    private final By names = By.xpath("./td[1]");

    public void navigate() {
        driver.get(url);
    }
    public void createFile(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
    }
    public void saveData(String filename) throws IOException {
        List<WebElement> records = driver.findElements(rows);
        FileWriter writer = new FileWriter(filename);

        for (int i = 0; i < records.size(); i++) {
            String name = records.get(i).findElement(names).getText();
            writer.write(name + "\r\n");
        }
        writer.close();
    }
    public int getSize() {
        List<WebElement> tableRecords = driver.findElements(rows);
        return tableRecords.size();
    }
}

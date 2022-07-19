import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    /*
    Tölts be a böngészőbe az alábbi oldalt: https://demo.seleniumeasy.com/basic-first-form-demo.html
    Írj tesztesetet két szám összegének ellenőrzésére a mellékelt dokumentumban,
    majd a tesztlépések alapján írj automatizált tesztet.
    Az oldalon, a Two Input Fields” szekcióban két beviteli mezőjét töltsd ki tetszőleges számokkal,
    majd végezd el a számok összeadásának ellenőrzését kiolvasva az oldalon megjelenő összeget.
    Használj tetszőleges tesztadatot
     */
    @Test
    public void TestInput() {
        BasicFirstFormDemoPage basicFirstFormDemoPage = new BasicFirstFormDemoPage(driver);
        basicFirstFormDemoPage.navigate();
        basicFirstFormDemoPage.closePopupWindow();

        // test data:
        String a = "12";
        String b = "13";

        basicFirstFormDemoPage.enterA(a);
        basicFirstFormDemoPage.enterB(b);
        basicFirstFormDemoPage.clickGetTotal();

        String exp = "25";
        String act = basicFirstFormDemoPage.totalString();

        Assertions.assertEquals(exp, act);

    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: zhttps://demo.seleniumeasy.com/basic-select-dropdown-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet a következők szerint:
    a Select List Demo szekció lenyíló mezőjében válaszd ki a hét utolsó napját és ellenőrizd,
    hogy az oldalon helyesen jelenik meg a kiválasztott érték
    Tesztadatként használd az hét utolsó napját
     */
    @Test
    public void SelectDayTest() {
        SelectPage selectPage = new SelectPage(driver);
        selectPage.navigate();

        // test data:
        String day = "Sunday";

        selectPage.selectDay(day);

        String exp = "Day selected :- " + day;
        String act = selectPage.getDayResult();
        Assertions.assertEquals(exp, act);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/bootstrap-modal-demo.html#
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet.
    A tesztesetben ellenőrizd a modal alert ablak szöveges tartalmát összahasonlítva egy általad definiált elvárt eredménnyel.
    Nyisd meg a Single Modal ablakot, tárolt el az ablakon megjelenő szöveget egy változóba és zárd be az ablakot a bezárás gombbal
     */
    @Test
    public void AlertTest() throws InterruptedException {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.navigate();

        alertPage.clickModal1();
        Thread.sleep(1000);

        String exp = "This is the place where the content for the modal dialog displays";
        String act = alertPage.getAlertText();
        Assertions.assertEquals(exp, act);
        Thread.sleep(1000);

        alertPage.clickAlertClose();
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/data-list-filter-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet.
    A teszteset ellenőrizze a névjegykártyák tartalmát.Olvasd ki a neveket a megjelenő névjegykártyákról
    és ellenőrzésként hasonlítsd össze egy elvárt eredményként megadott listával.
    Használj relatív útvonalat a névjegykártya név elemeinek kiolvasásához.
     */
    @Test
    public void NamecardTest() {
        NameCardsPage nameCardsPage = new NameCardsPage(driver);
        nameCardsPage.navigate();

        List<String> exp = new ArrayList<>();
        exp.add("Tyreese Burn");
        exp.add("Brenda Tree");
        exp.add("Glenn Pho shizzle");
        exp.add("Brian Hoyies");
        exp.add("Glenn Pho shizzle");
        exp.add("Arman Cheyia");

        List<String> act = nameCardsPage.getNames();

        Assertions.assertIterableEquals(exp, act);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/table-data-download-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet.
    A tesztesetet ellenőrizze a táblázatból a neveket, amelyeket a táblázat első oszlop tartalmaz.
    Gyűjtsd össze a neveket és tárold le a names.txt fájlba majd a tesztesetben
    a fájl tartalmát hasonlítsd össze egy elvárt eredménnyel.
     */
    @Test
    public void TableTest() throws IOException {
        TablePage tablePage = new TablePage(driver);
        tablePage.navigate();

        // creating file: names.txt
        String filename = "names.txt";
        tablePage.createFile(filename);


        tablePage.saveData(filename);

        int exp = 31;
        int act = tablePage.getSize();

        Assertions.assertEquals(exp, act);

    }

}

package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest(){

         //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit URL
        driver.get("https://demoqa.com");

        //facem browser-ul in mod maximize
        driver.manage().window().maximize();

        //Obiecte

        HomePage homePage = new HomePage(driver);
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage= new ElementsPage(driver);
        elementsPage.selectWebTableSubmenu();

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.addEntry("Ioana","Pavilencu","ioana.pavilencu@yahoo.com",
                "27","5000","Testing");
        webTablePage.editEntry("25000","HR");
        webTablePage.deleteEntry();

        driver.quit();

        
    }
}

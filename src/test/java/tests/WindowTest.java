package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowTest {
    public WebDriver driver;

    @Test
    public void metodaTest(){

        //deschidem un browser

        driver = new ChromeDriver();

        //accesam un anumit URL

        driver.get("https://demoqa.com");

        //facem browser-ul in mod maximize

        driver.manage().window().maximize();

        //Definim un obiect de tipul Window Methods
        WindowMethods windowMethods = new WindowMethods(driver);
        ElementMethods elementMethods =new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);

        //facem un scroll la pagina pentru vizibilitate
       //JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //interactionam cu meniul/submeniul de pe site
        WebElement alertMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertMenu.click();
        elementMethods.clickElement(alertMenu);

       // js.executeScript("window.scrollBy(0,100)");
        pageMethods.scrollPage(0,100);
        WebElement browserWindow = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        //browserWindow.click();
        elementMethods.clickElement(browserWindow);


        WebElement newTab = driver.findElement(By.id("tabButton"));
        //newTab.click();
        elementMethods.clickElement(newTab);


        //Interactionam cu un tab/window

        System.out.println(driver.getCurrentUrl()); //titlul paginii curente pe care ne aflam

        //List<String> tabs = new ArrayList<>(driver.getWindowHandles());//gaseste cate tab-uri/window sunt deschise in momentul definirii
        //ne mutam cu focusul pe un anumit tab
        //driver.switchTo().window(tabs.get(1));
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl()); //titlul paginii curente pe care ne aflam

        //Inchidem tab-ul curent
        //driver.close();
        windowMethods.closeCurrentTab();
        //driver.switchTo().window(tabs.get(0));
        windowMethods.switchSpecificTab(0);

        WebElement newWindow = driver.findElement(By.id("windowButton"));
        //newWindow.click();
        elementMethods.clickElement(newWindow);

        System.out.println(driver.getCurrentUrl()); //titlul paginii curente pe care ne aflam

        //List<String> window = new ArrayList<>(driver.getWindowHandles());//gaseste cate tab-uri/window sunt deschise in momentul definirii
        //ne mutam cu focusul pe un anumit tab
        //driver.switchTo().window(window.get(1));
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl()); //titlul paginii curente pe care ne aflam

        //driver.close();
        windowMethods.closeCurrentTab();

        driver.quit();

    }
}

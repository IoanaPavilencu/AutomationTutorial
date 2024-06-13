package tests;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;

    @Test
    public void metodaTest(){

        //deschidem un browser

        driver = new ChromeDriver();

        //accesam un anumit URL

        driver.get("https://demoqa.com");


        //facem browser-ul in mod maximize

        driver.manage().window().maximize();

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Definim un obiect de tip alert methods ca sa apelam metodele generale din clasa
        AlertMethods alertMethods = new AlertMethods(driver);
        ElementMethods elementMethods=new ElementMethods(driver);
        PageMethods pageMethods=new PageMethods(driver);

        //facem un scroll la pagina pentru vizibilitate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //interactionam cu meniul/submeniul de pe site
        WebElement alertMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertMenu.click();
        elementMethods.clickElement(alertMenu);

        WebElement alertsubmenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        //alertsubmenu.click();
        elementMethods.clickElement(alertsubmenu);


        //Maximizam browserul:
        driver.manage().window().maximize();

        //interactionam cu prima alerta
        WebElement alertOkButton = driver.findElement(By.id("alertButton"));
        //alertOkButton.click();
        elementMethods.clickElement(alertOkButton);


        alertMethods.acceptAlert();

        //apasam butonul ok dupa ce apare alerta
       // Alert alertOk = driver.switchTo().alert();
       // System.out.println(alertOk.getText());
       // alertOk.accept();

        //interactionam cu a 3 a alerta
        WebElement alertConfirmButton = driver.findElement(By.id("confirmButton"));
        //alertConfirmButton.click();
        elementMethods.clickElement(alertConfirmButton);


        alertMethods.dismissAlert();
        //apasam butonul cancel dupa ce apare alerta
      //  Alert alertConfirm = driver.switchTo().alert();
        //System.out.println(alertConfirm.getText());
        //alertConfirm.dismiss();

        //interactionam cu a 4 a alerta
        WebElement alertPromtButton = driver.findElement(By.id("promtButton"));
        //alertPromtButton.click();
        elementMethods.clickElement(alertPromtButton);


        alertMethods.fillAlert("Ioana");

        //Alert alertPromt = driver.switchTo().alert();
        //System.out.println(alertPromt.getText());
        //String alertValue = "Ioana";
        //alertPromt.sendKeys(alertValue);
        //alertPromt.accept();

        //interactionam cu o alerta pentru care trebuie sa asteptam putin
        WebElement alertWait = driver.findElement(By.id("timerAlertButton"));
        //alertWait.click();
        elementMethods.clickElement(alertWait);


        alertMethods.acceptAlert();
        //definim un wait explicit
       // WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
       // webDriverWait.until(ExpectedConditions.alertIsPresent());
       // Alert waitConfirm=driver.switchTo().alert();
        //System.out.println(waitConfirm.getText());
       // waitConfirm.accept();
    }
}

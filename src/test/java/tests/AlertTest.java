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
import pages.AlertPage;
import pages.AlertsWindowsPage;
import pages.HomePage;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit URL
        driver.get("https://demoqa.com");

        //facem browser-ul in mod maximize
        driver.manage().window().maximize();

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //interactionam cu meniul/submeniul de pe site
        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToAlertsForm();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.interactAlertOK();
        alertPage.interactWithConfirmationButton();
        alertPage.interactWithPromtButton("Buton OK");
        alertPage.interactWithTimerAlert();

    }
}

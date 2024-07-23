package tests;

import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.WindowsPage;
import sharedData.SharedData;

public class WindowsTest extends SharedData {

    @Test
    public void metodaTest(){

        //Definim un obiect de tipul Window Methods
       /* WindowMethods windowMethods = new WindowMethods(driver);
        ElementMethods elementMethods =new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);
*/
        HomePage homePage =new HomePage(getDriver());
        homePage.navigateToAlertsMenu();

        AlertsWindowsPage alertsWindows =new AlertsWindowsPage(getDriver());
        alertsWindows.navigateToWindowPage();

        WindowsPage windowsPage = new WindowsPage(getDriver());
        windowsPage.interactWithNewTab();
        windowsPage.interactWithNewWindow();

    }
}

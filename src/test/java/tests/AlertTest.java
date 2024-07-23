package tests;

import org.testng.annotations.Test;
import pages.AlertPage;
import pages.AlertsWindowsPage;
import pages.HomePage;
import sharedData.SharedData;

public class AlertTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToAlertsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToAlertsForm();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.interactAlertOK();
        alertPage.interactWithConfirmationButton();
        alertPage.interactWithPromtButton("Buton OK");
        alertPage.interactWithTimerAlert();

    }
}

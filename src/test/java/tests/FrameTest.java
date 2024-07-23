package tests;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedFramePage;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void metodaTest(){

        AlertMethods alertMethods = new AlertMethods(getDriver());
        ElementMethods elementMethods = new ElementMethods(getDriver());
        PageMethods pageMethods = new PageMethods(getDriver());
        FrameMethods frameMethods = new FrameMethods(getDriver());

        HomePage homePage =new HomePage(getDriver());
        homePage.navigateToAlertsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToFramePage();

        FramePage framePage = new FramePage(getDriver());
        framePage.interectWithBigIFrame();
        framePage.interectWithSmallIFrame();
        framePage.navigateToNestedFrame();

        NestedFramePage nestedFramePage = new NestedFramePage(getDriver());
        nestedFramePage.interectWithNestedFrame();

    }
}

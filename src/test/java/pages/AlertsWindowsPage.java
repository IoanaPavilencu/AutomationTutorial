package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsWindowsPage extends BasePage{
    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindows;

    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement frameButton;

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsForm;

    public void navigateToWindowPage(){
        pageMethods.scrollPage(0,100);
        elementMethods.clickElement(browserWindows);
        LoggerUtility.info("The user clicks on Browser Windows");

    }

    public void navigateToFramePage() {
        pageMethods.scrollPage(0,100);
        elementMethods.clickElement(frameButton);
        LoggerUtility.info("The user clicks on Frame Button");

    }

    public void navigateToAlertsForm(){
        elementMethods.clickElement(alertsForm);
        LoggerUtility.info("The user clicks on Alerts Form");

    }
}

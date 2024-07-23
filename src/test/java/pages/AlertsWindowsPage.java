package pages;

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
    }

    public void navigateToFramePage() {
        pageMethods.scrollPage(0,100);
        elementMethods.clickElement(frameButton);
    }

    public void navigateToAlertsForm(){
        elementMethods.clickElement(alertsForm);
    }
}

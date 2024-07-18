package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindowsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public WindowMethods windowMethods;

    //Constructor
    public AlertsWindowsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods =new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindows;

    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement frameButton;

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsForm;

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

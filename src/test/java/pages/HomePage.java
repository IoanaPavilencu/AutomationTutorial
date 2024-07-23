package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertMenu;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;

    public void navigateToAlertsMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(alertMenu);

    }
    public void navigateToFormsMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(formsMenu);

    }
    public void navigateToElementsMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(elementsMenu);


    }

}

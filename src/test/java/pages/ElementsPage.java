package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage{
    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webtablesubmenu;

    public void selectWebTableSubmenu(){
        elementMethods.clickElement(webtablesubmenu);
        LoggerUtility.info("The user clicked on the Web Table submenu");
    }
}

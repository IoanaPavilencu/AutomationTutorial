package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage{
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTab;

    @FindBy(id ="windowButton")
    private WebElement newWindow;

    public void interactWithNewTab(){
        pageMethods.scrollPage(0,150);
        elementMethods.clickElement(newTab);

        System.out.println(driver.getCurrentUrl()); //URL-ul paginii curente pe care ne aflam
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
    }

    public void  interactWithNewWindow(){
        pageMethods.scrollPage(0,150);
        newWindow.click();

        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
    }
}

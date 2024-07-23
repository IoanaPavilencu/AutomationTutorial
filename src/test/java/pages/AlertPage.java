package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{
    public AlertPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id="alertButton")
    private WebElement alertButtonOK;

    @FindBy(id="confirmButton")
    private WebElement alertConfirmButton;

    @FindBy(id="promtButton")
    private WebElement alertPromtButton;

    @FindBy(id="timerAlertButton")
    private WebElement alertWait;

    public void interactAlertOK(){
        elementMethods.clickElement(alertButtonOK);
        alertMethods.acceptAlert();
    }
    public void interactWithConfirmationButton(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(alertConfirmButton);
        alertMethods.acceptAlert();
    }
    public void interactWithPromtButton(String text){
        elementMethods.clickElement(alertPromtButton);
        alertMethods.fillAlert(text);
    }
    public void interactWithTimerAlert(){
        elementMethods.clickElement(alertWait);
        alertMethods.acceptAlert();
    }
}

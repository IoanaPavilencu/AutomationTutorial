package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{
    public FramePage(WebDriver driver) {
        super(driver);
    }



    @FindBy(id = "sampleHeading")
    private WebElement iframeText;

    @FindBy(id = "sampleHeading")
    private WebElement iframeText2;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedButton;

    public void interectWithBigIFrame(){
        frameMethods.switchtoFrame("frame1");
        LoggerUtility.info("The user switches to a specific frame");
        System.out.println(iframeText.getText());
        LoggerUtility.info("The user interacts with an element inside the frame");
        frameMethods.defaultContentMethod();
        LoggerUtility.info("The user switches to primary frame");

    }

    public void interectWithSmallIFrame(){
        frameMethods.switchtoFrame("frame2");
        LoggerUtility.info("The user switches to a specific frame");
        System.out.println(iframeText2.getText());
        LoggerUtility.info("The user interacts with an element inside the frame");
        frameMethods.defaultContentMethod();
        LoggerUtility.info("The user switches to primary frame");
    }

    public void navigateToNestedFrame(){
        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(nestedButton);
        LoggerUtility.info("The user interacts with a nested frame");
    }

}

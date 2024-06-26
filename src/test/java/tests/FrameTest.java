package tests;

import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest {
    public WebDriver driver;

    @Test
    public void metodaTest(){
        //deschidem un browser

        driver = new ChromeDriver();

        //accesam un anumit URL

        driver.get("https://demoqa.com");

        PageMethods pageMethods=new PageMethods(driver);
        ElementMethods elementMethods=new ElementMethods(driver);
        FrameMethods frameMethods= new FrameMethods(driver);
        pageMethods.scrollPage(0,350);

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement formMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //formMenu.click();
        elementMethods.clickElement(formMenu);

        WebElement frameButton = driver.findElement(By.xpath("//span[text()='Frames']"));
        //frameButton.click();
        elementMethods.clickElement(frameButton);

        //ne mutam cu focusul pe un iFrame;
       // driver.switchTo().frame("frame1");
        frameMethods.switchtoFrame("frame1");

        WebElement iFrameText= driver.findElement(By.id("sampleHeading"));
        System.out.println(iFrameText.getText());

        //ne intoarcem cu focusul la frame-ul default
        //driver.switchTo().defaultContent();
        frameMethods.defaultContentMethod();

        //driver.switchTo().frame("frame2");
        frameMethods.switchtoFrame("frame2");

        WebElement iFrameText2= driver.findElement(By.id("sampleHeading"));
        System.out.println(iFrameText2.getText());

       // driver.switchTo().defaultContent();
        frameMethods.defaultContentMethod();


        WebElement nestedFrames = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        //frameButton.click();
        elementMethods.clickElement(nestedFrames);

        //interactionam cu iframe in iframe

        //driver.switchTo().frame("frame1");
        frameMethods.switchtoFrame("frame1");

        WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
       // driver.switchTo().frame(childFrame);
        frameMethods.switchtoFrame(childFrame);

        WebElement text = driver.findElement(By.xpath("//p"));
        System.out.println(text.getText());






    }
}

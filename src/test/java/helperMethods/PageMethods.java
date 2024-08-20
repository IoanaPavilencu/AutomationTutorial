package helperMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class PageMethods {
    public WebDriver driver;

    //Metode generale pentru interactiunea cu scroll
    public void scrollPage(Integer x, Integer y){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")", "");

    }

}

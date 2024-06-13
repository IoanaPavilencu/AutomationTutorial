package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest(){

         //deschidem un browser

        driver = new ChromeDriver();

        //accesam un anumit URL

        driver.get("https://demoqa.com");

        //facem browser-ul in mod maximize

        driver.manage().window().maximize();

        //definim un element dupa id
        //test1:adaug un rand nou

        //Obiecte
        PageMethods pageMethods = new PageMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);

        //facem un scroll la pagina pentru vizibilitate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //interactionam cu meniul/submeniul de pe site
        WebElement elementsMenu= driver.findElement(By.xpath("//h5[text()='Elements']"));
        //elementsMenu.click();
        elementMethods.clickElement(elementsMenu);

        WebElement webtablesubmenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        //webtablesubmenu.click();
        elementMethods.clickElement(webtablesubmenu);



        //Test1-Adaugam un nou entry(rand)
        //Definim un element dupa id,cream o variabila locala (addElement) pt path-ul elementului(dupa id)
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        //addElement.click();
        elementMethods.clickElement(addElement);


        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Ioana";
        firstNameElement.sendKeys(firstNameValue);
        elementMethods.fillElement(firstNameElement,firstNameValue);

        WebElement  lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Pavilencu";
        //lastNameElement.sendKeys(lastNameValue);
        elementMethods.fillElement(lastNameElement,lastNameValue);

        WebElement  emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "ioana.pavilencu@yahoo.com";
        //emailElement.sendKeys(emailValue);
        elementMethods.fillElement(emailElement,emailValue);


        WebElement  ageElement = driver.findElement(By.id("age"));
        String ageValue = "27";
        //ageElement.sendKeys(ageValue);
        elementMethods.fillElement(ageElement,ageValue);


        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "5000";
        //salaryElement.sendKeys(salaryValue);
        elementMethods.fillElement(salaryElement,salaryValue);


        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "Testing";
        //departmentElement.sendKeys(departmentValue);
        elementMethods.fillElement(departmentElement,departmentValue);


        WebElement submitElement = driver.findElement(By.id("submit"));
        //submitElement.click();
        elementMethods.clickElement(submitElement);



        //test 2:modific un rand(entry) existent

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        //editElement.click();
        elementMethods.clickElement(editElement);


        WebElement editsalaryElement = driver.findElement(By.id("salary"));
        String editsalaryValue = "25000";
        //editsalaryElement.clear();
        elementMethods.clearFillElement(editsalaryElement,editsalaryValue);
       // editsalaryElement.sendKeys(editsalaryValue);
       // elementMethods.fillElement(editsalaryElement,editsalaryValue);



        WebElement editdepartmentElement = driver.findElement(By.id("department"));
        String editdepartmentValue = "HR";
        editdepartmentElement.clear();
        //editdepartmentElement.sendKeys(editdepartmentValue);
        elementMethods.fillElement(editdepartmentElement,editdepartmentValue);


        WebElement editsubmitElement = driver.findElement(By.id("submit"));
        //editsubmitElement.click();
        elementMethods.clickElement(editsubmitElement);


        //test 3: sterg un rand existent (generat tot de mine)
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        //deleteElement.click();
        elementMethods.clickElement(deleteElement);

        driver.quit();

        
    }
}

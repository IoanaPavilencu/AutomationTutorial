package tests;


import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {

        //deschidem un browser

        driver = new ChromeDriver();

        //accesam un anumit URL

        driver.get("https://demoqa.com");

        //facem browser-ul in mod maximize

        driver.manage().window().maximize();

        //definim un element dupa id
        //test1:adaug un rand nou

        //Obiecte
        ElementMethods elementMethods =new ElementMethods(driver);
        PageMethods pageMethods =new PageMethods(driver);

        //facem un scroll la pagina pentru vizibilitate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //interactionam cu meniul/submeniul de pe site
        WebElement formMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        //formMenu.click();
        elementMethods.clickElement(formMenu);


        WebElement practiceformsubmenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
       // practiceformsubmenu.click();
        elementMethods.clickElement(practiceformsubmenu);


        //Maximizam browserul:
        driver.manage().window().maximize();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue ="Ioana";
        //firstName.sendKeys(firstNameValue);
        elementMethods.fillElement(firstNameElement, firstNameValue);

        //lastName
        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue="Pavilencu";
        //lastNameElement.sendKeys(lastNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);


        //userEmail
        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue="ioana@yahoo.com";
        //emailElement.sendKeys(emailValue);
        elementMethods.fillElement(emailElement, emailValue);


        //facem scroll
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);

        //definim o logica generala de a selecta un element dintr-o lista:
        List<WebElement> genderElements = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue="Female";
        switch (genderValue){
            case "Male":
                //genderElements.get(0).click();
                elementMethods.clickElement(genderElements.get(0));

                break;
            case "Female":
                //genderElements.get(1).click();
                elementMethods.clickElement(genderElements.get(1));

                break;
            case "Other":
                //genderElements.get(2).click();
                elementMethods.clickElement(genderElements.get(2));

                break;

        }

        //userNumberPhone
        WebElement mobilenumberElement = driver.findElement(By.id("userNumber"));
        String mobilenumberValue= "0724743866";
        //mobilenumberElement.sendKeys(mobilenumberValue);
        elementMethods.fillElement(mobilenumberElement, mobilenumberValue);


        //Date of birth

        WebElement dateOfBirthElement = driver.findElement(By.id("dateOfBirthInput"));
        //dateOfBirthElement.click();
        elementMethods.clickElement(dateOfBirthElement);

        WebElement dateOfBirthMonthElement = driver.findElement(By.className("react-datepicker__month-select"));
        //Select monthSelect = new Select(dateOfBirthMonthElement);
        //monthSelect.selectByVisibleText("September");
        elementMethods.selectByTextElement(dateOfBirthMonthElement, "September");

        WebElement dateOfBirthYearElement = driver.findElement(By.className("react-datepicker__year-select"));
        //Select yearSelect = new Select(dateOfBirthYearElement);
       // yearSelect.selectByValue("2099");
        elementMethods.selectByValue(dateOfBirthYearElement, "2099");


        List<WebElement> weekDaysElements = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']"));
        String weekDaysValue = "23";
        for (Integer index=0; index<weekDaysElements.size(); index++){
            if (weekDaysElements.get(index).getText().equals(weekDaysValue)){
                //weekDaysElements.get(index).click();
                elementMethods.clickElement(weekDaysElements.get(index));

                break;
            }

        }

        //subjectsInput
        WebElement subjectInputElement = driver.findElement(By.id("subjectsInput"));
        String subjectInputValue= "Accounting";
        //subjectInputElement.sendKeys(subjectInputValue);
        elementMethods.fillElement(subjectInputElement, subjectInputValue);
        //subjectInputElement.sendKeys(Keys.ENTER);\
        elementMethods.pressElement(subjectInputElement,Keys.ENTER);

        //Hobbies
        List<WebElement> hobbiesElements = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading", "Music");

        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);
        for (Integer index=0; index<hobbiesElements.size(); index++){
            String hobbieText = hobbiesElements.get(index).getText();
            if (hobbiesValues.contains(hobbieText)){
                //JavascriptExecutor jsclick = (JavascriptExecutor)driver;
                //jsclick.executeScript("arguments[0].click();",hobbiesElements.get(index));
                elementMethods.clickJSElement(hobbiesElements.get(index));
            }
        }

        //interactionam cu un fisier: uploadPicture
        WebElement uploadPictureElement = driver.findElement(By.id("uploadPicture"));
        String picturePathValue = "poza.jpg";
        File file = new File("src/test/resources/poza.jpg");
        uploadPictureElement.sendKeys(file.getAbsolutePath());

        //currentAddress
        WebElement addressElement = driver.findElement(By.id("currentAddress"));
        String addressValue = "adresa mea este: str.Principala, nr.77C";
        addressElement.sendKeys(addressValue);

        WebElement stateElement = driver.findElement(By.id("state"));
        //stateElement.click();
        elementMethods.clickElement(stateElement);


        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateInputValue = "Uttar Pradesh";
        stateInputElement.sendKeys(stateInputValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("city"));
        //cityElement.click();
        elementMethods.clickElement(cityElement);


        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityInputValue = "Agra";
        cityInputElement.sendKeys(cityInputValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitForm = driver.findElement(By.id("submit"));
        //submitForm.click();
        elementMethods.clickElement(submitForm);


        //validam tabelul cu valorile introduse
        WebElement thankYouMessageElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouMessageElement.getText(),"Thanks for submitting the form");

        List<WebElement> tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(),"Student Name " + firstNameValue + " " + lastNameValue);

        Assert.assertEquals(tableValues.get(1).getText(),"Student Email " + emailValue);

        Assert.assertEquals(tableValues.get(2).getText(),"Gender " + genderValue);

        Assert.assertEquals(tableValues.get(3).getText(),"Mobile " + mobilenumberValue);

        Assert.assertEquals(tableValues.get(5).getText(),"Subjects " + subjectInputValue);

        //Formatează lista de valori așteptate pentru hobby-uri
        String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesValues);

       //Compara valorile
        Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);

        Assert.assertEquals(tableValues.get(7).getText(),"Picture "+ picturePathValue);

        Assert.assertEquals(tableValues.get(8).getText(),"Address " + addressValue);

        Assert.assertEquals(tableValues.get(9).getText(),"State and City " + stateInputValue + " " + cityInputValue);

        WebElement closeElement = driver.findElement(By.id("closeLargeModal"));
        //js.executeScript("arguments[0].click();", closeElement);
        elementMethods.clickJSElement(closeElement);





    }
}
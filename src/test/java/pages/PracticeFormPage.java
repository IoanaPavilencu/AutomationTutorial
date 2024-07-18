package pages;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;
    public AlertMethods alertMethods;

    //Constructor
    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        elementMethods =new ElementMethods(driver);
        alertMethods =new AlertMethods(driver);
        pageMethods = new PageMethods(driver);

        PageFactory.initElements(driver,this);
    }

    @FindBy(id= "firstName")
    public WebElement firstName;

    @FindBy(id= "lastName")
    public WebElement lastName;

    @FindBy(id= "userEmail")
    public WebElement userEmail;

    @FindBy(xpath = "//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']")
    public List<WebElement> genderElements;

    @FindBy(id= "userNumber")
    public WebElement userNumber;

    @FindBy(id= "dateOfBirthInput")
    public WebElement dateOfBirth;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement dateOfBirthMonth;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement year;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']")
    public List<WebElement> dateOfBirthDays;

    @FindBy(id ="subjectsInput")
    public WebElement subjectsInput;

    @FindBy(xpath="//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']")
    public List<WebElement> hobbiesElements;

    @FindBy(id="uploadPicture")
    public WebElement uploadPictureElement;

    @FindBy(id="currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "react-select-3-input")
    public WebElement stateElement;

    @FindBy(id = "react-select-4-input")
    public WebElement city;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submit;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement thankYouMessage;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    public List<WebElement> tableValues;


    public void fillEntireForm(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String mobilenumberValue,
                               String dateOfBirthDaysValue, String subjectsInputValue, List<String> hobbiesValue, String picturePathValue, String addressValue, String stateInputValue,
                               String cityInputValue){
        pageMethods.scrollPage(0,350);

        elementMethods.fillElement(firstName, firstNameValue);
        elementMethods.fillElement(lastName, lastNameValue);
        elementMethods.fillElement(userEmail, emailValue);
        pageMethods.scrollPage(0,350);


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

        elementMethods.fillElement(userNumber, mobilenumberValue);
        elementMethods.clickElement(dateOfBirth);
        elementMethods.selectByTextElement(dateOfBirthMonth, "September");
        elementMethods.selectByValue(year, "2099");


        for (Integer index = 0; index < dateOfBirthDays.size(); index++) {
            if (dateOfBirthDays.get(index).getText().equals(dateOfBirthDaysValue)) {
                //dateOfBirthDays.get(index).click();
                elementMethods.clickElement(dateOfBirthDays.get(index));
                break;
            }
        }

        elementMethods.fillElement(subjectsInput, subjectsInputValue);
        elementMethods.pressElement(subjectsInput, Keys.ENTER);

        for (Integer index = 0; index < hobbiesElements.size(); index++){
            String hobbyText = hobbiesElements.get(index).getText();
            if (hobbiesValue.contains(hobbyText)) {
                elementMethods.clickJSElement(hobbiesElements.get(index));
            }
        }

        File file =new File("src/test/resources/" + picturePathValue);
        uploadPictureElement.sendKeys(file.getAbsolutePath());

        elementMethods.fillElement(currentAddress, addressValue);

        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(state);

        elementMethods.fillElement(stateElement,stateInputValue);
        elementMethods.pressElement(stateElement, Keys.ENTER);

        elementMethods.fillElement(city, cityInputValue);
        elementMethods.pressElement(city, Keys.ENTER);
        pageMethods.scrollPage(0,350);
        elementMethods.clickJSElement(submit);

        }

        public void validateEntireForm(String firstNameValue, String lastNameValue,
                                       String emailValue,String genderValue,String mobilenumberValue,
                                       String subjectsInputValue, List<String> hobbiesValues,
                                       String picturePathValue, String addressValue,
                                       String stateInputValue, String cityInputValue) {

            Assert.assertEquals(thankYouMessage.getText(),"Thanks for submitting the form");
            Assert.assertEquals(tableValues.get(0).getText(),"Student Name " + firstNameValue + " " + lastNameValue);
            Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + emailValue);
            Assert.assertEquals(tableValues.get(2).getText(),"Gender " + genderValue);
            Assert.assertEquals(tableValues.get(3).getText(),"Mobile " + mobilenumberValue);
            Assert.assertEquals(tableValues.get(5).getText(),"Subjects " + subjectsInputValue);
            String expectedHobbiesText = "Hobbies " + String.join(", ", hobbiesValues);
            Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
            Assert.assertEquals(tableValues.get(7).getText(), "Picture " + picturePathValue);
            Assert.assertEquals(tableValues.get(8).getText(),"Address " + addressValue);
            Assert.assertEquals(tableValues.get(9).getText(),"State and City " + stateInputValue + " " + cityInputValue);

        }
 }



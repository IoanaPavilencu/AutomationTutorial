package pages;

import loggerUtility.LoggerUtility;
import objectData.PracticeFormObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "firstName")
    private WebElement firstName;

    @FindBy(id= "lastName")
    private WebElement lastName;

    @FindBy(id= "userEmail")
    private WebElement userEmail;

    @FindBy(xpath = "//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> genderElements;

    @FindBy(id= "userNumber")
    private WebElement userNumber;

    @FindBy(id= "dateOfBirthInput")
    private WebElement dateOfBirth;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement dateOfBirthMonth;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement year;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']")
    private List<WebElement> dateOfBirthDays;

    @FindBy(id ="subjectsInput")
    private WebElement subjectsInput;

    @FindBy(xpath="//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> hobbiesElements;

    @FindBy(id="uploadPicture")
    private WebElement uploadPictureElement;

    @FindBy(id="currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "react-select-3-input")
    private WebElement stateElement;

    @FindBy(id = "react-select-4-input")
    private WebElement city;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submit;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement thankYouMessage;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    private List<WebElement> tableValues;

    public void fillEntireForm(PracticeFormObject testData){
        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.fillElement(firstName, testData.getFirstNameValue());
        LoggerUtility.info("The user filled in the firstnameelement with the value: " + testData.getFirstNameValue());
        elementMethods.fillElement(lastName, testData.getLastNameValue());
        LoggerUtility.info("The user filled in the lastnameelement with the value: " + testData.getLastNameValue());
        elementMethods.fillElement(userEmail, testData.getEmailValue());
        LoggerUtility.info("The user filled in the emailelement with the value: " + testData.getEmailValue());
        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page");


        switch (testData.getGenderValue()){
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
        LoggerUtility.info("The user selected the gender: " + testData.getGenderValue());

        elementMethods.fillElement(userNumber, testData.getMobilenumberValue());
        LoggerUtility.info("The user filled in the usernumberelement with the value: " + testData.getMobilenumberValue());
        elementMethods.clickElement(dateOfBirth);
        LoggerUtility.info("The user clicked to select the birthdate");
        elementMethods.selectByTextElement(dateOfBirthMonth, "September");
        LoggerUtility.info("The user selected the month September");
        elementMethods.selectByValue(year, "2099");
        LoggerUtility.info("The user selected the year 2099");


        for (Integer index = 0; index < dateOfBirthDays.size(); index++) {
            if (dateOfBirthDays.get(index).getText().equals(testData.getDateOfBirthDaysValue())) {
                //dateOfBirthDays.get(index).click();
                elementMethods.clickElement(dateOfBirthDays.get(index));
                break;
            }
        }
        LoggerUtility.info("The user submitted the birthdate of: " + testData.getDateOfBirthDaysValue());

        elementMethods.fillElement(subjectsInput, testData.getSubjectsInputValue());
        LoggerUtility.info("The user selected the subjects: " + testData.getSubjectsInputValue());
        elementMethods.pressElement(subjectsInput, Keys.ENTER);
        LoggerUtility.info("The user submitted their chosen subjects");

        for (Integer index = 0; index < hobbiesElements.size(); index++){
            String hobbyText = hobbiesElements.get(index).getText();
            if (testData.getHobbiesValue().contains(hobbyText)) {
                elementMethods.clickJSElement(hobbiesElements.get(index));
            }
        }
        LoggerUtility.info("The user selected the hobbies: " + testData.getHobbiesValue());

        File file =new File("src/test/resources/" + testData.getPicturePathValue());
        uploadPictureElement.sendKeys(file.getAbsolutePath());
        LoggerUtility.info("The user uploaded a file");

        elementMethods.fillElement(currentAddress, testData.getAddressValue());
        LoggerUtility.info("The user submitted for currentaddress element the value: " + testData.getAddressValue());

        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickElement(state);
        LoggerUtility.info("The user clicked to select the State");

        elementMethods.fillElement(stateElement,testData.getStateInputValue());
        LoggerUtility.info("The user chose the following state: " + testData.getStateInputValue());
        elementMethods.pressElement(stateElement, Keys.ENTER);
        LoggerUtility.info("The user submitted their chosen state");

        elementMethods.fillElement(city, testData.getCityInputValue());
        LoggerUtility.info("The user chose the following city: " + testData.getCityInputValue());
        elementMethods.pressElement(city, Keys.ENTER);
        LoggerUtility.info("The user submitted their chosen city");
        pageMethods.scrollPage(0,350);
        LoggerUtility.info("The user scrolled down the page");
        elementMethods.clickJSElement(submit);
        LoggerUtility.info("The user submitted the form");

        }

        public void validateEntireForm(PracticeFormObject testData) {

            Assert.assertEquals(thankYouMessage.getText(),"Thanks for submitting the form");
            LoggerUtility.info("The user validates the presence of " + thankYouMessage.getText());
            Assert.assertEquals(tableValues.get(0).getText(),"Student Name " + testData.getFirstNameValue() + " " + testData.getLastNameValue());
            LoggerUtility.info("The user validates the presence of " + testData.getFirstNameValue() + " " + testData.getLastNameValue());
            Assert.assertEquals(tableValues.get(1).getText(), "Student Email " + testData.getEmailValue());
            LoggerUtility.info("The user validates the presence of " + testData.getEmailValue());
            Assert.assertEquals(tableValues.get(2).getText(),"Gender " + testData.getGenderValue());
            LoggerUtility.info("The user validates the presence of " + testData.getGenderValue());
            Assert.assertEquals(tableValues.get(3).getText(),"Mobile " + testData.getMobilenumberValue());
            LoggerUtility.info("The user validates the presence of " + testData.getMobilenumberValue());
            Assert.assertEquals(tableValues.get(5).getText(),"Subjects " + testData.getSubjectsInputValue());
            LoggerUtility.info("The user validates the presence of " + testData.getSubjectsInputValue());
            String expectedHobbiesText = "Hobbies " + String.join(", ", testData.getHobbiesValue());
            Assert.assertEquals(tableValues.get(6).getText(), expectedHobbiesText);
            LoggerUtility.info("The user validates the presence of " + expectedHobbiesText);
            Assert.assertEquals(tableValues.get(7).getText(), "Picture " + testData.getPicturePathValue());
            LoggerUtility.info("The user validates the presence of " + testData.getPicturePathValue());
            Assert.assertEquals(tableValues.get(8).getText(),"Address " + testData.getAddressValue());
            LoggerUtility.info("The user validates the presence of " + testData.getAddressValue());
            Assert.assertEquals(tableValues.get(9).getText(),"State and City " + testData.getSubjectsInputValue() + " " + testData.getCityInputValue());
            LoggerUtility.info("The user validates the presence of " + testData.getSubjectsInputValue() + testData.getCityInputValue());

        }
 }



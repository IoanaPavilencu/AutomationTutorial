package pages;

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



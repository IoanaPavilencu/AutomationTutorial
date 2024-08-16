package pages;

import loggerUtility.LoggerUtility;
import objectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage {
    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id= "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id= "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id ="submit")
    private WebElement submitElement;
    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "salary")
    private WebElement editsalaryElement;
    @FindBy(id = "department")
    private WebElement editdepartmentElement;
    @FindBy(id = "submit")
    private WebElement editsubmitElement;
    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;

    public void addEntry(WebTableObject testData){
        elementMethods.clickElement(addElement);
        LoggerUtility.info("The user clicked to add a new entry");
        elementMethods.fillElement(firstNameElement,testData.getFirstNameValue());
        LoggerUtility.info("The user fills firstname element with the value: " +testData.getFirstNameValue());
        elementMethods.fillElement(lastNameElement,testData.getLastNameValue());
        LoggerUtility.info("The user fills lastname element with the value: " + testData.getLastNameValue());
        elementMethods.fillElement(emailElement,testData.getEmailValue());
        LoggerUtility.info("The user fills email element with the value: " + testData.getEmailValue());
        elementMethods.fillElement(ageElement,testData.getAgeValue());
        LoggerUtility.info("The user fills age element with the value: " + testData.getAgeValue());
        elementMethods.fillElement(salaryElement,testData.getSalaryValue());
        LoggerUtility.info("The user fills salary element with the value: " + testData.getSalaryValue());
        elementMethods.fillElement(departmentElement,testData.getDepartmentValue());
        LoggerUtility.info("The user fills department element with the value: " +testData.getDepartmentValue());
        elementMethods.clickElement(submitElement);
        LoggerUtility.info("The user clicke to submit the form. " + submitElement);


    }

    public void editEntry(WebTableObject testData){
        elementMethods.clickElement(editElement);
        LoggerUtility.info("The user clicke to edit an existing entry. " +editElement);
        elementMethods.clearFillElement(editsalaryElement,testData.getEditsalaryValue());
        LoggerUtility.info("The user edit salary element with the value: " + testData.getEditsalaryValue());
        editdepartmentElement.clear();
        elementMethods.fillElement(editdepartmentElement,testData.getEditdepartmentValue());
        LoggerUtility.info("The user edit department element with the value: " + testData.getEditdepartmentValue());
                elementMethods.clickElement(editsubmitElement);
        LoggerUtility.info("The user edit submit element " +editsubmitElement);

    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
        LoggerUtility.info("The user clicked to delete the entry");
    }

}

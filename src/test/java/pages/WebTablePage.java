package pages;

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
        elementMethods.fillElement(firstNameElement, testData.getFirstNameValue());
        elementMethods.fillElement(lastNameElement, testData.getLastNameValue());
        elementMethods.fillElement(emailElement, testData.getEmailValue());
        elementMethods.fillElement(ageElement, testData.getAgeValue());
        elementMethods.fillElement(salaryElement, testData.getSalaryValue());
        elementMethods.fillElement(departmentElement, testData.getDepartmentValue());
        elementMethods.clickElement(submitElement);

    }

    public void editEntry(WebTableObject testData){
        elementMethods.clickElement(editElement);
        elementMethods.clearFillElement(editsalaryElement, testData.getEditsalaryValue());
        editdepartmentElement.clear();
        elementMethods.fillElement(editdepartmentElement, testData.getEditdepartmentValue());
        elementMethods.clickElement(editsubmitElement);

    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
    }

}

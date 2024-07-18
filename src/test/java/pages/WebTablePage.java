package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {
    public WebDriver driver;
    public ElementMethods elementMethods;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;
    @FindBy(id= "firstName")
    public WebElement firstNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(id= "userEmail")
    public WebElement emailElement;
    @FindBy(id = "age")
    public WebElement ageElement;
    @FindBy(id = "salary")
    public WebElement salaryElement;
    @FindBy(id = "department")
    public WebElement departmentElement;
    @FindBy(id ="submit")
    public WebElement submitElement;
    @FindBy(id = "edit-record-4")
    public WebElement editElement;
    @FindBy(id = "salary")
    public WebElement editsalaryElement;
    @FindBy(id = "department")
    public WebElement editdepartmentElement;
    @FindBy(id = "submit")
    public WebElement editsubmitElement;
    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;



    public void addEntry(String firstNameValue, String lastNameValue, String emailValue,
                         String ageValue, String salaryValue, String departmentValue){
        elementMethods.clickElement(addElement);
        elementMethods.fillElement(firstNameElement,firstNameValue);
        elementMethods.fillElement(lastNameElement,lastNameValue);
        elementMethods.fillElement(emailElement,emailValue);
        elementMethods.fillElement(ageElement,ageValue);
        elementMethods.fillElement(salaryElement,salaryValue);
        elementMethods.fillElement(departmentElement,departmentValue);
        elementMethods.clickElement(submitElement);

    }

    public void editEntry(String editsalaryValue,String editdepartmentValue){
        elementMethods.clickElement(editElement);
        elementMethods.clearFillElement(editsalaryElement,editsalaryValue);
        editdepartmentElement.clear();
        elementMethods.fillElement(editdepartmentElement,editdepartmentValue);
        elementMethods.clickElement(editsubmitElement);

    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
    }

}

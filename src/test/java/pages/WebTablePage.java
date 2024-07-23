package pages;

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

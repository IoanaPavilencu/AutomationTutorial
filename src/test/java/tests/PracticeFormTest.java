package tests;


import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {



    @Test
    public void metodaTest() {
        prepareEnvironment();

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormsMenu();

        FormsPage formsPage =new FormsPage(getDriver());
        formsPage.navigateToPracticeForm();

        PracticeFormPage practiceFormPage= new PracticeFormPage(getDriver());

        String firstNameValue ="Ioana";
        String lastNameValue="Pavilencu";
        String emailValue="ioana@yahoo.com";
        String genderValue="Female";
        String mobilenumberValue= "0724743866";
        String dateOfBirthDaysValue="23";
        String subjectsInputValue="Arts";
        List<String> hobbiesValue= Arrays.asList("Sports", "Music");
        String picturePathValue = "poza.jpg";
        String addressValue = "adresa mea este: str.Principala, nr.77C";
        String stateInputValue = "Uttar Pradesh";
        String cityInputValue = "Agra";

        practiceFormPage.fillEntireForm(firstNameValue,lastNameValue,emailValue,
                genderValue,mobilenumberValue,dateOfBirthDaysValue,subjectsInputValue,
                hobbiesValue, picturePathValue,addressValue,stateInputValue,
                cityInputValue);

        practiceFormPage.validateEntireForm(firstNameValue,lastNameValue,
                emailValue,genderValue,mobilenumberValue,
                subjectsInputValue,hobbiesValue,picturePathValue,addressValue,stateInputValue,
                cityInputValue);
     }
}

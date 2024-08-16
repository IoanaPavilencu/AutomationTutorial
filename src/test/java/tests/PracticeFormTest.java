package tests;


import objectData.PracticeFormObject;
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

        //Pregatim datele de test specifice

        PracticeFormObject testData=new PracticeFormObject("src/test/resources/testData/PracticeFormData.json");

        //Obiecte (Refactorizam codul)
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormsMenu();

        FormsPage formsPage =new FormsPage(getDriver());
        formsPage.navigateToPracticeForm();

        PracticeFormPage practiceFormPage= new PracticeFormPage(getDriver());

        practiceFormPage.fillEntireForm(testData);

        practiceFormPage.validateEntireForm(testData);
     }
}

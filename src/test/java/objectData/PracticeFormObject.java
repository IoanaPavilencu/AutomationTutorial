package objectData;

import java.util.List;

public class PracticeFormObject extends GeneralObject{

    private String firstNameValue ;
    private String lastNameValue;
    private String emailValue;
    private String genderValue;
    private String mobilenumberValue;
    private String dateOfBirthDaysValue;
    private String subjectsInputValue;
    private List<String> hobbiesValue;
    private String picturePathValue;
    private String addressValue;
    private String stateInputValue;
    private String cityInputValue;

    public PracticeFormObject(String filePath) {

        fromJsonToObject(filePath);
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getMobilenumberValue() {
        return mobilenumberValue;
    }

    public void setMobilenumberValue(String mobilenumberValue) {
        this.mobilenumberValue = mobilenumberValue;
    }

    public String getDateOfBirthDaysValue() {
        return dateOfBirthDaysValue;
    }

    public void setDateOfBirthDaysValue(String dateOfBirthDaysValue) {
        this.dateOfBirthDaysValue = dateOfBirthDaysValue;
    }

    public String getSubjectsInputValue() {
        return subjectsInputValue;
    }

    public void setSubjectsInputValue(String subjectsInputValue) {
        this.subjectsInputValue = subjectsInputValue;
    }

    public List<String> getHobbiesValue() {
        return hobbiesValue;
    }

    public void setHobbiesValue(List<String> hobbiesValue) {
        this.hobbiesValue = hobbiesValue;
    }

    public String getPicturePathValue() {
        return picturePathValue;
    }

    public void setPicturePathValue(String picturePathValue) {
        this.picturePathValue = picturePathValue;
    }

    public String getAddressValue() {
        return addressValue;
    }

    public void setAddressValue(String addressValue) {
        this.addressValue = addressValue;
    }

    public String getStateInputValue() {
        return stateInputValue;
    }

    public void setStateInputValue(String stateInputValue) {
        this.stateInputValue = stateInputValue;
    }

    public String getCityInputValue() {
        return cityInputValue;
    }

    public void setCityInputValue(String cityInputValue) {
        this.cityInputValue = cityInputValue;
    }
}

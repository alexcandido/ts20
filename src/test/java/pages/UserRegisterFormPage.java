package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegisterFormPage {

    private WebDriver driver;

    private By emailField = By.cssSelector(".cadastroForm [name=email]");
    private By passwordField = By.cssSelector(".cadastroForm [name=password]");
    private By cpfField = By.cssSelector(".cadastroForm [name=cpf]");
    private By nameField = By.cssSelector(".cadastroForm [name=name]");
    private By birthdayField = By.cssSelector(".cadastroForm [name=birthday]");
    private By maleRadioFlag = By.cssSelector(".cadastroForm .inputGroup-radio [for=gender_M]");
    private By femaleRadioFlag = By.cssSelector(".cadastroForm .inputGroup-radio [for=gender_F]");
    private By phoneField = By.cssSelector(".cadastroForm [name=phone]");
    private By offerEmailRadioFlag = By.cssSelector(".cadastroForm [for=offersEmail]");
    private By submitButton = By.cssSelector(".cadastroForm button[type=submit]");
    private By errorMsg = By.cssSelector(".inputGroup#email .inputGroup-error"); //Xpath //div[@id='email']/div[contains(@class, 'inputGroup-error')]

    public void setElement(By elementId, String text) {
        WebElement element = driver.findElement(elementId);
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(By elementId) {
        WebElement element = driver.findElement(elementId);
        element.click();
    }

    public void setEmailField(String email) {
        setElement(emailField, email);
    }

    public void setPasswordField(String password) {
        setElement(passwordField, password);
    }

    public void setCpfField(String cpf) {
        setElement(cpfField, cpf);
    }

    public void setNameField(String name) {
        setElement(nameField, name);
    }

    public void setBirthdayField(String birthday) {
        setElement(birthdayField, birthday);
    }

    public void setPhoneField(String phone) {
        setElement(phoneField, phone);
    }

    public void setMaleRadioFlag() {
        clickElement(maleRadioFlag);
    }

    public void setFemaleRadioFlag() {
        clickElement(femaleRadioFlag);
    }

    //public void setOfferEmailRadioFlag() {
    //    clickElement(offerEmailRadioFlag);
    //}

    public void clickSubmitButton() {
        clickElement(submitButton);
    }

    public void selectGender(String gender) {
        if (gender.equals("M")) {
            setMaleRadioFlag();
        } else {
            setFemaleRadioFlag();
        }
    }

    public String getMessage() {
        WebElement element = driver.findElement(errorMsg);
        return element.getText().trim();
    }

    public void submitUserForm(String email, String password, String cpf, String name, String birthday, String gender, String phone) {
        setEmailField(email);
        setPasswordField(password);
        setCpfField(cpf);
        setNameField(name);
        setBirthdayField(birthday);
        selectGender(gender);
        setPhoneField(phone);
        clickSubmitButton();
    }


}

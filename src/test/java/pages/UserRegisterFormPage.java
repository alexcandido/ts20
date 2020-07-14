package pages;

import manager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CommonActions;

public class UserRegisterFormPage {

    private WebDriver driver;
    private CommonActions commonActions;
    private WebDriverWait wait;

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
    private By pageTitle = By.cssSelector(".cadastroForm-title span");

    public UserRegisterFormPage(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        commonActions = new CommonActions(driver);
    }

    public void setEmailField(String email) {
        commonActions.setElementValue(emailField, email);
    }

    public void setPasswordField(String password) {
        commonActions.setElementValue(passwordField, password);
    }

    public void setCpfField(String cpf) {
        commonActions.setElementValue(cpfField, cpf);
    }

    public void setNameField(String name) {
        commonActions.setElementValue(nameField, name);
    }

    public void setBirthdayField(String birthday) {
        commonActions.setElementValue(birthdayField, birthday);
    }

    public void setPhoneField(String phone) {
        commonActions.setElementValue(phoneField, phone);
    }

    public void setMaleRadioFlag() {
        commonActions.click(maleRadioFlag);
    }

    public void setFemaleRadioFlag() {
        commonActions.click(femaleRadioFlag);
    }

    public void clickSubmitButton() {
        commonActions.click(submitButton);
    }

    public void selectGender(String gender) {
        if (gender.equals("M")) {
            setMaleRadioFlag();
        } else {
            setFemaleRadioFlag();
        }
    }

    public String getPageTitle() {
        commonActions.waitForAnElementBeVisible(pageTitle);
        return commonActions.findElement(pageTitle).getText();
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

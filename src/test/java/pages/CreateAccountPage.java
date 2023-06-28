package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testdata.User;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountPage {

    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //----------LOCATORS----------//
    private By firstNameInput = By.id("firstname");
    private By middleNameInput = By.id("middlename");
    private By lastNameInput = By.id("lastname");
    private By emailInput = By.id("email_address");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("confirmation");
    private By rememberMeCheckbox = By.xpath("//input[@title=\"Remember Me\"]");
    private By registerButton = By.xpath("//button[@title=\"Register\"]");
    private By inputErrors = By.xpath("//div[@class=\"validation-advice\"]");
    private By firstNameInputError = By.id("advice-required-entry-firstname");
    private By lastNameInputError = By.id("advice-required-entry-lastname");
    private By emailInputError = By.id("advice-required-entry-email_address");
    private By passwordInputError = By.id("advice-required-entry-password");
    private By confirmPasswordInputError = By.id("advice-required-entry-confirmation");


    //----------PRIVATE METHODS----------//
    private void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    private void enterMiddleName(String middleName) {
        driver.findElement(middleNameInput).sendKeys(middleName);
    }
    private void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    private void enterConfirmPassword(String password) {
        driver.findElement(confirmPasswordInput).sendKeys(password);
    }
    private void clear(By locator) {
        driver.findElement(locator).clear();
    }
    private void clickRememberMeCheckbox() {
        driver.findElement(rememberMeCheckbox).click();
    }


    //----------PUBLIC METHODS----------//
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void fillMandatoryFields(User user) {
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        enterConfirmPassword(user.getPassword());
    }
    public void fillForm(User user) {
        enterFirstName(user.getFirstName());
        enterMiddleName(user.getMiddleName());
        enterLastName(user.getLastName());
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        enterConfirmPassword(user.getPassword());
    }
    public void clearForm() {
        clear(firstNameInput);
        clear(middleNameInput);
        clear(lastNameInput);
        clear(emailInput);
        clear(passwordInput);
        clear(confirmPasswordInput);
    }
    public boolean isRememberMeCheckboxSelected() {
        return driver.findElement(rememberMeCheckbox).isSelected();
    }
    public void unselectRememberMeCheckbox() {
        WebElement rememberMe = driver.findElement(rememberMeCheckbox);
        if(rememberMe.isSelected()) {
            clickRememberMeCheckbox();
        }
    }
    public void selectRememberMeCheckbox() {
        WebElement rememberMe = driver.findElement(rememberMeCheckbox);
        if(!rememberMe.isSelected()) {
            clickRegisterButton();
        }
    }
    public void clickRegisterButton() {
        WebElement regButton = driver.findElement(registerButton);
        SeleniumUtils.scrollToElement(driver, regButton);
        regButton.click();
    }
    public List<String> getFieldInputErrors() {
        List<WebElement> inputErrorsElements = driver.findElements(inputErrors);
        List<String> inputErrors = new ArrayList<>();

        for (WebElement inputErrorElement : inputErrorsElements) {
            inputErrors.add(inputErrorElement.getText());
        }
        return inputErrors;
    }
    public boolean areFieldInputErrorsDisplayed() {
        List<WebElement> inputErrorsElements = driver.findElements(inputErrors);

        for (WebElement inputErrorElement : inputErrorsElements) {
            if (inputErrorElement.isDisplayed()) {
                return true;
            }
        } return false;
    }
}

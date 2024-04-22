package tests;

import constants.AccountDashboardConst;
import constants.LoginConst;
import dataprovider.usersDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.LOGIN_PAGE);
    }

    @Test(description = "User entering valid Email and valid Password CAN login.",
            dataProvider = "validLoginCredentials", dataProviderClass = usersDataProvider.class)
    public void loginWithValidCredentials(String email, String password) {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertEquals(accountDashboardPage.getUserGreetingPlaceholder(), AccountDashboardConst.HELLO_USERNAME_MESSAGE);
        assertTrue(accountDashboardPage.isPageTitleDisplayed());

        header.logoutUser();
    }

    @Test(description = "User entering invalid credentials CANNOT login.",
            dataProvider = "invalidLoginCredentials", dataProviderClass = usersDataProvider.class)
    public void loginWithInvalidCredentials(String email, String password) {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertTrue(loginPage.isEmailFieldDisplayed(), "Email field is not displayed.");
        assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field is not displayed.");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
    }

    @Test(description = "User entering invalid Email and valid Password CANNOT login.")
    public void loginWithInvalidEmailAndValidPassword() {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(invalidUser.getEmail());
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials message is not displayed.");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
    }

    @Test(description = "User entering valid Email and invalid Password CANNOT login.")
    public void loginWithValidEmailAndInvalidPassword() {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.enterPassword(invalidUser.getPassword());
        loginPage.clickLoginButton();


    }

    @Test(description = "User leaving the Email and Password fields empty CANNOT login.")
    public void loginWithEmptyCredentials() {
        loginPage.clearCredentialsInputs();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
    }

    @Test(description = "User leaving the Email field empty and entering valid Password CANNOT login.")
    public void loginWithEmptyEmailAndValidPassword() {
        loginPage.clearCredentialsInputs();
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();

        assertEquals(loginPage.getEmailEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR, "Email required error message is not displayed.");
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE, "User was not redirected to the Login page.");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
    }

    @Test(description = "User entering valid Email and leaving the Password field empty CANNOT login.")
    public void loginWithValidEmailAndEmptyPassword() {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(validUser.getEmail());
        loginPage.clearPasswordInput();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isPasswordEmptyErrorDisplayed(), "Password input error message is not displayed.");
        assertEquals(loginPage.getPasswordEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR, "Password required error message is not displayed.");
    }

    @Test(description = "Validation error message is displayed for invalid Email syntax.",
            dataProvider = "invalidEmailSyntax", dataProviderClass = usersDataProvider.class)
    public void loginWithInvalidEmailSyntaxAndValidPassword(String invalidEmailSyntax) {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(invalidEmailSyntax);
        loginPage.enterPassword(validUser.getPassword());
        loginPage.clickLoginButton();
    }

    @Test(description = "Empty Email field validation message is displayed.")
    public void verifyEmptyEmailErrorMessageIsDisplayed() {


        assertTrue(loginPage.isEmailEmptyErrorMessageDisplayed(), "Email required error message is not displayed.");
    }

    @Test(description = "Empty Password field validation message is displayed")
    public void verifyEmptyPasswordErrorMessageIsDisplayed() {

        assertTrue(loginPage.isPasswordEmptyErrorDisplayed(), "Password required error message is not displayed.");
    }

    @Test(description = "Invalid Email validation error message is displayed as expected.")
    public void verifyInvalidEmailErrorMessageIsDisplayed() {

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials error message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
    }

    @Test(description = "Invalid Password validation error message is displayed as expected.")
    public void verifyInvalidPasswordErrorMessageIsDisplayed() {

        assertTrue(loginPage.isCredentialsInvalidErrorMessageDisplayed(), "Invalid credentials error message is not displayed");
        assertEquals(loginPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR, "Invalid credentials error message is wrong.");
    }
}

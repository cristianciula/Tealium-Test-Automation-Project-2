package tests;

import constants.LoginConst;
import constants.SignUpConst;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;

import static constants.MenConst.MEN_PAGE_TITLE;
import static org.testng.Assert.*;

public class NavigationTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.HOME_PAGE);
    }

    @Test (description = "Tests that a user can navigate from the Home page to the Registration page")
    public void navigateFromHomePageToRegistrationPage() {
        header.clickAccountDropdownButton();
        header.clickRegisterDropdownOption();

        assertEquals(signUpPage.getPageTitle(), SignUpConst.CREATE_ACCOUNT_PAGE_TITLE);
        assertTrue(signUpPage.isRegisterButtonDisplayed());
    }

    @Test (description = "Tests that a user can navigate from the Home page to the Login page")
    public void navigateFromHomePageToLoginPage() {
        header.clickAccountDropdownButton();
        header.clickLoginDropdownOption();

        assertEquals(LoginConst.LOGIN_PAGE_TITLE, loginPage.getPageTitle());
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
    }

    @Test (description = "Tests that a user can navigate from the Home page to the Women page")
    public void navigateFromHomePageToWomenPage() {
        homePage.clickWomenTab();

        assertTrue(womenPage.isBreadcrumbsDisplayed(), "Women page breadcrumbs is not displayed.");
    }
    //TODO
    @Test (description = "Tests that a user can navigate from the Home page to the Men page")
    public void navigateFromHomePageToMenPage() {
        homePage.clickMenTab();

        assertEquals(menPage.getPageTitle(), MEN_PAGE_TITLE);
    }
    //TODO
    @Test (description = "Tests that a user can navigate from the Home page to the Accessories page")
    public void navigateFromHomePageToAccessoriesPage() {

    }
    //TODO
    @Test (description = "Tests that a user can navigate from the Home page to the Home & Decor page")
    public void navigateFromHomePageToHomeAndDecorPage() {

    }
    //TODO
    @Test (description = "Tests that a user can navigate from the Home page to the Sale page")
    public void navigateFromHomePageToSalePage() {

    }
    //TODO
    @Test (description = "Tests that a user can navigate from the Home page to the VIP page")
    public void navigateFromHomePageToVipPage() {

    }

}

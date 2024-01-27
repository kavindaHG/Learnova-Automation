package testCases;

import base.BaseClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegistrationPage;

public class LoginPageTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;

    @Test(priority = 1)
    public void verifyLoginURL() {

        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.clickLoginButton();

        String actualRegistrationPageURL = loginPage.validateNewURL();
        String expectedLoginPageURL = "https://learnova-dev.skillsurf.lk/login";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualRegistrationPageURL, expectedLoginPageURL);
        softAssert.assertAll("Page URL Verification Failed");
    }

    @Test(priority = 2)
    public void verifyPageTitle() {

        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.clickLoginButton();

        String actualPageTitle = loginPage.validatePageTitle();
        String expectedPageTitle = "Sign In";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualPageTitle, expectedPageTitle);
        softAssert.assertAll("Page Title Verification Failed");
    }

    @Test(priority = 3)
    public void loginTest() throws InterruptedException {
        homePage = new HomePage();
        homePage.clickLoginButton();
        loginPage = new LoginPage();
        loginPage.login(properties.getProperty("LOGIN_EMAIL"), properties.getProperty("LOGIN_PASSWORD"));
    }
}

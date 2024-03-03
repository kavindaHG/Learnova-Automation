package testCases;

import base.BaseClass;
import factoryData.UserFactoryData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.EmailVerificationPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegistrationPage;

public class RegistrationPageTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    EmailVerificationPage emailVerificationPage;
    String userFirstName = UserFactoryData.createNewUserData().getFirstName();
    String userLastName = UserFactoryData.createNewUserData().getLastName();
    String password = UserFactoryData.createNewUserData().getPassword();
    String confirmPassword = UserFactoryData.createNewUserData().getConfirmPassword();
    String expectedEmailAddress = UserFactoryData.createNewUserData().getEmail();

    @Test(priority = 1)
    public void verifyRegistrationURL() throws InterruptedException {

        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();

        homePage.clickLoginButton();
        loginPage.clickSignUpLink();

        String actualRegistrationPageURL = registrationPage.validateNewURL();
        String expectedRegistrationPageURL = "https://learnova-dev.skillsurf.lk/register";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualRegistrationPageURL, expectedRegistrationPageURL);
        softAssert.assertAll("Page URL Verification Failed");
    }

    @Test(priority = 2)
    public void verifyPageTitle() throws InterruptedException {

        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();

        homePage.clickLoginButton();
        loginPage.clickSignUpLink();

        String actualPageTitle = registrationPage.validatePageTitle();
        String expectedPageTitle = "Sign Up";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualPageTitle, expectedPageTitle);
        softAssert.assertAll("Page Title Verification Failed");
    }

    @Test(priority = 3)
    public void newUserRegistrationAndEmailVerificationTest() throws InterruptedException {

        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        emailVerificationPage = new EmailVerificationPage();

        homePage.clickLoginButton();
        loginPage.clickSignUpLink();
        registrationPage.registrationFormFillAndEmailVerification(
                userFirstName, userLastName, expectedEmailAddress, password, confirmPassword);
        Thread.sleep(2000);
        System.out.println(userFirstName);

        String actualEmailVerificationURL = emailVerificationPage.validateNewURL();
        String expectedEmailVerificationURL = "https://learnova-dev.skillsurf.lk/verify-email";
        String actualEmailAddress = emailVerificationPage.validateEmailAddress();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualEmailVerificationURL, expectedEmailVerificationURL);
        softAssert.assertEquals(actualEmailAddress,expectedEmailAddress);
        softAssert.assertAll("Assert Failed");
    }
}


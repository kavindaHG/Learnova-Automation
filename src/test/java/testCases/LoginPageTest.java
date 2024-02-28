package testCases;

import base.BaseClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyCoursesPage;
import pageObject.MyProfilePage;

public class LoginPageTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;
    MyCoursesPage myCoursesPage;
    MyProfilePage myProfilePage;
    SoftAssert softAssert;
    String expectedEmptyUsernameErrorText = "Email is required";
    String expectedEmptyPasswordErrorText = "Password is required";
    String expectedInvalidEmailPatternErrorText = "Please enter a valid email";
    String expectedInvalidCredToast = "Email or the password is invalid. Please try again with valid information.";
    String expectedStudentMyCoursesURL = "https://learnova-dev.skillsurf.lk/student/courses";
    String expectedAdminMyCoursesURL = "https://learnova-dev.skillsurf.lk/admin/courses";
    String expectedStudentMyCoursesTitle = "My Courses";
    String expectedStudentUserType = "Student";
    String expectedAdminUserType = "Admin";

//    @Test(priority = 1)
//    public void verifyLoginURL() {
//
//        homePage = new HomePage();
//        loginPage = new LoginPage();
//        homePage.clickLoginButton();
//
//        String actualRegistrationPageURL = loginPage.validateNewURL();
//        String expectedLoginPageURL = "https://learnova-dev.skillsurf.lk/login";
//
//        softAssert = new SoftAssert();
//        softAssert.assertEquals(actualRegistrationPageURL, expectedLoginPageURL);
//        softAssert.assertAll("Page URL Verification Failed");
//    }

//    @Test(priority = 2)
//    public void verifyPageTitle() {
//
//        homePage = new HomePage();
//        loginPage = new LoginPage();
//        homePage.clickLoginButton();
//
//        String actualPageTitle = loginPage.validatePageTitle();
//        String expectedPageTitle = "Sign In";
//
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(actualPageTitle, expectedPageTitle);
//        softAssert.assertAll("Page Title Verification Failed");
//    }

//    user login with empty username and password
//    @Test(priority = 3)
//    public void negativeLoginTest1() throws InterruptedException {
//        homePage = new HomePage();
//        homePage.clickLoginButton();
//        loginPage = new LoginPage();
//        loginPage.login("", "");
//
//        String emptyUserNameErrorText = loginPage.emptyUsernameText();
//        String emptyPasswordErrorText = loginPage.emptyPasswordText();
//
//        softAssert = new SoftAssert();
//        softAssert.assertEquals(emptyUserNameErrorText, expectedEmptyUsernameErrorText);
//        softAssert.assertEquals(emptyPasswordErrorText,expectedEmptyPasswordErrorText);
//        softAssert.assertAll("Empty email and password input assertion failed");
//    }

    //user login with empty username and correct password
//    @Test(priority = 4)
//    public void negativeLoginTest2() throws InterruptedException {
//        homePage = new HomePage();
//        homePage.clickLoginButton();
//        loginPage = new LoginPage();
//        loginPage.login("", "SKF@User_2023");
//
//        String emptyUserNameErrorText = loginPage.emptyUsernameText();
//
//        softAssert = new SoftAssert();
//        softAssert.assertEquals(emptyUserNameErrorText, expectedEmptyUsernameErrorText);
//        softAssert.assertAll("Empty email input assertion failed");
//    }
//
//    //user login with correct username and empty password
//    @Test(priority = 5)
//    public void negativeLoginTest3() throws InterruptedException {
//        homePage = new HomePage();
//        homePage.clickLoginButton();
//        loginPage = new LoginPage();
//        loginPage.login("skfuser@gmail.com", "");
//
//        String emptyPasswordErrorText = loginPage.emptyPasswordText();
//
//        softAssert = new SoftAssert();
//        softAssert.assertEquals(emptyPasswordErrorText, expectedEmptyPasswordErrorText);
//        softAssert.assertAll("Empty password input assertion failed");
//    }
//
//    //user login with invalid email input
//    @Test(priority = 6)
//    public void negativeLoginTest4() throws InterruptedException {
//        homePage = new HomePage();
//        homePage.clickLoginButton();
//        loginPage = new LoginPage();
//        loginPage.login("Kavinda", "Heshan");
//
//        String actualInvalidEmailPatternErrorText = loginPage.invalidEmailPatternText();
//
//        softAssert = new SoftAssert();
//        softAssert.assertEquals(actualInvalidEmailPatternErrorText, expectedInvalidEmailPatternErrorText);
//        softAssert.assertAll("Invalid email pattern assertion failed");
//    }
//
//    //user login with invalid email input
//    @Test(priority = 7)
//    public void negativeLoginTest5() throws InterruptedException {
//        homePage = new HomePage();
//        homePage.clickLoginButton();
//        loginPage = new LoginPage();
//        loginPage.login("123445", "12345");
//
//        String actualInvalidEmailPatternErrorText = loginPage.invalidEmailPatternText();
//
//        softAssert = new SoftAssert();
//        softAssert.assertEquals(actualInvalidEmailPatternErrorText, expectedInvalidEmailPatternErrorText);
//        softAssert.assertAll("Invalid email pattern assertion failed");
//    }
//
//    //user login with incorrect username and password
//    @Test(priority = 9)
//    public void negativeLoginTest6() throws InterruptedException {
//        homePage = new HomePage();
//        homePage.clickLoginButton();
//        loginPage = new LoginPage();
//        loginPage.login("abc@gmail.com", "abc@Gmail.com1");
//        Thread.sleep(2000);
//
//        String actualInvalidCredentialsToastMessage = loginPage.invalidCredentialsToastMessageText();
//
//        softAssert = new SoftAssert();
//        softAssert.assertEquals(actualInvalidCredentialsToastMessage, expectedInvalidCredToast);
//        softAssert.assertAll("Invalid credentials input assertion failed");
//    }
//
    //user login with correct username and incorrect password
//    @Test(priority = 9)
//    public void negativeLoginTest7() throws InterruptedException {
//        homePage = new HomePage();
//        homePage.clickLoginButton();
//        loginPage = new LoginPage();
//        loginPage.login("skfuser@gmail.com", "SKf12345");
//        Thread.sleep(2000);
//
//        String actualInvalidCredentialsToastMessage = loginPage.invalidCredentialsToastMessageText();
//
//        softAssert = new SoftAssert();
//        softAssert.assertEquals(actualInvalidCredentialsToastMessage, expectedInvalidCredToast);
//        softAssert.assertAll("Valid email and invalid password input assertion failed");
//    }

    //user login with incorrect username and correct password
//    @Test(priority = 10)
//    public void negativeLoginTest8() throws InterruptedException {
//        homePage = new HomePage();
//        homePage.clickLoginButton();
//        loginPage = new LoginPage();
//        loginPage.login("abc@gmail.com", "SKF@User_2023");
//        Thread.sleep(2000);
//
//        String actualInvalidCredentialsToastMessage = loginPage.invalidCredentialsToastMessageText();
//
//        softAssert = new SoftAssert();
//        softAssert.assertEquals(actualInvalidCredentialsToastMessage, expectedInvalidCredToast);
//        softAssert.assertAll("Invalid email and valid password input assertion failed");
//    }

    //user login with correct username and password
    @Test(priority = 11)
    public void positiveLoginTestStudent() throws InterruptedException {
        homePage = new HomePage();
        homePage.clickLoginButton();
        loginPage = new LoginPage();
        myCoursesPage = new MyCoursesPage();
        myProfilePage = new MyProfilePage();

        loginPage.login(properties.getProperty("STUDENT_LOGIN_EMAIL"), properties.getProperty("STUDENT_LOGIN_PASSWORD"));
        Thread.sleep(2000);

        String actualStudentMyCoursesURL = myCoursesPage.validateNewURL();

        //validate redirection to student/myCourses after logging is correct
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStudentMyCoursesURL, expectedStudentMyCoursesURL);

        //move to my profile
        myCoursesPage.goToMyProfile();
        String actualUserType = myProfilePage.userType();
        String actualUserEmail = myProfilePage.userEmail();
        String expectedStudentUserEmail = properties.getProperty("STUDENT_LOGIN_EMAIL");

        softAssert.assertEquals(actualUserType, expectedStudentUserType);
        softAssert.assertEquals(actualUserEmail, expectedStudentUserEmail);

        softAssert.assertAll("Student Login Validation Failed");
    }

    @Test(priority = 12)
    public void positiveLoginTestAdmin() throws InterruptedException {
        homePage = new HomePage();
        homePage.clickLoginButton();
        loginPage = new LoginPage();
        myCoursesPage = new MyCoursesPage();
        myProfilePage = new MyProfilePage();

        loginPage.login(properties.getProperty("ADMIN_LOGIN_EMAIL"), properties.getProperty("ADMIN_LOGIN_PASSWORD"));
        Thread.sleep(2000);

        String actualAdminMyCoursesURL = myCoursesPage.validateNewURL();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAdminMyCoursesURL, expectedAdminMyCoursesURL);

        myCoursesPage.goToMyProfile();
        String actualUserTypeAdmin = myProfilePage.userType();
        String actualUserEmailAdmin = myProfilePage.userEmail();
        String expectedAdminUserEmail = properties.getProperty("ADMIN_LOGIN_EMAIL");

        softAssert.assertEquals(actualUserTypeAdmin, expectedAdminUserType);
        softAssert.assertEquals(actualUserEmailAdmin, expectedAdminUserEmail);

        softAssert.assertAll("Admin Login Validation Failed");
    }
}

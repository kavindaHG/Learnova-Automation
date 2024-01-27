package testCases;

import base.BaseClass;
import factoryData.UserFactoryData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.EmailVerificationPage;

public class EmailVerificationTest extends BaseClass {

    EmailVerificationPage emailVerificationPage;

    private final String defaultRegistrationEmail = UserFactoryData.createNewUserData().getEmail();

//    @AfterMethod
//    public void tearDown(){
//        webDriver.quit();
//    }

    @Test
    public void verifyEmailAddress(){
        emailVerificationPage = new EmailVerificationPage();
        String newUserEnteredEmailAddress = emailVerificationPage.validateEmailAddress();
//        SoftAssert softAssert = new SoftAssert();
//        softAssert(newUserEnteredEmailAddress, defaultRegistrationEmail);
//        Assert.assertEquals(newUserEnteredEmailAddress, defaultRegistrationEmail);
    }


}

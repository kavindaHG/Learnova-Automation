package testCases;

import base.BaseClass;
import factoryData.CourseFactoryData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.CreateCoursePage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyCoursesPage;

public class CreateCourseTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;
    MyCoursesPage myCoursesPage;
    CreateCoursePage createCoursePage;
    private final String googleFormLink = "https://forms.gle/BvjP5CShBoi6Hs8w7";
    SoftAssert softAssert;

    @Test
    public void LivePaidCourseCoupons() throws InterruptedException {
        homePage = new HomePage();
        loginPage = new LoginPage();
        myCoursesPage = new MyCoursesPage();
        createCoursePage = new CreateCoursePage();

        homePage.clickLoginButton();
        loginPage.login(properties.getProperty("ADMIN_LOGIN_EMAIL"), properties.getProperty("ADMIN_LOGIN_PASSWORD"));
        myCoursesPage.clickCreateCourseButton();
        createCoursePage.createNewCourse(
                CourseFactoryData.createNewCourse().getCourseNamePaidLiveCoupons(),
                CourseFactoryData.createNewCourse().getCourseDescription(),
                CourseFactoryData.createNewCourse().getGoogleForm(),
                CourseFactoryData.createNewCourse().getClassSchedule(),
                CourseFactoryData.createNewCourse().getOutline1(),
                CourseFactoryData.createNewCourse().getOutlineDescription1(),
                CourseFactoryData.createNewCourse().getExpertName1(),
                CourseFactoryData.createNewCourse().getExpertDesignation1(),
                String.valueOf(CourseFactoryData.createNewCourse().getBasicPrice())
                );
        Thread.sleep(10000);
    }
}

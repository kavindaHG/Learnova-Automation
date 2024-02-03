package pageObject;

import actionDriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCoursesPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[1]/div[1]/div/p")
    WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/nav/div/div[2]/div[1]")
    WebElement myProfileButton;

    public MyCoursesPage(){
        PageFactory.initElements(webDriver, this);
    }

    public String validateNewURL() throws InterruptedException {
        Thread.sleep(2000);
        String methodName = "validateNewURL Method";
        System.out.println(methodName + " Is Called");
        return webDriver.getCurrentUrl();
    }

    public String validatePageTitle() {
        String methodName = "validatePageTitle Method";
        System.out.println(methodName + " Is Called");
        return pageTitle.getText();
    }

    public MyProfilePage goToMyProfile() throws InterruptedException {
        String methodName = "goToMyProfile Method";
        System.out.println(methodName + " Is Called");
        Action.click(webDriver, myProfileButton);
        return new MyProfilePage();
    }
}

package pageObject;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentMyCoursesPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div[1]/div[1]/div/p")
    WebElement pageTitle;

    public StudentMyCoursesPage (){
        PageFactory.initElements(webDriver, this);
    }

    public String validateNewURL() {
        String methodName = "validateNewURL Method";
        System.out.println(methodName + " Is Called");
        return webDriver.getCurrentUrl();
    }

    public String validatePageTitle() {
        String methodName = "validatePageTitle Method";
        System.out.println(methodName + " Is Called");
        return pageTitle.getText();
    }
}

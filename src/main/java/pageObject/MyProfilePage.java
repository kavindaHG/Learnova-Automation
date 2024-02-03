package pageObject;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div[1]/div[1]/div[2]/div/div[3]/div/p")
    WebElement loggedUserType;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/section/div/div/div[2]/section/div/div/div[2]/div[1]/div/div/div/div[1]/div[2]/div/p")
    WebElement loggedUserEmail;

    public MyProfilePage(){
        PageFactory.initElements(webDriver, this);
    }

    public String userType(){
        return loggedUserType.getText();
    }

    public String userEmail(){
        return loggedUserEmail.getText();
    }
}

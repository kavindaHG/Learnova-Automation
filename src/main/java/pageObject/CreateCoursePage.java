package pageObject;

import actionDriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateCoursePage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[2]/div/div/div/div/div/div[1]/div[2]")
    WebElement courseMode;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[3]/div/div/div/div/div/input")
    WebElement courseName;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[4]/div[1]/div/div/div/div/div[1]/div[2]")
    WebElement courseType;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[4]/div[2]/div/div/div/div/div[1]/div[2]")
    WebElement difficulty;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[5]/div/div/div/div/div/textarea")
    WebElement description;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[6]/div[1]/div/div/div/div/div[1]/div[2]")
    WebElement specialization;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[6]/div[2]/div/div/div/div/input")
    WebElement googleFormLink;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[7]/div[1]/div[2]/div/div/div/div/div[2]/div[2]/span")
    WebElement coverImage;

//    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[7]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/span")
//    WebElement bannerImage;

    @FindBy(xpath = "//*[@id=\"tinymce\"]")
    WebElement classSchedule;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[13]/div/div/div/div/div[2]/div[1]/div[1]/div/input")
    WebElement outline1;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[13]/div/div/div/div/div[2]/div[1]/div[2]/div/input")
    WebElement outlineDescription1;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[13]/div/div/div/div/div[2]/div[2]/div/button/div/div")
    WebElement addOutlineButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[14]/div/div/div/div/div[2]/div[1]/div[1]/div/input")
    WebElement expertName;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[14]/div/div/div/div/div[2]/div[1]/div[2]/div/input")
    WebElement expertDesignation;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/section/div[2]/div/div/form/div[14]/div/div/div/div/div[2]/div[1]/div[3]/div/div/div[2]/div[2]/span")
    WebElement addExpertImageButton;

    @FindBy(xpath = "//*[@id=\"price\"]")
    WebElement basePrice;

    public CreateCoursePage() {
        PageFactory.initElements(webDriver, this);
    }

    public void createNewCourse(
                       String courseNameParam,
                       String descriptionParam,
                       String googleFormLinkParam,
                       String classScheduleParam,
                       String outline1Param,
                       String outlineDescription1Param,
                       String expertNameParam,
                       String expertDesignationParam,
                       String basePriceParam){
        Action.type(courseName, courseNameParam);
        Action.type(description, descriptionParam);
        Action.type(googleFormLink, googleFormLinkParam);
        Action.type(classSchedule, classScheduleParam);
        Action.type(outline1, outline1Param);
        Action.type(outlineDescription1, outlineDescription1Param);
        Action.type(expertName, expertNameParam);
        Action.type(expertDesignation, expertDesignationParam);
        Action.type(basePrice, basePriceParam);
    }
}

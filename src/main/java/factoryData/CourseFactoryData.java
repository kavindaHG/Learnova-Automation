package factoryData;

import com.github.javafaker.Faker;
import model.CourseModel;

public class CourseFactoryData {

    private final static Faker faker = new Faker();

    public static CourseModel createNewCourse(){
        CourseModel courseModel = new CourseModel();
        courseModel.setCourseNameFreeLive("Free&Live" + faker.educator().course());
        courseModel.setCourseNameFreeOnDemand("Free&OnDemand" + faker.educator().course());
        courseModel.setCourseNamePaidLiveCoupons("PaidLive-CouponsAccept" + faker.educator().course());
        courseModel.setCourseNamePaidLiveNoCoupons("PaidLive-CouponsNotAccept" + faker.educator().course());
        courseModel.setCourseNamePaidOnDemandCoupons("PaidOnDemand-CouponsAccept" + faker.educator().course());
        courseModel.setCourseNamePaidOnDemandNoCoupons("PaidOnDemand-CouponsNotAccept" + faker.educator().course());
        courseModel.setCourseDescription("This course created using automation");
        courseModel.setGoogleForm("https://forms.gle/BvjP5CShBoi6Hs8w7");
        courseModel.setOutline1("Introduction");
        courseModel.setOutlineDescription1("Introduction to the subject and its modules");
        courseModel.setExpertName1(faker.name().fullName());
        courseModel.setExpertDesignation1(faker.job().position());
        courseModel.setBasicPrice(5000);
        return courseModel;
    }
}

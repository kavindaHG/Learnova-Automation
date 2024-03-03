package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseModel {

    private String courseNameFreeLive;
    private String courseNameFreeOnDemand;
    private String courseNamePaidLiveCoupons;
    private String courseNamePaidLiveNoCoupons;
    private String courseNamePaidOnDemandCoupons;
    private String courseNamePaidOnDemandNoCoupons;
    private String courseDescription;
    private String googleForm;
    private String classSchedule;
    private String outline1;
    private String outlineDescription1;
    private String outline2;
    private String outlineDescription2;
    private String expertName1;
    private String expertDesignation1;
    private String expertName2;
    private String expertDesignation2;
    private Integer basicPrice;
}

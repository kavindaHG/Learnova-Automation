package utility;

import base.BaseClass;

public class Util extends BaseClass {

    public String validateNewURL() {
        String methodName = "validateNewURL Method";
        System.out.println(methodName + " Is Called");
        return webDriver.getCurrentUrl();
    }
}

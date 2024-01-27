package factoryData;

import com.github.javafaker.Faker;
import model.UserModel;

public class UserFactoryData {

    private static final String DEFAULT_PASSWORD="Thepwd@2023";
    private final static Faker faker = new Faker();

    public static UserModel createNewUserData(){
        UserModel userModel = new UserModel();
        userModel.setFirstName(faker.name().firstName());
        userModel.setLastName(faker.name().lastName());
        userModel.setEmail(faker.internet().safeEmailAddress());
        userModel.setPassword(DEFAULT_PASSWORD);
        userModel.setConfirmPassword(DEFAULT_PASSWORD);
        return userModel;
    }
}

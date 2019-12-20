package testdata;

import org.testng.annotations.DataProvider;

public class LoginCredentials {
    @DataProvider(name="LoginCredentials")

    public static Object[][] loginData() {
        return new Object[][] {{"test123@gmail.com","test123"}};
    }
}

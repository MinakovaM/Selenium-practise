package com.app.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class LoginTest extends BaseTest {


    @Test(dataProvider = "invalidData", priority = 0)
    public void testInvalidLogin(String login, String passwd, String errorMessage) {
        Assert.assertEquals(app.login().invalidLoginError(login, passwd), errorMessage);
    }

    @DataProvider(name = "invalidData")
    private Object[][] getLoginData() {

        return new Object[][]{{"testt@gmail.com", "jgjd", "Invalid password."},
                {"jfdkjvnjfdkjbjkbf@xhdgljps.po", "ponjn", "Authentication failed."},
                {"", "123", "An email address required."},
                {"testt@gmail.com", "", "Password is required."},
                {"kopj", "12369874", "Invalid email address."}};
    }
//        return app.loginsForTest();
//}



    @Test (priority = 1)
    public void testCorrectLogin() {
        app.session().login(app.properties.getProperty("login"), "12369874");
        Assert.assertEquals(app.login().signOutText(), "Sign out");
        app.session().logOut();

    }
}


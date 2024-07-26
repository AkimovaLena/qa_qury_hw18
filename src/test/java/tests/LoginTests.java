package com.demoqa.tests;

import models.AuthResponseBody;
import org.junit.jupiter.api.Test;
import steps.BookSpeps;
import tests.TestBase;

import static data.TestData.login;
import static data.TestData.password;

public class LoginTests extends TestBase {


    @Test
    void successfulLoginWithApiTest() {
        AuthResponseBody dataAuth =new AuthResponseBody();
        BookSpeps steps = new BookSpeps();
        dataAuth = steps.authBrowser(login,password);
    }
}
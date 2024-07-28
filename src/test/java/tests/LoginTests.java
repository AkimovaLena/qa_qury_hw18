package com.demoqa.tests;

import models.AuthResponseBody;
import org.junit.jupiter.api.Test;
import auth.Auth;
import pages.BookPage;
import steps.BookSteps;
import tests.TestBase;

import static data.TestData.*;

public class LoginTests extends TestBase {


    @Test
    void successfulLoginWithApiTest() {
        Auth auth = new Auth();
        AuthResponseBody authData = auth.authApi(login, password);
        BookSteps steps = new BookSteps();
        steps.addBook(authData, isbn);
        BookPage bookPage = new BookPage();
        auth.setCookiesInBrowser(authData);
        bookPage.openBookStore()
                .checkBookInProfile(isbn)
                .deleteBookInProfile(isbn)
                .checkBooksListIsEmpty();
//        steps.checkBooksListIsEmpty();

    }
}
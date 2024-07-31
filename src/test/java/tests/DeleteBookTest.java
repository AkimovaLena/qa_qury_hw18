package tests;

import auth.Auth;
import models.AuthResponseBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BookPage;
import steps.BookSteps;

import static data.TestData.*;


public class DeleteBookTest extends TestBase {

    @Test
    @DisplayName("Проверка удаления книги из профиля")
    void deleteBookInProfileTest() {
        Auth auth = new Auth();
        BookPage bookPage = new BookPage();
        BookSteps steps = new BookSteps();

        AuthResponseBody authData = auth.authApi(login, password);
        steps.deleteAllBooks(authData);
        steps.checkBooksListIsEmpty(steps.getBooksList(authData, login, password));
        steps.addBook(authData, isbn);
        steps.checkBooksListIsNotEmpty(steps.getBooksList(authData, login, password));
        bookPage.openBookStore();
        auth.setCookiesInBrowser(authData);
        bookPage.openBookStore();
        bookPage.checkBookInProfile(isbn)
                .deleteBookInProfile(isbn)
                .checkBooksListIsEmpty();
        steps.checkBooksListIsEmpty(steps.getBooksList(authData, login, password));


    }
}

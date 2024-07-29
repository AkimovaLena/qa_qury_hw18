package steps;

import io.qameta.allure.Step;
import models.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static specs.CreateSpec.*;


public class BookSteps {

    @Step("Добавление книги в корзину профиля")
    public void addBook(AuthResponseBody authResponse, String isbn) {
        AddBookStoreRequestBody request = new AddBookStoreRequestBody();
        request.setUserId(authResponse.getUserId());
        CollectionOfIsbns bookId = new CollectionOfIsbns();
        bookId.setIsbn(isbn);
        request.setCollectionOfIsbns(List.of(bookId));
        given(createRequestSpec)
                .header("Authorization", "Bearer " + authResponse.getToken())
                .body(request)
                .when()
                .post("BookStore/v1/Books")
                .then()
                .spec(responseSpec201);
    }

    @Step("Запрашиваем все книги добавленные в профиль")
    public InfoAccountResponseBody getBooksList(AuthResponseBody authResponse, String userName, String password) {
        AuthRequestBody request = new AuthRequestBody();
        request.setUserName(userName);
        request.setPassword(password);
        return given(createRequestSpec)
                .header("Authorization", "Bearer " + authResponse.getToken())
                .body(request)
                .pathParam("iserId", authResponse.getUserId())
                .when()
                .get("/Account/v1/User/{iserId}")
                .then()
                .spec(responseSpec200)
                .extract().as(InfoAccountResponseBody.class);
    }

    @Step("Проверяем что в профиле нет книг")
    public void checkBooksListIsEmpty(InfoAccountResponseBody infoAccount) {
        assertEquals(infoAccount.getBooks().size(), 0);
    }

    @Step("Проверяем что в профиле есть книги")
    public void checkBooksListIsNotEmpty(InfoAccountResponseBody infoAccount) {
        assertFalse(infoAccount.getBooks().isEmpty());
    }

    @Step("Отправляем запрос на удаление всех книг пользователя")
    public void deleteAllBooks(AuthResponseBody authResponse) {
        given(createRequestSpec)
                .when()
                .header("Authorization", "Bearer " + authResponse.getToken())
                .delete("/BookStore/v1/Books?UserId=" + authResponse.getUserId())
                .then()
                .spec(responseSpec204)
                .statusCode(204);
    }

    ;

}

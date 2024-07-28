package steps;

import io.qameta.allure.Step;
import models.AddBookStoreRequestBody;
import models.AuthResponseBody;
import models.CollectionOfIsbns;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static specs.CreateSpec.createRequestSpec;
import static specs.CreateSpec.responseSpec201;


public class BookSteps {

    @Step("Добавление книги в корзину профиля")
    public void addBook(AuthResponseBody authResponse, String isbn) {
        AddBookStoreRequestBody request = new AddBookStoreRequestBody();
        request.setUserId(authResponse.getUserId());
        CollectionOfIsbns bookId = new CollectionOfIsbns();
        bookId.setIsbt(isbn);
        request.setCollectionOfIsbns(List.of(bookId));
        given(createRequestSpec)
                .header("Authorization", "Bearer " + authResponse.getToken())
                .body(request)
                .when()
                .post("BookStore/v1/Books")
                .then()
                .spec(responseSpec201);
    }

    @Step("Добавление книги в корзину профиля")
    public void checkBooksListIsEmpty(AuthResponseBody authResponse, String isbn) {
//        AddBookStoreRequestBody request = new AddBookStoreRequestBody();
//        request.setUserId(authResponse.getUserId());
//        CollectionOfIsbns bookId = new CollectionOfIsbns();
//        bookId.setIsbt(isbn);
//        request.setCollectionOfIsbns(List.of(bookId));
//        given(createRequestSpec)
//                .header("Authorization", "Bearer " + authResponse.getToken())
//                .body(request)
//                .when()
//                .post("BookStore/v1/Books")
//                .then()
//                .spec(responseSpec201);
    }

}

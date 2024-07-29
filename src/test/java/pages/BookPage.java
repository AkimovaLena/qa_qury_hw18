package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BookPage {

    public final SelenideElement deleteButton = $("#delete-record-undefined"),
            confirmButton = $("#closeSmallModal-ok"),
            noRowsFoundLabel = $(".profile-wrapper").$(".rt-noData");


    @Step("Открываем страницу профиля")
    public BookPage openBookStore() {
        open("/profile");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Проверяем наличие книги в профиле")
    public BookPage checkBookInProfile(String isbn) {
        $("a[href*='/profile?book=" + isbn + "']").should(exist);
        return this;
    }

    @Step("Удаляем книгу из профиля")
    public BookPage deleteBookInProfile(String isbn) {
        deleteButton.click();
        confirmButton.click();
        Selenide.confirm();
        return this;
    }

    @Step("Проверяем, что список книг пустой")
    public BookPage checkBooksListIsEmpty() {
        noRowsFoundLabel.shouldBe(visible).shouldHave(text("No rows found"));
        return this;
    }
}

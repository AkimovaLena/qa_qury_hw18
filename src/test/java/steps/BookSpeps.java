package steps;

import auth.Auth;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.AuthResponseBody;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BookSpeps {

    @Step("Быстрая авторизация через браузер")
    public AuthResponseBody authBrowser(String userName, String password) {
        Auth auth = new Auth();
        AuthResponseBody tmp = auth.authApi(userName, password);
        auth.setCookiesInBrowser(tmp);
        open("/profile");
        $("#userName-value").shouldHave(text(userName));
                return tmp;
    }
}

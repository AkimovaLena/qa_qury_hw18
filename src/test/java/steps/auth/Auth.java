package auth;

import io.qameta.allure.Step;
import models.AuthResponseBody;
import org.openqa.selenium.Cookie;
import io.restassured.response.Response;
import models.AuthRequestBody;
import models.AuthResponseBody;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static specs.CreateSpec.createRequestSpec;
import static specs.CreateSpec.responseSpec200;

public class Auth {

    @Step ("Получение данных для авторизации")
    public AuthResponseBody authApi (String userName, String password) {
        AuthRequestBody request = new AuthRequestBody();
        request.setUserName(userName);
        request.setPassword(password);
        AuthResponseBody authResponse = given(createRequestSpec)
                .body(request)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(responseSpec200)
                .extract().as(AuthResponseBody.class);
        return authResponse;
    }

    @Step("Авторизация пользователя")
    public static void setCookiesInBrowser(AuthResponseBody authResponse) {
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", authResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("expires", authResponse.getExpires()));
        getWebDriver().manage().addCookie(new Cookie("token", authResponse.getToken()));
        open("");
    }

}
package info;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import constants.Constants;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserClient {
    @Step("Login user")
    public ValidatableResponse loginUser(User user) {
        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .baseUri(Constants.BASE_URI)
                .body(user)
                .when()
                .post(Constants.ROOT + "login")
                .then()
                .log()
                .all();
    }

    @Step("Delete user")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .baseUri(Constants.BASE_URI)
                .header("Authorization", accessToken)
                .when()
                .delete(Constants.ROOT + "user")
                .then()
                .log()
                .all();
    }

    @Step("Get token")
    public String getToken(ValidatableResponse response) {
        return response
                .assertThat()
                .body("success", equalTo(true))
                .statusCode(HTTP_OK)
                .extract()
                .body()
                .path("accessToken");
    }

    @Step("User successfully deleted response")
    public void userDeleted(ValidatableResponse response) {
        response
                .assertThat()
                .body("message", equalTo("User successfully removed"))
                .statusCode(HTTP_ACCEPTED);
    }
    @Step ("Создание пользователя")
    public void register (UserCreate userCreate) {
        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .baseUri(Constants.BASE_URI)
                .body(userCreate)
                .when()
                .post(Constants.ROOT + "register")
                .then()
                .log()
                .all();
    }
}
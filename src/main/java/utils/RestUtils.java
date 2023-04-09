package utils;

import java.util.Map;

import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestUtils {

    public static Response performPost(String endpoint, String requestPayload, Map<String, String> headers){
        return given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .when().post()
                .then().log().all().extract().response();
    }
}

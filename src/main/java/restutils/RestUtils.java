package restutils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestUtils {
    private static RequestSpecification getReqSpecs(String endpoint, String requestPayload, Map<String, String> headers){
        return given()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .log().all();
    }

    private static RequestSpecification getReqSpecs(String endpoint, Object requestPayload, Map<String, String> headers){
        return given()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .log().all();
    }

    private static void logRequestInExtent(RequestSpecification reqSpecs){
        QueryableRequestSpecification req = SpecificationQuerier.query(reqSpecs);

        ExtentReportManager.logInfoDetails("ENDPOINT: " + req.getBaseUri());
        ExtentReportManager.logInfoDetails("HTTP METHOD: " + req.getMethod());
        ExtentReportManager.logInfoDetails("REQUEST HEADERS: ");
        ExtentReportManager.logHeaders(req.getHeaders().asList());
        ExtentReportManager.logInfoDetails("REQUEST BODY: ");
        ExtentReportManager.logJson(req.getBody());

    }

    private static void logResponseInExtent(Response res){
        ExtentReportManager.logInfoDetails("RESPONSE CODE: " + res.getStatusCode());
        ExtentReportManager.logInfoDetails("RESPONSE HEADERS: ");
        ExtentReportManager.logHeaders(res.getHeaders().asList());
        ExtentReportManager.logInfoDetails("RESPONSE BODY: ");
        ExtentReportManager.logJson(res.getBody().prettyPrint());
    }

    public static Response performPost(String endpoint, String requestPayload, Map<String, String> headers){
        RequestSpecification req = getReqSpecs(endpoint, requestPayload, headers);
        Response res =  req
                .when().post()
                .then().log().all().extract().response();

        logRequestInExtent(req);
        logResponseInExtent(res);

        return res;
    }

    public static Response performPost(String endpoint, Map<String, Object> requestPayload, Map<String, String> headers){
        RequestSpecification req = getReqSpecs(endpoint, requestPayload, headers);
        Response res =  req
                .when().post()
                .then().log().all().extract().response();

        logRequestInExtent(req);
        logResponseInExtent(res);

        return res;
    }
}

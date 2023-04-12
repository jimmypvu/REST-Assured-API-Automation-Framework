package restutils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class RestUtils {
    private static RequestSpecification getReqSpecs(String endpoint, String requestPayload, Map<String, String> headers){
        return given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    private static RequestSpecification getReqSpecs(String endpoint, Object requestPayload, Map<String, String> headers){
        return given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
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
        ExtentReportManager.logInfoDetails("RESPONSE TIME (ms): " + res.getTimeIn(TimeUnit.MILLISECONDS));
        ExtentReportManager.logInfoDetails("RESPONSE HEADERS: ");
        ExtentReportManager.logHeaders(res.getHeaders().asList());
        ExtentReportManager.logInfoDetails("RESPONSE BODY: ");
        ExtentReportManager.logJson(res.getBody().prettyPrint());
    }

    public static Response performPost(String endpoint, String requestPayload, Map<String, String> headers){
        RequestSpecification req = getReqSpecs(endpoint, requestPayload, headers);
        Response res =  req.post().then().log().all().extract().response();

        logRequestInExtent(req);
        logResponseInExtent(res);

        return res;
    }

    //now you can take request as map or pojo
    public static Response performPost(String endpoint, Object reqPayloadPojo, Map<String, String> headers){
        RequestSpecification req = getReqSpecs(endpoint, reqPayloadPojo, headers);
        Response res =  req.post().then().log().all().extract().response();

        logRequestInExtent(req);
        logResponseInExtent(res);

        return res;
    }
}

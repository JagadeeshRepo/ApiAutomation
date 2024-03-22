package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayLoad, Map<String,String>headers){
        return  RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayLoad);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        queryableRequestSpecification.getBaseUri();
        ExtentReportManager.logInfoDetails("EndPoint is " +queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " +queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are  " +queryableRequestSpecification.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Request Body  is " +queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response Status code is " +response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are  " +response.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Response Body  is " +response.getBody().prettyPrint());
    }
    public static Response performPost(String endPoint, String requestPayLoad, Map<String,String>headers){
        RequestSpecification requestSpecification=getRequestSpecification(endPoint,requestPayLoad,headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }
    public static Response performPost(String endPoint, Map requestPayLoad, Map<String,String>headers){
        RequestSpecification requestSpecification=getRequestSpecification(endPoint,requestPayLoad,headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }

}

package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static gherkin.deps.com.google.gson.internal.bind.TypeAdapters.URI;

public class RestAssuredExtension {

    private static RequestSpecification Request;

    public RestAssuredExtension(){
        //arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://my-json-server.typicode.com/estebanaragonc/API_testing_with_REST-assured_with_BDD_cucumber_in_Java");
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static void GetOpsWithPathParameter(String url, Map<String, String> pathParams){
        //act
        Request.pathParams(pathParams);
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static ResponseOptions<Response> GetOps(String url){
        //act
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }



}

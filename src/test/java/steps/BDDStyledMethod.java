package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class BDDStyledMethod {

    public static void SimpleGetPost(String postNumber) {
        given().contentType(ContentType.JSON).
        when().get(String.format("https://my-json-server.typicode.com/estebanaragonc/API_testing_with_REST-assured_with_BDD_cucumber_in_Java/posts/%s",postNumber)).
        then().body("author", is("esteban"));
    }

    public static void PerformContainsCollection() {
        given().contentType(ContentType.JSON).
        when()
            .get(String.format("https://my-json-server.typicode.com/estebanaragonc/API_testing_with_REST-assured_with_BDD_cucumber_in_Java/posts/")).
        then()
            .body("author", containsInAnyOrder("esteban", "elvis", "typicode")).
                statusCode(200);
    }

    public static void PerformPathParameter()
    {
        given().
            contentType(ContentType.JSON)
        .with().
            pathParam("post", 3).
        when().
            get("https://my-json-server.typicode.com/estebanaragonc/API_testing_with_REST-assured_with_BDD_cucumber_in_Java/posts/{post}").
        then().
            body("author", containsString("esteban"));
    }

    public static void PerformQueryParameter()
    {
        given().
            contentType(ContentType.JSON).
            queryParam("id",3).
        when().
            get("https://my-json-server.typicode.com/estebanaragonc/API_testing_with_REST-assured_with_BDD_cucumber_in_Java/posts/").
        then()
            .body("author", hasItem("esteban"));
    }
}

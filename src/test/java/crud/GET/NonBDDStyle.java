package crud.GET;


import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {
    public static void main(String[] args) {
        //why request specification : as this can be reused.
        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("booking/1");
        rs.when().get();
        rs.then().log().all().statusCode(200);
    }
}

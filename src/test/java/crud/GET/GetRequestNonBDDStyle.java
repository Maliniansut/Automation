package crud.GET;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetRequestNonBDDStyle {
    //TestNg would help run test cases based on groups of priority/regression
    //Test cases should be written in a flow where negative test cases should be written first and then positive.

    @Test(enabled=false)
    public void TestNegative(){
        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("booking/-1").log().all();
        rs.when().get();
        rs.then().log().all().statusCode(404);
    }
    @Test
    public void TestNegative2(){
        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("booking/abc").log().all();
        rs.when().get();
        rs.then().log().all().statusCode(404);
    }
    @Test
    public void TestPositive(){
        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("booking/1").log().all();
        rs.when().get();
        rs.then().log().all().statusCode(200);
    }
}

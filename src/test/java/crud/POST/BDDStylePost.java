package crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDStylePost {
    //Cannot Extract the body
    @Test
    public void TestBDDStylePositive(){
        //What do we need in Post request
        //Url,Body-Payload-JSON,Header-Content type
        String payload="{\n" +
                " \"username\" : \"admin\",\n" +
                "\"password\" : \"password123\" \n" +
                "}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth").contentType(ContentType.JSON).log().all()

                .body(payload).when().post().then().log().all().statusCode(200);

    }
}

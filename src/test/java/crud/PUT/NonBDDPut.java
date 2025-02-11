package crud.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDPut {
    RequestSpecification r;
    ValidatableResponse v;
    String token="da829f2541bfd38";
    @Test
    public void NonBDDPutPositive(){
        //Need: URl,AUth-token,Id,Payload,Headers
        //Id-1122
        //token-da829f2541bfd38
        String payload="{\n" +
                "    \"firstname\": \"Malini\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"deposit paid\": true,\n" +
                "    \"booking dates\": {\n" +
                "        \"checkin\": \"07-02-2025\",\n" +
                "        \"checkout\": \"08-02-2025\"\n" +
                "    },\n" +
                "    \"additional needs\": \"breakfast\"\n" +
                "}";
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/1770");
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();


        //Calling put method on uri,after hitting we get response
        Response response= r.when().put();

        v = response.then().statusCode(403);

    }
}

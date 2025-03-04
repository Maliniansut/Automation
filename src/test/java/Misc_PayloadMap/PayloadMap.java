package Misc_PayloadMap;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PayloadMap {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void testPOSTReq(){
        /*String payload="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}"; */
        //Hashmap(json payload ->parent map -> other child maps)
        Map<String,Object> jsonParentMap= new LinkedHashMap<>(); //Key are generated in random order because of hashmap
        Faker faker = new Faker();                         //If we want to maintain the order we would use linked hashmap,If want in sorted order user treehashmap
        String name=faker.name().fullName();
        jsonParentMap.put("firstname",name);
        jsonParentMap.put("lastname",faker.name().lastName()); //With faker library we can generate dynamic data which is not possible in string payload
        jsonParentMap.put("totalprice",faker.random().nextInt(1000));
        jsonParentMap.put("depositpaid",faker.random().nextBoolean());

        //bookingdates is another hashmap
        Map<String,Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        //Adding child map to parent map
        jsonParentMap.put("bookingdates",bookingDatesMap);
        jsonParentMap.put("additionalneeds","Breakfast");
        System.out.println(jsonParentMap);


        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonParentMap).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingId= response.then().extract().path("bookingId");

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your bookingId is -> "+ bookingId);

        /*validatableResponse.body("firstname", Matchers.equalTo("Jim"));
        validatableResponse.body("lastname",Matchers.equalTo("Brown"));*/
    }


}

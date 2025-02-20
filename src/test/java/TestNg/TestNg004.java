package TestNg;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg004 {
    String token;
    int BookingId;
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @BeforeTest
    public void getToken(){
        System.out.println("--Get Token Id--");
        RequestSpecification r= RestAssured.given();
        String payload="{\n" +
                " \"username\" : \"admin\",\n" +
                "\"password\" : \"password123\" \n" +
                "}";
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");                            //stored when in response
        r.contentType(ContentType.JSON);                   //stored then in validatable response
        r.body(payload).log().all();
        Response response = requestSpecification.when().post();
        validatableResponse= response.then();

        //Rest Assured->Matchers
        validatableResponse.body("token", Matchers.notNullValue());

        token=response.then().log().all().extract().path("token");

        //TestNg Assertions
        Assert.assertNotNull(token);
    }

    @BeforeTest
    public void getBookingId(){
        System.out.println("--Get Booking Id");
        requestSpecification=RestAssured.given();
        String payload="{\n" +
                "    \"firstname\": \"Amit\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"deposit paid\": true,\n" +
                "    \"booking dates\": {\n" +
                "        \"checkin\": \"07-02-2025\",\n" +
                "        \"checkout\": \"08-02-2025\"\n" +
                "    },\n" +
                "    \"additional needs\": \"breakfast\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        Response response= requestSpecification.when().post();

        ValidatableResponse validatableResponse= response.then();
        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse.statusCode(500);

        BookingId= response.then().extract().path("booking id");
        System.out.println(BookingId);
    }

    @Test
    public void PutRequest0(){
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
        String payloadPatch="{\n" +
                "    \"firstname\" : \"Abhishek\",\n" +
                "    \"lastname\" : \"Thakur\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/"+ BookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPatch).log().all();


        //Calling put method on uri,after hitting we get response
        Response response= requestSpecification.when().put();

        validatableResponse= response.then().statusCode(200);
        validatableResponse.body("firstname",Matchers.equalTo("Malini"));
        validatableResponse.body("lastname",Matchers.equalTo("Brown"));
    }

    @Test
    public void PutRequestNegative(){
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
        String payloadPatch="{\n" +
                "    \"firstname\" : \"Abhishek\",\n" +
                "    \"lastname\" : \"Thakur\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/"+ BookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPatch).log().all();


        //Calling put method on uri,after hitting we get response
        Response response= requestSpecification.when().put();

        validatableResponse= response.then().statusCode(200);
        validatableResponse.body("firstname",Matchers.equalTo("Malini"));
        validatableResponse.body("lastname",Matchers.equalTo("Brown"));

        //assertJ
        //assertThat(token).isNotNull().isNotEmpty();
    }



}

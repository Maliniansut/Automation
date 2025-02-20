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
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.assertj.core.api.Assertions.assertThat;

public class TestNg003 {
    //Put Method
    //Before Token,Id,header
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;
    @BeforeTest
    public void getToken(){
        RequestSpecification r= RestAssured.given();
        String payload="{\n" +
                " \"username\" : \"admin\",\n" +
                "\"password\" : \"password123\" \n" +
                "}";
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");                            //stored when in response
        r.contentType(ContentType.JSON);                   //stored then in validatable response
        r.body(payload);
        Response response = requestSpecification.post();
        validatableResponse= response.then();

        //Rest Assured->Matchers
        validatableResponse.body("token", Matchers.notNullValue());

        token=response.then().log().all().extract().path("token");

        //TestNg Assertions
        Assert.assertNotNull(token);
        //if want to check fpr empty string need to use if string method for it.
        /*if(token.isEmpty()){
            Assert.assertTrue(false);
        }*/



        //assertJ: Can use more than 1 function in a single line whereas TestNg doesn't allow this.

        //assertThat(token).isNotBlank().isNotEmpty();


        System.out.println(token);

    }

    @Test
    public void NonBDDStylePutRequest(){
        String jsonString="{\n" +
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
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token");
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/2769");
    }

}

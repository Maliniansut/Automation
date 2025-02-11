package crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

public class NonBDDStylePost {
    ValidatableResponse v;
    Response rs;
    @Test
    public void PostNonBDDStylePositive(){
        //NonBdd can extract the body

        //Preparation Request
        RequestSpecification r= RestAssured.given();
        String payload="{\n" +
                " \"username\" : \"admin\",\n" +
                "\"password\" : \"password123\" \n" +
                "}";
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");                            //stored when in response
        r.contentType(ContentType.JSON);                   //stored then in validatable response
        r.body(payload);                                   //given is assigned to a request specification interface
                                                           //All these are interfaces which can be reused so this increase reusability.

        //Response is an interface which contains all the response methods
        //Advantage of using Response: can get validtable response and also get response in string type method.

        //Making Request
        Response rs=r.when().post();

        //Validation Part
        ValidatableResponse v= rs.then();
        String responseString= rs.asString();
        System.out.println(responseString); // response here we should get is token
        v.statusCode(200);
    }
    @Test
    public void PostNonBDDStylePositive2(){
        //NonBdd can extract the body
        RequestSpecification r= RestAssured.given();
        String payload="{\n" +
                " \"username\" : \"admin\",\n" +
                "\"password\" : \"password123\" \n" +
                "}";
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");                            //stored when in response
        r.contentType(ContentType.JSON);                   //stored then in validatable response
        r.body(payload);                                   //given is assigned to a request specification interface
        //All these are interfaces which can be reused so this increase reusability.

        //Response is an interface which contains all the response methods
        //Advantage of using Response: can get validtable response and also get response in string type method.
        Response rs=r.when().post();
        ValidatableResponse v= rs.then();
        String responseString= rs.asString();
        System.out.println(responseString); // response here we should get is token
        v.statusCode(200);
    }
}
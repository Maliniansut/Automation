package crud.GET;

import io.restassured.RestAssured;

public class BDDStyle {
    public static void main(String[] args) {
        //get Request
        //Url
        //Header
        //Get method
        //Base url = https://api.zippopotam.us/IN/171009
        //Base Path=/IN/171009
        //Payload
        //AUth

        //Status Code
        //Response Body
        //Time,Header,Cookie

        //BDD is a framework which uses Gherkins Syntax(Given,when,Then-->)
        //With Non-BDD also I can use Gherkins Syntax
        //RestAssured has its own domain specific language
        //in case of Bdd we cannot use request specification as it will not be reused rather it would duplicate the code.
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us").basePath("/IN/171009")
                .when().log().all()
                .get()
                .then().log().all().statusCode(200);
    }
}

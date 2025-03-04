package gson;

//import com.sun.net.httpserver.Request;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

//import static io.restassured.RestAssured.requestSpecification;

public class DemoPojoGson {
    //Pojo Class Rules :
    /*1.private variables 2.Getter and setter if want to access variable outside class 3.default public variable*/
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void testPost(){
        Booking booking = new Booking();
        booking.setFirstname("Maliniansu");
        booking.setLastname("Thakur");
        booking.setTotalprice(1113);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-02");
        bookingdates.setCheckout("2024-02-03");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        /*requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingId= response.then().extract().path("bookingId");

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your bookingId is -> "+ bookingId);*/
    }


}
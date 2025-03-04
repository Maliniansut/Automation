package gson;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import static io.restassured.RestAssured.requestSpecification;

public class PostReqTC {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void testPositive(){
        //Preparing payload
        Booking booking = new Booking();
        Faker faker =new Faker();
        String expectedFirstname = faker.name().firstName();
        booking.setFirstname(expectedFirstname);
        booking.setLastname("Thakur");
        booking.setTotalprice(1113);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-02");
        bookingdates.setCheckout("2024-02-03");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        //Object ->jsonString using GSON
        Gson gson= new Gson();
        String jsonBookingString = gson.toJson(booking);
        System.out.println(jsonBookingString);

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBookingString).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asPrettyString();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);

        //Validate Response (json String-> Object)
        //Gson gson = new Gson();
        BookingResponse bookingResponseObject= gson.fromJson(jsonResponseString, BookingResponse.class);
        assertThat(bookingResponseObject.getBookingid()).isNotNull();
        assertThat(bookingResponseObject.getBooking().getFirstname()).isEqualTo(expectedFirstname);


    }

}

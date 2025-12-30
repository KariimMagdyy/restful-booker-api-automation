package services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.requests.Booking;
import specs.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class BookingService {

    public static Response createBooking(RequestSpecification spec, Booking bookingData){
        return given().spec(spec)
                .when()
                .body(bookingData)
                .post("/booking");
    }

    public static Response getBooking(RequestSpecification spec, int bookingId){
        return given().spec(spec)
                .when()
                .get("/booking/"+bookingId);
    }

    public static Response updateBooking(RequestSpecification spec, int bookingId, Booking bookingData){
        return given().spec(spec)
                .when()
                .body(bookingData)
                .put("/booking/"+bookingId);
    }

    public static Response deleteBooking(RequestSpecification spec, int bookingId){
        return given().spec(spec)
                .when()
                .delete("/booking/"+bookingId);
    }
}

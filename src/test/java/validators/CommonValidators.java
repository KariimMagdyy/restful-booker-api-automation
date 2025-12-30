package validators;

import io.restassured.response.Response;
import models.requests.Booking;

import static org.hamcrest.Matchers.equalTo;

public class CommonValidators {
    public static void assertStatusCode(Response response, int expectedStatus){
        response.then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(expectedStatus);
    }

    public static void assertField(Response response, String jsonPath, Object expectedValue) {
        response.then()
                .log().ifValidationFails()
                .assertThat()
                .body(jsonPath, equalTo(expectedValue));
    }

    public static void assertCreateBookingResponse(Response response, Booking payload) {

        assertField(response, "booking.firstname", payload.getFirstname());
        assertField(response, "booking.lastname", payload.getLastname());
        assertField(response, "booking.totalprice", payload.getTotalprice());
        assertField(response, "booking.depositpaid", payload.isDepositpaid());

        assertField(response, "booking.bookingdates.checkin",
                payload.getBookingdates().getCheckin());

        assertField(response, "booking.bookingdates.checkout",
                payload.getBookingdates().getCheckout());

        assertField(response, "booking.additionalneeds",
                payload.getAdditionalneeds());
    }

    public static void assertBookingResponse(Response response, Booking payload) {

        assertField(response, "firstname", payload.getFirstname());
        assertField(response, "lastname", payload.getLastname());
        assertField(response, "totalprice", payload.getTotalprice());
        assertField(response, "depositpaid", payload.isDepositpaid());

        assertField(response, "bookingdates.checkin",
                payload.getBookingdates().getCheckin());

        assertField(response, "bookingdates.checkout",
                payload.getBookingdates().getCheckout());

        assertField(response, "additionalneeds",
                payload.getAdditionalneeds());
    }
}

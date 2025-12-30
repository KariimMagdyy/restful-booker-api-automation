package tests;

import data.PayloadFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.requests.Booking;
import models.responses.CreateBookingResponse;
import org.testng.annotations.Test;
import services.BookingService;
import specs.RequestSpecFactory;
import validators.CommonValidators;

public class BookingTests{

    @Test(groups = "Smoke")
    public void createBookingTest()  {

        Booking payload = PayloadFactory.validBooking();
        RequestSpecification spec = RequestSpecFactory.getBaseSpec();
        Response response = BookingService.createBooking(spec,payload);
        CommonValidators.assertStatusCode(response,200);
        CommonValidators.assertCreateBookingResponse(response,payload);
    }

    @Test(groups = "Smoke")
    public void getBookingTest() {

        Booking payload = PayloadFactory.validBooking();
        RequestSpecification spec = RequestSpecFactory.getBaseSpec();
        Response createResponse = BookingService.createBooking(spec,payload);
        int bookingId = createResponse.as(CreateBookingResponse.class).getBookingid();
        Response getResponse = BookingService.getBooking(spec,bookingId);
        CommonValidators.assertStatusCode(getResponse, 200);
        CommonValidators.assertBookingResponse(getResponse, payload);
    }


    @Test(groups = "Smoke")
    public void updateBookingTest(){

        Booking payload = PayloadFactory.updatedBooking();
        RequestSpecification spec = RequestSpecFactory.getAuthSpec();
        Response createResponse = BookingService.createBooking(spec,payload);
        int bookingId = createResponse.as(CreateBookingResponse.class).getBookingid();
        Response updateResponse = BookingService.updateBooking(spec, bookingId, payload);
        CommonValidators.assertStatusCode(updateResponse, 200);
        CommonValidators.assertBookingResponse(updateResponse, payload);
    }

    @Test(groups = "Smoke")
    public void deleteBookingTest() {
        Booking payload = PayloadFactory.validBooking();
        RequestSpecification spec = RequestSpecFactory.getAuthSpec();
        Response createResponse = BookingService.createBooking(spec, payload);
        int bookingId = createResponse.as(CreateBookingResponse.class).getBookingid();
        Response deleteResponse = BookingService.deleteBooking(spec,bookingId);
        CommonValidators.assertStatusCode(deleteResponse, 200);
        CommonValidators.assertBookingResponse(deleteResponse, payload);
    }

    @Test(groups = "Negative")
    public void invalidBookingDatesTest(){
        Booking payload = PayloadFactory.invalidBooking();
        RequestSpecification spec = RequestSpecFactory.getBaseSpec();
        Response response = BookingService.createBooking(spec,payload);
        CommonValidators.assertStatusCode(response,400);
    }

    @Test(groups = "Negative")
    public void updateWithoutAuthTest(){
        Booking payload = PayloadFactory.validBooking();
        RequestSpecification spec = RequestSpecFactory.getBaseSpec();
        Response createResponse = BookingService.createBooking(spec,payload);
        int bookingId = createResponse.as(CreateBookingResponse.class).getBookingid();
        Response updateResponse = BookingService.updateBooking(spec, bookingId, payload);
        CommonValidators.assertStatusCode(updateResponse,403);
    }
}

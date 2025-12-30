package data;

import models.requests.Booking;
import models.requests.Bookingdates;

public class PayloadFactory {

    public static Booking validBooking(){
        Booking booking = new Booking();
        Bookingdates dates = new Bookingdates();

        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        dates.setCheckin("2024-01-01");
        dates.setCheckout("2024-01-10");
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Breakfast");

        return booking;
    }

    public static Booking updatedBooking(){
        Booking booking = new Booking();
        Bookingdates dates = new Bookingdates();

        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(222);
        booking.setDepositpaid(false);
        dates.setCheckin("2024-02-01");
        dates.setCheckout("2024-02-10");
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Lunch");

        return booking;
    }

    public static Booking invalidBooking(){
        Booking booking = new Booking();
        Bookingdates dates = new Bookingdates();

        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(50);
        booking.setDepositpaid(true);
        dates.setCheckin("");
        dates.setCheckout("");
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Breakfast");

        return booking;
    }
}

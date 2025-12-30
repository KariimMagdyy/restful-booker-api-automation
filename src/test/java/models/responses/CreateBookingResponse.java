package models.responses;

public class CreateBookingResponse {

    private int bookingid;
    private models.requests.Booking booking;

    public CreateBookingResponse() {}

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public models.requests.Booking getBooking() {
        return booking;
    }

    public void setBooking(models.requests.Booking booking) {
        this.booking = booking;
    }
}

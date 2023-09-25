package com.CarBokingWeb.Services;



import java.util.List;

import com.CarBokingWeb.Entities.Booking;
import com.CarBokingWeb.Entities.User;

public interface BookingService {

	Booking getBookingById(int bookingId);
    List<Booking> getAllBookings();
    List<Booking> getBookingsByUser(User user);
    
    List<Booking> createBooking(Booking booking);
    
    void updateBooking(Booking booking);
    void deleteBooking(int bookingId);
    
   // List<Booking> getBookingsByUserEmail(String userEmail);
    
     public List<Booking> getBookingsByUserId(int user_id); 
}

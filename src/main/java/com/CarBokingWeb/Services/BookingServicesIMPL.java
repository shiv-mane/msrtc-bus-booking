package com.CarBokingWeb.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CarBokingWeb.Dao.BookingRepository;
import com.CarBokingWeb.Dao.UserRepository;
import com.CarBokingWeb.Entities.Booking;
import com.CarBokingWeb.Entities.User;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookingServicesIMPL implements BookingService {

	private  BookingRepository bookingRepository;

    public BookingServicesIMPL(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

	@SuppressWarnings("deprecation")
	@Override
	public Booking getBookingById(int bookingId) {
		// TODO Auto-generated method stub
		return bookingRepository.getById(bookingId);
	}

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return null ;
	}

	@Override
	public List<Booking> getBookingsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> createBooking(Booking booking) {
		// TODO Auto-generated method stub
	//	List<Booking> bookings=  (List<Booking>) bookingRepository.save( booking);
		Booking savedBooking = bookingRepository.save(booking);
		List<Booking> bookings = new ArrayList<>();
		bookings.add(savedBooking);

		
		return bookings;
	}

	@Override
	public void updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBooking(int bookingId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Booking> getBookingsByUserId(int user_id) {
		
		List<Booking>userBookings= bookingRepository.getBookingsByUserId(user_id);
		
		return userBookings;
	}

      public Booking findById(int bookingId) {
    	Booking bookingData=bookingRepository.findById(bookingId);
    	  return bookingData;
      }

	

	
	

	

    
}

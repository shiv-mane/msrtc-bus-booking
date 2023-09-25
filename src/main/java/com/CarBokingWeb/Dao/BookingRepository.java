package com.CarBokingWeb.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CarBokingWeb.Entities.Booking;

import jakarta.transaction.Transactional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
   
	Booking findById(int bookingId);
	
	
//	 List<Booking> findByUserEmail(String userEmail);
	  List<Booking> getBookingsByUserId(int user_Id);
	 
	 @Transactional
     public void deleteById(int id);
	 
//	 Booking findbyBookingID(in bookingId);
	
}


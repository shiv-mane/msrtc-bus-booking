package com.CarBokingWeb.Entities;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	@Column(name = "startLocation")
	private String from;
	
	@Column(name = "endLocation")
	private String to;
	
	@Column(name = "bookingDate")
	private String date;
	
	@Column(name = "bookingTime")
	private String time;
	
	private String comfortLevel;
	private int bookingPayment;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	
	
	
	
	
//------------------------------constuctor-------------------------------------------------------------------
 //non parameterized constructor
	public Booking(int bookingId, String from, String to, String date, String time, String comfortLevel,
			int bookingPayment, User user) {
		super();
		this.bookingId = bookingId;
		this.from = from;
		this.to = to;
		this.date = date;
		this.time = time;
		this.comfortLevel = comfortLevel;
		this.bookingPayment = bookingPayment;
		this.user = user;
	}	
	
	//-----------default constructor-----------
	public Booking()
	{
	     super();
     }


	//---------------------------------------get-- set go-------------------------------------------------------------
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComfortLevel() {
		return comfortLevel;
	}

	public void setComfortLevel(String comfortLevel) {
		this.comfortLevel = comfortLevel;
	}

	public int getBookingPayment() {
		return bookingPayment;
	}

	public void setBookingPayment(int bookingPayment) {
		this.bookingPayment = bookingPayment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	//-------------------------to string method for booking ---------------------------------------------------------------
	@Override
	public String toString()
	{
		return "Booking [bookingId=" + bookingId + ", from=" + from + ", to=" + to + ", date=" + date + ", time=" + time
				+ ", comfortLevel=" + comfortLevel + ", bookingPayment=" + bookingPayment + ", user=" + user + "]";
	}

	
	
	
}

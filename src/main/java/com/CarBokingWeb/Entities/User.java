package com.CarBokingWeb.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
//	@Column(unique = true)
	private String email;
	private String password;
	
    private String contactNo;
	private String city;
	private String state;
	private String currentAddress;
	
	
	
	
	
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Booking> booking = new ArrayList<Booking>();


// ------------------------------default constructor-----------------------------------------
	 public User() {
			super();
		}

//------------------------------ paramerized constructor----------------------------------------
	 public User(int id, String name, String email, String password, String contactNo, String city, String state,
				String currentAddress, List<Booking> booking) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			this.contactNo = contactNo;
			this.city = city;
			this.state = state;
			this.currentAddress = currentAddress;
			this.booking = booking;
		}
	
	
	
//-----------------------------------getters and setters---------------------------------------------------------------

	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

    public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNO) {
		this.contactNo = contactNO;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public List<Booking> getBooking() {
		return booking;
	}

   
	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	
    
    
   //--------------------------------toString methods------------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", contactNO="
				+ contactNo + ", city=" + city + ", state=" + state + ", currentAddress=" + currentAddress
				+ ", booking=" + booking + "]";
	}

	
	
}

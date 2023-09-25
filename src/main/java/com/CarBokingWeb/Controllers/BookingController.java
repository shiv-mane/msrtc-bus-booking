package com.CarBokingWeb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookingController {

	
	@Autowired
	//  private UserRepository userRepository; 
	  
	// @Autowired
	//  private BookingRepository bookingRepository;
	  
	 
//	 @Autowired
//	  private UserServices userServices;
	  
//	  @Autowired
//	  private BookingService bookingService;

	
	
	
	
	
	 //---------------------booking controllers---------------------------------------------------      
    
  

  
    
//  @PostMapping("/postbookingdetails")
//  public String createBooking(@ModelAttribute Booking booking, @RequestParam int id) {
//      // Retrieve the user from the database
//	  // Retrieve the user from the database
//      Optional<User> optionalUser = userRepository.findById(id);
//      
//      if (optionalUser.isPresent()) {
//          User user = optionalUser.get();
//          
//          // Set the user for the booking
//          booking.setUser(user);
//          // Save the booking to the database
//          bookingRepository.save(booking);
//          
//          return "bookingdetails";
//      }
//      
//      // Handle the case when user with the given ID is not found
//      // You can redirect to an error page or display an error message
//      
//      return "redirect:/error";
//  }
    
  
  @PostMapping("/payment")  
  public String payment()
  {
	  
	   return "payment";
  }
	
}


//this.bookingRepository.save(booking);
//User user1=userServices.getUserById((long) user.getId());
//  System.out.println("booking usr data = "+user);
//if(user.getEmail()!=null) {
//  User user1=userServices.createUser(user);
//  booking.setUser(user1);	
//  this.bookingService.createBooking(booking);
//}

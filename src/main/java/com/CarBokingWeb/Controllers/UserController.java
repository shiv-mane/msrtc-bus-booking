package com.CarBokingWeb.Controllers;


import java.util.List;

import org.aspectj.weaver.patterns.IScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CarBokingWeb.Dao.BookingRepository;
import com.CarBokingWeb.Dao.UserRepository;
import com.CarBokingWeb.Entities.Booking;
import com.CarBokingWeb.Entities.User;
import com.CarBokingWeb.Services.BookingService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	
	@Autowired
	  private UserRepository userRepository; 
	  
	  @Autowired
	  private BookingService bookingService;

	  @Autowired
	  private BookingRepository bookingRepository;
	
	
//--------------------------home page----------------------------------------------------	
		 @GetMapping("/msrtc")
	     public String basepage(Model m ) 
	     {
	      m.addAttribute("name","this is home page" );
			return "index";
		  }

		 @GetMapping("/home")
	     public String home() 
	      {
	        return "home";
		  }
	
//------------------------signup page--------------------------------------------------------       
    @GetMapping("/signup")
    public String signup(Model model) 
  {
   User user= new User();
   model.addAttribute("user", user);
    return "signup";
  }
//-----------------------------------------------------------------------------------------    
  
   //create user for set values
    User signupUser = new User();
    
    @PostMapping("/showdetails")
    public String adduser( @ModelAttribute("user") User user,HttpSession session)
    {
      boolean userExist=userRepository.existsByEmail(user.getEmail());
     
      if (userExist) {
			session.setAttribute("msg", "email id already exist");
			return "redirect:/signup";
		}
      else {
       User user1= new User();
       user1= userRepository.save(user);
  
        this.signupUser=user;
    	System.out.println("sign up user details = "+this.signupUser);
       }
      return "showdetails"; 
    }
//--------------------------------------------------------------------------------------------    
   
    @GetMapping("/booking")
    public String booking( Model model) 
  {    
    Booking booking = new Booking();
    model.addAttribute("booking", booking);
    
     return "booking";
  }
    
   
  @PostMapping("/postbookingdetails")  
  public String bookingdetails(@ModelAttribute("booking") Booking booking, Model model)
  {
//	  HttpSession session,
//	  (User) session.getAttribute("user");   
       User user1 = this.signupUser;        
       booking.setUser(user1);
       
      Booking booking1=this.bookingRepository.save(booking);
  
	  System.out.println("user deatails in post booking handler = "+user1);
	   System.out.println("booking details in post booking handler ="+booking1);
	   
	   model.addAttribute("user", booking.getUser());
	   model.addAttribute("booking1", booking1);
	   

	   return "bookingdetails";
  }
    
  
  @PostMapping("/cancelBooking")
  public String cancelBooking(@RequestParam("bookingId") int bookingId, Model model) {
      // Find the booking by its ID
      Booking booking = bookingRepository.findById(bookingId);

      if (booking != null) {
          // Delete the booking
          bookingRepository.deleteById(bookingId);
          model.addAttribute("message", "Booking with ID " + bookingId + " has been canceled.");
          System.out.println("booking is deleted");
          return "home"; // Redirect to the home page or any other appropriate page
      } else {
          model.addAttribute("message", "Booking with ID " + bookingId + " not found.");
          System.err.println("booking details are not found please correct the code");
          return "home"; // Redirect to the home page or any other appropriate page
      }
  }
  
 
 
//--------------------------------------------------login form------------------------------------------	
   
    @GetMapping("/login")
    public String login(Model model) 
  {
   User user= new User();
   model.addAttribute("user", user);
   
   Booking bookings = new Booking();
   model.addAttribute("booking", bookings);
   return "login";
  }
    

    @PostMapping("/getlogindata")
    public String loginUser(@ModelAttribute("user") User user,@ModelAttribute ("booking") Booking booking, Model model)
    {
        User storedUser = userRepository.findByName(user.getName());
        if (storedUser != null && storedUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("user", storedUser);
            
            List<Booking> userBookings = bookingService.getBookingsByUserId(storedUser.getId());
            
            System.out.println(userBookings);
            return "loginDetails";
        } 
        else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    
    }
    
    
      //---------------------------about page---------------------------------------------------
        @GetMapping("/about")
        public String about(Model m ) 
      {
         m.addAttribute("name","this is about page" );
		return "about";
	  }

    
      //-----------------------help page controller------------------------------------------------
        @GetMapping("/help")
        public String help(Model m ) {
        
		return "help";
	  }
        
    
    
	
}






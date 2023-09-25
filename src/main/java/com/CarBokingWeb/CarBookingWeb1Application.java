package com.CarBokingWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//(
//		exclude = {ThymeleafAutoConfiguration.class}
//		)
//@ComponentScan(basePackages = {"com.CarBokingWeb.Controllers"})
public class CarBookingWeb1Application {
	
	  public static void main(String[] args) {
		SpringApplication.run(CarBookingWeb1Application.class, args);
		System.out.println("hiii.........shiv");
	}

}

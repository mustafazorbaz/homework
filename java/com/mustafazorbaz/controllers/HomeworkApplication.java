package com.mustafazorbaz.controllers;
 
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.mustafazorbaz.services.MerchantTransactionServicesImpl;
 /**
  * 
  * @author Mustafa
  *  Bu class Spring  Spring Boot yapısını oluşturduk.Packageleri içerisini taratarak beanlerin bulunmasını sağlıyor.
  */
@SpringBootApplication
@ComponentScan({"com.mustafazorbaz.dao","com.mustafazorbaz.services","com.mustafazorbaz.controllers"})
@EntityScan("com.mustafazorbaz.entitiy")
public class HomeworkApplication {
 
	public static void main(String[] args) {
	 	  SpringApplication.run(HomeworkApplication.class, args);
		 
		 
	}
	 

}

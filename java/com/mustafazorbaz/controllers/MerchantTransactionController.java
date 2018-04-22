package com.mustafazorbaz.controllers;
 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;

import com.mustafazorbaz.entities.Client; 
import com.mustafazorbaz.entities.TransactionQuery;
import com.mustafazorbaz.entities.TransactionReport;
import com.mustafazorbaz.entities.User;
import com.mustafazorbaz.services.MerchantTransactionServices; 
/**
 * 
 * @author Mustafa
 * 	MerchantTransactionController tanımlayarak işlerin geneli bu class'tan sağlanmaktadır.
 * Bu Controller Login ve Transaction işlerinin yapılmasında etkilidir.
 */
@Controller
public class MerchantTransactionController {

	@Autowired 
	private MerchantTransactionServices merchantTransactionServices  ; 
	  
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView view = new ModelAndView("login"); 
		User user =new User();
		view.addObject("user",user);
		return view;
	}
	/* 
	@RequestMapping("/template")
	public ModelAndView template(HttpSession session) {
		 User userSession = (User)session.getAttribute("user");
	   	 System.out.println(userSession.getToken());
		return new ModelAndView("template");
	}
	*/
	@RequestMapping("/loginPageSubmit")
	public ModelAndView loginPageSubmit(@ModelAttribute("user")User user,HttpSession session) {
		ModelAndView view = new ModelAndView("login");
		merchantTransactionServices.getUser(user);
		System.out.println("EMAİL"+user.getEmail()+" ŞİFRE"+user.getPassword()+"STATUS :"+user.getStatus());

	 	 if(user.getStatus().equals("APPROVED")){			 
	 		ModelAndView view2 = new ModelAndView("dashboards"); 
	 		 view2.addObject("user",user);  
	 		 return view2;
	 	 }
	 	 System.out.println(user.getStatus());
	 	 return view;
	}
	@RequestMapping("/transactionReportForm")
	public ModelAndView transactionReporForm(HttpSession session) {
		TransactionReport report =new TransactionReport(); 
		ModelAndView view = new ModelAndView("dashboardsTransactionReportForm");  
		 User userSession = (User)session.getAttribute("user");
		 view.addObject("user",userSession);
	    view.addObject("transactionReport",report);  
	    return view;
	}
	@RequestMapping("/transactionReport")
	public ModelAndView transactionReport(@ModelAttribute("transactionReport")TransactionReport report, HttpSession session) {
		ModelAndView view = new ModelAndView("dashboardsTransactionReport");  
		
	     return view;
	}
	

}
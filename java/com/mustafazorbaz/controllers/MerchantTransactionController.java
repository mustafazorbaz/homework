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
		 User userSession = (User)session.getAttribute("user");
	   	 System.out.println(userSession.getToken());  
	   	  merchantTransactionServices.getTransactionReport(report, userSession.getToken());
	   	  
	   	 if(report.getStatus().equals("APPROVED")){
		 
			 view.addObject("transactionReport",merchantTransactionServices.getTransactionReport(report, userSession.getToken()));
			 view.addObject("message","Sonuç Başarılı");   
			 view.addObject("user",userSession);
		     return view;
		 }
		 else if(report.getStatus().equals("DECLINED")){
			 view.addObject("message","Sonuç Başarısız");  
			 view.addObject("user",userSession);
		     return view;
		  }
	   	 view.addObject("message","Başarısız...");  
	     return view;
	}
	@RequestMapping("/transactionReportTest")
	public ModelAndView transactionReportTest(User user,HttpSession session) {
		ModelAndView view = new ModelAndView("dashboardsTransactionReport");  
		 User userSession = (User)session.getAttribute("user");
	   	 System.out.println(userSession.getToken());
	   	 TransactionReport report=new TransactionReport("2015-10-01", "2015-10-01", 1, 1);
	  	 view.addObject("transactionReport",merchantTransactionServices.getTransactionReportTest());
		 view.addObject("message","Sonuç Başarılı");   
		 view.addObject("user",userSession);
		 return view;
		  
	}
	
	@RequestMapping("/transactionQueryForm")
	public ModelAndView transactionQueryForm(HttpSession session) {
		TransactionQuery query =new TransactionQuery(); 
		ModelAndView view = new ModelAndView("dashboardsTransactionQueryForm");  
		 User userSession = (User)session.getAttribute("user");
		 view.addObject("user",userSession);
	     view.addObject("transactionQuery",query);  
	    return view;
	}
	@RequestMapping("/transactionQuery")
	public ModelAndView transactionReport(@ModelAttribute("transactionQuery")TransactionQuery query, HttpSession session) {
		ModelAndView view = new ModelAndView("dashboardsTransactionQuery");  
		 User userSession = (User)session.getAttribute("user");
		 view.addObject("user",userSession);
		 view.addObject("message","Sonuç Başarılı");
		 view.addObject("transactionQuery",merchantTransactionServices.getTransactionQuery(query, userSession.getToken()));
	     return view;
	}
	@RequestMapping("/transactionQueryTest")
	public ModelAndView transactionQueryTest( HttpSession session) {
		ModelAndView view = new ModelAndView("dashboardsTransactionQuery");
		 User userSession = (User)session.getAttribute("user");
		 view.addObject("user",userSession);
		 view.addObject("message","Sonuç Başarılı");
		 
		 view.addObject("transactionQuery",merchantTransactionServices.getTransactionQueryTest());
	   	  
	     return view;
	}
	@RequestMapping("/getClientForm")
	public ModelAndView getClientForm(HttpSession session) {
		Client client =new Client(); 
		ModelAndView view = new ModelAndView("dashboardsGetClientForm");  
		 User userSession = (User)session.getAttribute("user");
		 view.addObject("user",userSession);
	     view.addObject("getClient",client);  
	    return view;
	}
	@RequestMapping("/getClient")
	public ModelAndView getClient(@ModelAttribute("getClient")  Client client, HttpSession session) {
		ModelAndView view = new ModelAndView("dashboardsGetClient");  
		 User userSession = (User)session.getAttribute("user");
		 view.addObject("user",userSession);
		 view.addObject("message","Sonuç Başarılı");
		 view.addObject("client",merchantTransactionServices.getClient(client, userSession.getToken()));
	     return view;
	}
	@RequestMapping("/getClientTest")
	public ModelAndView getClientTest( HttpSession session) {
		ModelAndView view = new ModelAndView("dashboardsGetClient");
		 User userSession = (User)session.getAttribute("user");
		 view.addObject("user",userSession);
		 view.addObject("message","Sonuç Başarılı");
		 view.addObject("transactionId","1-1444392550-1");
		 view.addObject("Authorization",userSession.getToken());
	     return view;
	}
}
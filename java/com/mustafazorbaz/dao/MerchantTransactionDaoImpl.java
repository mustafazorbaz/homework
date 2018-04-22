package com.mustafazorbaz.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.net.HttpURLConnection; 
import java.net.URL;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mustafazorbaz.entities.Client;
import com.mustafazorbaz.entities.CustomerInfo;
import com.mustafazorbaz.entities.Transaction;
import com.mustafazorbaz.entities.TransactionQuery;
import com.mustafazorbaz.entities.TransactionReport;
import com.mustafazorbaz.entities.TransactionReportResponse;
import com.mustafazorbaz.entities.User; 
 
/***
 * 
 * @author Mustafa
 *	API'den verileri burada çekilmektedir.Bazı tanımlanan fonksiyonlar ile manuel verilerin listelenmesi işleride
 *  bu class içerisinde yapılır.
 */
@Repository
@SessionAttributes(value="user",types = {User.class}) 
public class MerchantTransactionDaoImpl implements MerchantTransactionDao{
	@Autowired
	 HttpSession httpSession; 
 
	public User getUser(User user)  {
		try {
		String url = "https://sandbox-reporting.rpdpymnt.com/api/v3/merchant/user/login?email="+user.getEmail()+"&password="+user.getPassword()+"";
	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        // optional default is GET
	        con.setRequestMethod("POST");
	       // con.addRequestProperty("Authorization",authorization);
	       
 	        //add request header
	        con.setRequestProperty("User-Agent", "Mozilla/5.0");
	        int responseCode = con.getResponseCode();
	        System.out.println("\nSending 'POST' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);
	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	        	response.append(inputLine);
	        }
	        in.close();
	        
	        //print in String
	        System.out.println(response.toString());
	        
	        //Read JSON response and print
	        JSONObject myResponse = new JSONObject(response.toString());
	        System.err.println("result after Reading JSON Response");
	        System.out.println("token - "+myResponse.getString("token"));
	       
	        user.setToken(myResponse.getString("token"));
	        user.setStatus(myResponse.getString("status"));
	        System.err.println("STATUS :"+user.getStatus());
			} catch (Exception e) {
		        e.printStackTrace();
			}
	        sessionSet(user);
	        return user;
		}
	public void sessionSet(User user){
		httpSession.setAttribute("user",user);
	}
	
	
	@Override
	public TransactionReport getTransactionReport(TransactionReport report, String authorization) {
		try {
			
			String url = "https://sandbox-reporting.rpdpymnt.com/api/v3/transactions/report?fromDate="+report.getFromDate()+"&toDate="+report.getToDate()+"&merchant="+report.getMerchant()+"&acquirer="+report.getAcquirer()+"";
	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        // optional default is GET
	        con.setRequestMethod("POST");
	        con.addRequestProperty("Authorization",authorization);
	        //add request header
	        con.setRequestProperty("User-Agent", "Mozilla/5.0");
	        int responseCode = con.getResponseCode();
	        System.out.println("\nSending 'POST' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);
	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	        	response.append(inputLine);
	        }
	        in.close();
	        
	        //print in String
	        System.out.println(response.toString());
	        
	        //Read JSON response and print
	        JSONObject myResponse = new JSONObject(response.toString());
	        System.err.println("result after Reading JSON Response");
	        report= reportClean(report);
	        report.setStatus(myResponse.getString("status"));
		        report.setFromDate(myResponse.getString("fromDate"));
		        report.setMerchant(Integer.parseInt( myResponse.getString("merchant")));
		        report.setToDate(myResponse.getString("toDate"));
		        report.setAcquirer(Integer.parseInt( myResponse.getString("acquirer")));
		        JSONArray values = myResponse.getJSONArray("response"); 
		        for (int i = 0; i < values.length(); i++) {
		        	JSONObject trasctionR = values.getJSONObject(i); 
			        TransactionReportResponse reportResponse=new TransactionReportResponse(Integer.parseInt( trasctionR.getString("count")), Integer.parseInt( trasctionR.getString("total")), trasctionR.getString("currency"));
			        report.addResponse(reportResponse);
	
				}
	        
	       
	       // System.out.println("report - "+report.getStatus()); 
	     //   user.setToken(myResponse.getString("token"));
		} catch (Exception e) {
	        e.printStackTrace();
		}
		return report;
	}
    public TransactionReport reportClean(TransactionReport report){
    	report.setFromDate("");
    	report.setMerchant(0);
    	report.setToDate("");
    	report.setAcquirer(0);
    	return report;
    }
	@Override
	public TransactionQuery getTransactionQuery(TransactionQuery query, String authorization) {
			try {
			
			String url = "https://sandbox-reporting.rpdpymnt.com/api/v3/transaction/list?fromDate="
					+query.getFromDate()+"&toDate="+query.getToDate()+"&merchantId="
					+query.getMerchantId() +"&acquirerId="+query.getAcquirerId()+"&status="
					+query.getStatus()+"&operation="+query.getOperation()+"&paymentMethod="
					+query.getPaymentMethod()+"&filterValue="+query.getFilterValue()+"&page="+query.getPage()+"";
	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        // optional default is GET
	        con.setRequestMethod("POST");
	        con.addRequestProperty("Authorization",authorization);
	        //add request header
	        con.setRequestProperty("User-Agent", "Mozilla/5.0");
	        int responseCode = con.getResponseCode();
	        System.out.println("\nSending 'POST' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);
	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	        	response.append(inputLine);
	        }
	        in.close();
	        
	        //print in String
	        System.out.println(response.toString());
	        
	        //Read JSON response and print
	        JSONObject myResponse = new JSONObject(response.toString());
	        System.err.println("result after Reading JSON Response"); 
	        query.setPage(Integer.parseInt(myResponse.getString("per_page"))); 
	        query.setCurrentPage(Integer.parseInt(myResponse.getString("current_page")));  
	        query.setNextPageUrl(myResponse.getString("next_url")); 
	        query.setPrevPageUrl(myResponse.getString("prev_page_url")); 
	        query.setPrevPageUrl(myResponse.getString("from")); 
	        query.setPrevPageUrl(myResponse.getString("to"));  
	       
	       // System.out.println("report - "+report.getStatus()); 
	     //   user.setToken(myResponse.getString("token"));
		} catch (Exception e) {
	        e.printStackTrace();
		}
		return query;
	}

	@Override
	public Transaction getTransaction(int transactionId, String authorization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionReport getTransactionReportTest() {
		TransactionReport report =new TransactionReport("2015-10-12", "2016-10-12", 1, 2);
		  report.setStatus("APPROVED");  

		        TransactionReportResponse reportResponse1=new TransactionReportResponse(283, 330, "USD");
		        TransactionReportResponse reportResponse2=new TransactionReportResponse(500, 280, "USD");		        
		        TransactionReportResponse reportResponse3=new TransactionReportResponse(283, 330, "EURO");
		        TransactionReportResponse reportResponse4=new TransactionReportResponse(283, 800, "TL");
		        report.addResponse(reportResponse1);
		        report.addResponse(reportResponse2);
		        report.addResponse(reportResponse3);
		        report.addResponse(reportResponse4); 
		        System.out.println("report"+report);
		return report;
	}

	@Override
	public TransactionQuery getTransactionQueryTest() {
		TransactionQuery query=new TransactionQuery("2015-07-01","2015-10-01",1,1,"APPROVED","DIRECT","CREDITCARD","Reference No","1-1568845-56",1);
		query.setPerPage(50);
		query.setCurrentPage(1);
		query.setNextPageUrl("http://reporting.rpdpymnt.com/api/v3/transaction/list/?page=2");
		query.setPrevPageUrl("null");
		query.setFrom(1);
		query.setTo(50);
		return query;
	}

	@Override
	public Client getClient(Client client, String token) {
	try {
			
			String url = "https://sandbox-reporting.rpdpymnt.com/api/v3/client?page="+client.getTransactionId()+"";
	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        // optional default is GET
	        con.setRequestMethod("POST");
	        con.addRequestProperty("Authorization",token);
	        //add request header
	        con.setRequestProperty("User-Agent", "Mozilla/5.0");
	        int responseCode = con.getResponseCode();
	        System.out.println("\nSending 'POST' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);
	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	        	response.append(inputLine);
	        }
	        in.close();
	        
	        //print in String
	        System.out.println(response.toString());
	        
	        //Read JSON response and print
	        JSONObject myResponse = new JSONObject(response.toString());
	        System.err.println("result after Reading JSON Response"); 
	        CustomerInfo customerInfo=new CustomerInfo();
	        customerInfo.setId( myResponse.getString("id"));
	        customerInfo.setCreatedAt(myResponse.getString("created_at"));
	        customerInfo.setUpdatedAt(myResponse.getString("updated_at"));
	        customerInfo.setDeletedAt(myResponse.getString("deleted_at"));
	        customerInfo.setNumber(Long.parseLong(myResponse.getString("number")));
	        customerInfo.setExpiryMonth(myResponse.getString("expiryMonth"));
	        customerInfo.setStartMonth(myResponse.getString("startMonth"));
	        customerInfo.setStartYear(myResponse.getString("startYear"));
	        customerInfo.setStartYear(myResponse.getString("startYear"));
	        customerInfo.setStartYear(myResponse.getString("issueNumber"));
	        customerInfo.setStartYear(myResponse.getString("email"));
	        client.addCustomerInfo(customerInfo);
	        
	       
	        //System.out.println("client - "+client.getCustomerInfo().get(0).getId()); 
	     //   user.setToken(myResponse.getString("token"));
		} catch (Exception e) {
	        e.printStackTrace();
		}
		return client;
	}
}

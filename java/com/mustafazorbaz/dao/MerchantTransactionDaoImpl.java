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
    
    	return report;
    }
	@Override
	public TransactionQuery getTransactionQuery(TransactionQuery query, String authorization) {
	
		return query;
	}

	@Override
	public Transaction getTransaction(int transactionId, String authorization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionReport getTransactionReportTest() {
		// TODO Auto-generated method stub
		return report;
	}

	@Override
	public TransactionQuery getTransactionQueryTest() {
		
	}

	@Override
	public Client getClient(Client client, String token) {
		// TODO Auto-generated method stub
		return client;
	}
}

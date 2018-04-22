package com.mustafazorbaz.services;
   
import com.mustafazorbaz.entities.Client;
import com.mustafazorbaz.entities.Transaction;
import com.mustafazorbaz.entities.TransactionQuery;
import com.mustafazorbaz.entities.TransactionReport;
import com.mustafazorbaz.entities.User;

/**
 * 
 * @author Mustafa
 *
 */
public interface MerchantTransactionServices {
	public User getUser(User user) ;
	public TransactionReport getTransactionReport(TransactionReport report, String authorization);
	public TransactionQuery  getTransactionQuery(TransactionQuery  query, String authorization);
	public Transaction   getTransaction (int  transactionId, String authorization);
	public TransactionReport getTransactionReportTest();
	public TransactionQuery getTransactionQueryTest();
	public Client getClient(Client client, String token);

}

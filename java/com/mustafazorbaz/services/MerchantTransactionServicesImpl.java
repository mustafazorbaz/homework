package com.mustafazorbaz.services;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mustafazorbaz.dao.MerchantTransactionDao;
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
@Service 
public class MerchantTransactionServicesImpl implements MerchantTransactionServices {
 
	@Autowired
	private MerchantTransactionDao merchantTransactionDao;  
 
	public User getUser(User user) {
		return merchantTransactionDao.getUser(user);
	}
	@Override
	public TransactionReport getTransactionReport(TransactionReport report, String authorization) {
		return merchantTransactionDao.getTransactionReport(report, authorization);	 
	}

	@Override
	public TransactionQuery getTransactionQuery(TransactionQuery query, String authorization) {
		return merchantTransactionDao.getTransactionQuery(query, authorization);
	}

	@Override
	public Transaction getTransaction(int transactionId, String authorization) {
		return merchantTransactionDao.getTransaction(transactionId, authorization);

	}
	@Override
	public TransactionReport getTransactionReportTest() {
		return merchantTransactionDao.getTransactionReportTest();	 

	}
	@Override
	public TransactionQuery getTransactionQueryTest() {		 
		return merchantTransactionDao.getTransactionQueryTest();
	}
	@Override
	public Client getClient(Client client, String token) {
		return merchantTransactionDao.getClient(client,token);
	}
 
 

 



	 
 
	 

}

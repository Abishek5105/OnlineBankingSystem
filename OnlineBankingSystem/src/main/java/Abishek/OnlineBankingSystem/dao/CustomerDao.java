/***
@author Abishek M

*/
package Abishek.OnlineBankingSystem.dao;

import Abishek.OnlineBankingSystem.entity.Customer;
import Abishek.OnlineBankingSystem.exception.CustomerException;

public interface CustomerDao {
	
		public Customer LoginCustomer(String CustomerUsername,String CustomerPassword,int CustomerAccountNumber) throws CustomerException;	
		
		public int ViewBalance(int CustomerAccountNumber) throws CustomerException;
		
		public int Deposite(int CustomerAccountNumber,int amount) throws CustomerException;
		
		public int Withdraw(int CustomerAccountNumber,int amount) throws CustomerException;
		
		public int Transfer(int CustomerAccountNumber,int amount,int CustomerAccountNumber2) throws CustomerException;

	}



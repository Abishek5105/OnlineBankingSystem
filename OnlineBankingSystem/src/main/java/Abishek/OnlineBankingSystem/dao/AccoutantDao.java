/***
@author Abishek M

*/
package Abishek.OnlineBankingSystem.dao;

import Abishek.OnlineBankingSystem.entity.Accoutant;
import Abishek.OnlineBankingSystem.entity.Customer;
import Abishek.OnlineBankingSystem.exception.AccoutantException;
import Abishek.OnlineBankingSystem.exception.CustomerException;

public interface AccoutantDao {
	
	public Accoutant LoginAccoutant(String accoutantUsername , String accoutantPassword) throws AccoutantException;

	public int addCustomer(String CustomerName,String CustomerMaol,String CustomerPassword,
			String CustomerMobile,String CustomerAddress)throws CustomerException;
	
	public String addAccount(int CustomerBalance,int cid)throws CustomerException;
	
	public String UpdateCustomer(int CustomerAccountNumber,String CustomerAddress) throws CustomerException;
	
	public String DeleteAccount(int CustomerAccountNumber )throws CustomerException;
	
	public Customer ViewCustomer(String CustomerAccountNumber)throws CustomerException;
	
	public Customer ViewAllCustomer()throws CustomerException;
}


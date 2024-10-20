/***
@author Abishek M
*/
package Abishek.OnlineBankingSystem.dao;

import java.sql.*;

import Abishek.OnlineBankingSystem.databaseconnection.DatabaseConnection;
import Abishek.OnlineBankingSystem.entity.Customer;
import Abishek.OnlineBankingSystem.exception.CustomerException;

public class CustomerDaoImplements implements CustomerDao{

	@Override
	public Customer LoginCustomer(String CustomerUsername, String CustomerPassword, int CustomerAccountNumber)
			throws CustomerException {
		Customer customer = null;
		try (Connection conn = DatabaseConnection.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from customerinformation i inner join account a on i.cid = a.cid where customerName = ? and customerPassword=? and customerAccountNumber=?");
			ps.setString(1, CustomerUsername);
			ps.setString(2, CustomerPassword);
			ps.setInt(3, CustomerAccountNumber);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int ac = rs.getInt("CustomerAccountNumber");
				String n = rs.getString("CustomerName");
				int b = rs.getInt("CustomerBalance");
				String e = rs.getString("CustomerName");
				String p = rs.getString("CustomerPassword");
				String m = rs.getString("CustomerMobile");
				String ad = rs.getString("CustomerAddress");
				
				customer = new Customer(ac,n,b,e,p,m,ad);
				
				
			}
			else
			{
				throw new CustomerException("Invalid name and password, try again !");
			}
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
			
		}
		return customer;
	}

	@Override
	public int ViewBalance(int CustomerAccountNumber) throws CustomerException {
		
		int b=-1;
		try(Connection conn = DatabaseConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select CustomerBalance from account where CustomerAccountNumber=?");
			
			ps.setInt(1, CustomerAccountNumber);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				b=rs.getInt("CustomerBalance");
			}
		}
		catch(SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		return b;
	}

	@Override
	public int Deposite(int CustomerAccountNumber, int amount) throws CustomerException {
		int b=-1;
		
		try(Connection conn = DatabaseConnection.provideConnection()){
				PreparedStatement ps = conn.prepareStatement("update account set CustomerBalance = CustomerBalance+ ? where CustomerAccountNumber =?");
				
				ps.setInt(1, amount);
				ps.setInt(2, CustomerAccountNumber);
				int rs = ps.executeUpdate();
				
				
		}
		catch(SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		return b;
	}

	@Override
	public int Withdraw(int CustomerAccountNumber, int amount) throws CustomerException {
		int vb = ViewBalance(CustomerAccountNumber);
		if(vb>amount)
		{
			try(Connection conn = DatabaseConnection.provideConnection()) {
				PreparedStatement ps = conn.prepareStatement("update account set customerBalance = customerBalance - ? where customerAccountNumber=?");
				ps.setInt(1, amount);
				ps.setInt(2, CustomerAccountNumber);
				int rs = ps.executeUpdate();
				
			}
			catch(SQLException e)
			{
				throw new CustomerException(e.getMessage());
				
			}
		}
		else
		{
			throw new CustomerException("Insufficient Balance");
		}
		return 0;
	}

	@Override
	public int Transfer(int CustomerAccountNumber, int amount, int CustomerAccountNumber2) throws CustomerException {
		int vb = ViewBalance(CustomerAccountNumber);
		if(vb>amount && checkAmount(CustomerAccountNumber2)) 
		{
			int with = Withdraw(CustomerAccountNumber, amount);
			int dep = Withdraw(CustomerAccountNumber2,amount);
		}
		else
		{
			throw new CustomerException("Insufficient Balance");
		}
		return 0;
	}
	
	private boolean checkAmount(int CustomerAccountNumber)
	{
		try(Connection conn = DatabaseConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from account where CustomerAccountNumber = ? ");
			ps.setInt(1, CustomerAccountNumber);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
       
}

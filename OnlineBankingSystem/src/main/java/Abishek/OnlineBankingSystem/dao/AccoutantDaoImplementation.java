/***
@author Abishek M 
*/
package Abishek.OnlineBankingSystem.dao;
import java.sql.*;

import Abishek.OnlineBankingSystem.databaseconnection.DatabaseConnection;
import Abishek.OnlineBankingSystem.entity.Accoutant;
import Abishek.OnlineBankingSystem.entity.Customer;
import Abishek.OnlineBankingSystem.exception.AccoutantException;
import Abishek.OnlineBankingSystem.exception.CustomerException;

public class AccoutantDaoImplementation implements AccoutantDao {

	@Override
	public Accoutant LoginAccoutant(String accoutantUsername, String accoutantPassword) throws AccoutantException {
		Accoutant acc = null;
		try(Connection conn = DatabaseConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from accoutant where accoutantUsername = ? and accoutantPassword =?");
			
			ps.setString(1, accoutantUsername);
			ps.setString(2, accoutantPassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String n = rs.getString("accoutantUsername");
				String e = rs.getString("accoutantEmail");
				String p =rs.getString("accoutantPassword");
				
				acc=new Accoutant(n,e,p);
			}
			
			
		} catch (SQLException e) {
			throw new AccoutantException("Invalid UserName and Password ");
		}
		return acc;
	}

	@Override
	public int addCustomer(String CustomerName, String CustomerMail, String CustomerPassword, String CustomerMobile,
			String CustomerAddress) throws CustomerException {
		
		
		int cid=-1;
		try (Connection conn=DatabaseConnection.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into customerinformation (CustomerName,CustomerMail,CustomerPassword,CustomerMobile,CustomerAddress) values(?,?,?,?,?)");
			
			ps.setString(1, CustomerName);
			ps.setString(2, CustomerMail);
			ps.setString(3, CustomerPassword);
			ps.setString(4, CustomerMobile);
			ps.setString(5, CustomerAddress);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				PreparedStatement ps2 =conn.prepareStatement("select cid from customerinformation where CustomerMail=? and CustomerMobile=?");
				ps2.setString(1, CustomerMail);
				ps2.setString(2, CustomerMobile);
				
				ResultSet rs=ps2.executeQuery();
				System.out.println("Customer Added Successfully");
				
				
				if(rs.next()) {
					cid=rs.getInt("cid");				}
			}
			else {
				System.out.println("Insreted Data is Incorrect Please Try Again!!!");
			}
		} 
		
		catch(SQLException e) {
			System.out.println("Sql Querry Related Error");
			
		}
		return cid;
	}

	@Override
	public String addAccount(int CustomerBalance, int cid) throws CustomerException {
		
		String message =null;
		try(Connection conn = DatabaseConnection.provideConnection()){
		
			PreparedStatement ps = conn.prepareStatement("insert into account(CustomerBalance,cid) values(?,?) ");
			
			ps.setInt(1, CustomerBalance);
			ps.setInt(2, cid);
			
			int x= ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Account Added Successfully");
			}
			else {
				System.out.println("Account Not Added");
			}
		}
		
		
		catch(SQLException e) {
			System.out.println("SQL Related Error");
		}
		return message;
	}

	@Override
	public String UpdateCustomer(int CustomerAccountNumber, String CustomerAddress) throws CustomerException {
		
		String message = null;
		
		try(Connection conn=DatabaseConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("update customerinformation i inner join account a on i.cid and a.CustomerAccountNumber = ? set i.CustomerAddress = ?");
			
		    ps.setInt(1, CustomerAccountNumber);
		    ps.setString(2, CustomerAddress);
		    
		    int x=ps.executeUpdate();
		    
		    if(x>0) {
		    	System.out.println("Adderss Updated Successfully...");
		    }
		    else {
		    	System.out.println("Customer detials is not Updated...");
		    	System.out.println("----------------------------------");
		    }
		}catch(SQLException e){
			e.printStackTrace();
			message=e.getMessage();
			
		}
		return null;
	}

	@Override
	public String DeleteAccount(int CustomerAccountNumber) throws CustomerException {
		
		String message = null;
		try(Connection conn = DatabaseConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("delete i from customerinformation i inner join account a on i.cid = a.cid where a.CustomerAccountNumber = ? ");
			ps.setInt(1, CustomerAccountNumber);
			
			int x= ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Account Deleted Successfully...");
			}
			else {
				System.out.println("Deletion Failed!!!");
				System.out.println("------------------");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			message=e.getMessage();
		}
		
		
		return message;
	}

	@Override
	public Customer ViewCustomer(String CustomerAccountNumber) throws CustomerException {
		
		Customer cu=null;
		try(Connection conn = DatabaseConnection.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from customerinformation i inner join account a on a.cid = i.cid where CustomerAccountNumber = ?");
		   ps.setString(1, CustomerAccountNumber);
		   
		   ResultSet rs = ps.executeQuery();
		   
		   if(rs.next()) {
			   int a = rs.getInt("CustomerAccountNumber");
			   String n= rs.getString("CustomerName");
			   int b = rs.getInt("CustomerBalance");
			   String e= rs.getString("CustomerMail");
			   String p= rs.getString("CustomerPassword");
			   String m= rs.getString("CustomerMobile");
			   String ad= rs.getString("CustomerAddress");
			   
			   cu = new Customer(a,n,b,e,p,m,ad);
		   }
		   else {
			   throw new CustomerException("Invalid Account Number!!!!");
		   }
		
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return cu;
	}

	@Override
	public Customer ViewAllCustomer() throws CustomerException {
		
		Customer cu = null;
		
		try(Connection conn = DatabaseConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from customerinformation i inner join account a on a.cid = i.cid");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 int a = rs.getInt("CustomerAccountNumber");
				   String n= rs.getString("CustomerName");
				   int b = rs.getInt("CustomerBalance");
				   String e= rs.getString("CustomerMail");
				   String p= rs.getString("CustomerPassword");
				   String m= rs.getString("CustomerMobile");
				   String ad= rs.getString("CustomerAddress");
				   
				   System.out.println("*************************");
				   System.out.println("Account Number : "+a);
				   System.out.println("Customer Name : "+n);
				   System.out.println("CustomerBalance : "+b);
				   System.out.println("CustomerPassword : "+p);
				   System.out.println("CustomerMail : "+e);
				   System.out.println("CustomerMobile : "+m);
				   System.out.println("CustomerAddress : "+ad);
				   
				   System.out.println("************************************");
				   
				   cu = new Customer(a,n,b,e,p,m,ad);
			}
		}
		catch(SQLException e) {
			throw new CustomerException("Invalid Account Number!!!!!!!!!");
			
		}
		return cu;
	}

}

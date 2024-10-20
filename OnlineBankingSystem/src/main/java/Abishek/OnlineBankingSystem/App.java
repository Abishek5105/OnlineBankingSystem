package Abishek.OnlineBankingSystem;
import java.util.*;


import Abishek.OnlineBankingSystem.dao.AccoutantDao;
import Abishek.OnlineBankingSystem.dao.AccoutantDaoImplementation;
import Abishek.OnlineBankingSystem.dao.CustomerDaoImplements;
import Abishek.OnlineBankingSystem.dao.CustomerDao;
import Abishek.OnlineBankingSystem.entity.Accoutant;
import Abishek.OnlineBankingSystem.entity.Customer;
import Abishek.OnlineBankingSystem.exception.AccoutantException;
import Abishek.OnlineBankingSystem.exception.CustomerException;
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        
        boolean f =true;
        
        while(f) {
        	System.out.println("-----WELCOME TO ONLINE BANKING SYSTEM-----");
        	System.out.println("------------------------------------------");
        	System.out.println("1.ADMIN LOGIN PORTAL\r\n"
        	                  +"2.Customer");
        	
        	
        	System.out.println("Choose your Option ");
        	int choice = sc.nextInt();
        	
            switch(choice) {
            case 1:
            	System.out.println("Admin Login Credntials---------------Accoutant");
            	System.out.println("Enter Usrename: ");
            	String username = sc.next();
            	System.out.println("Enter Password: ");
            	String pass = sc.next();
            	
            	
            	AccoutantDao ad = new AccoutantDaoImplementation();
            	
            	try {
            		Accoutant a =ad.LoginAccoutant(username, pass);
            		if(a == null) {
            			System.out.println("Wrong Credential");
            			break;
            		}
            		System.out.println("Login Successfully!!!");
            		System.out.println("WELCOME "+a.getAccoutantUsername());
            		
            		boolean y=true;
            		while(y) {
            			System.out.println("------------------\r\n"
            					+"1.Add New Customer Account\r\n"
            					+"2.Update Customer Adderss\r\n"
            					+"3.Delete Account\r\n"
            					+"4.View Customer Account Detials\r\n"
            					+"5.View All Customer Detials\r\n"
            					+"6.Account Logout\r\n"
            					);
            			
            			int x=sc.nextInt();
            			
            			if(x==1) {
            				System.out.println("-----New Account-----");
            				System.out.println("Enter CustomerName : ");
            				String a1 =sc.next();
            				System.out.println("Enter Account Opening Balance");
            				int a2 = sc.nextInt();
            				System.out.println("Enter CustomerMail : ");
            				String a3 =sc.next(); 
            				System.out.println("Enter CustomerPassword : ");
            				String a4 =sc.next(); 
            				System.out.println("Enter CustomerMobile : ");
            				String a5 =sc.next(); 
            				System.out.println("Enter CustomerAddress : ");
            				String a6 =sc.next(); 
         
            				int s1=-1;
            				try {
            					s1=ad.addCustomer(a1, a3, a4, a5, a6);
            					
            					try {
            						ad.addAccount(a2, s1);
            					}
            					catch(CustomerException e) {
            						e.printStackTrace();
            					}
            					
            				}
            				catch(CustomerException e) {
            					System.out.println(e.getMessage());
            				}
            				System.out.println("-------------------");
            			}
            			
            			if(x==2) {
            				System.out.println("Update Customer Address.....");
            				System.out.println("Enter Customer Account Nukmber..");
            				int u=sc.nextInt();
            				System.out.println("Enter new Address...");
            				String u2=sc.next();
            				
            				try {
            					String mes =ad.UpdateCustomer(u, u2);
            				}
            				catch(CustomerException e) {
            					e.printStackTrace();
            				}
            			}
            		 if(x==3) {
            			 System.out.println("-----Remove Account-----");
            			 System.out.println("Enter Account Number : ");
            			 int ac=sc.nextInt();
            			 String s = null;
            			 try {
            				 s=ad.DeleteAccount(ac);
            			 }
            			 catch(CustomerException e) {
            				 e.printStackTrace();
            			 }
            			 if(s!=null) {
            				 System.out.println(s);
            			 }
            		 }
            		 
            		 if(x==4) {
            			 System.out.println("--------Customer Details--------");
            			 System.out.println("Enter Customer Account Number: ");
            			 String ac = sc.next();
            			 
            			 
            			 try {
            				 Customer cus = ad.ViewCustomer(ac);
            				 
            				 
            				 if(cus!=null) {
            					 System.out.println("*****************");
            					 System.out.println("Account Number :"+cus.getCustomeAccountNumber());
            					 System.out.println("Name :"+cus.getCustomerName());
            					 System.out.println("Balance :"+cus.getCustomerBalance());
            					 System.out.println("Emai :"+cus.getCustomerMail());
            					 System.out.println("Password"+cus.getCustomerPassword());
            					 System.out.println("Mobile Number :"+cus.getCustomerMobile());
            					 System.out.println("Address :"+cus.getCustomerAddress());
            					 System.out.println("-----------------------------------");
            				 }
            				 else {
            					 System.out.println("Account Does Not Exist ... ");
            					 System.out.println("---------------------------");
            				 }
            			 }
            			 catch(CustomerException e) {
            				 e.printStackTrace();
            			 }
            		 }
            		 
            		 
            		 if(x==5) {
            			 try {
            				 System.out.println("------ALL Customer List---------");
            				 
            				 Customer cus = ad.ViewAllCustomer();
            			 }
            			 catch(CustomerException e) {
            				 e.printStackTrace();
            			 }
            		 }
            		 
            		 if(x==6) {
            			 System.out.println("-----------Account Logged out Successfully---------");
            			 y=false;
            		 }
            		 
            		 
            		}
            		break;
            	}
            	catch(AccoutantException e){
            		System.out.println(e.getMessage());
            	}
            	
            	break;
            	
            case 2:
				System.out.println("...............CUSTOMER LOGIN................ ");
				System.out.println("...........................................");
				System.out.print("Enter username : ");
				String customerUserName = sc.next();
				System.out.print("Enter password : ");
				String customerPassword = sc.next();
				System.out.print("Enter account number : ");
				int accountNumber = sc.nextInt();
				
				CustomerDao cd = new CustomerDaoImplements();
				try {
					Customer cus = cd.LoginCustomer(customerUserName, customerPassword, accountNumber);
					System.out.println("Welcome : "+cus.getCustomerName());
					
					boolean m = true;
					
					while(m) {
						System.out.println("--------------------------------\r\n"
								+"1.View Balance\r\n"
								+"2.Deposite Money\r\n"
								+"3.Withdraw Money\r\n"
								+"4.Transfer Money\r\n"
								+"5.Logout\r\n"
								);
						
						
						int x = sc.nextInt();
						
						if(x==1) {
							System.out.println("----------Balance------------");
							System.out.println("Current Account Balance-----");
							System.out.println(cd.ViewBalance(accountNumber));
							System.out.println("-----------------------------");
						}
						if(x==2) {
							System.out.println("---------DEPOSITE-----------");
							System.out.println("Enter Amount to Deposite.....");
							int am = sc.nextInt();
							cd.Deposite(accountNumber, am);
							System.out.println("Your Balance After Dapasite");
							
							System.out.println(cd.ViewBalance(accountNumber));
							System.out.println("---------------------------");
						}
						if(x==3)
						{
							System.out.println("...............Withdraw.................");
							System.out.print("Enter the amount : ");
							int am = sc.nextInt();
							try
							{
								cd.Withdraw(accountNumber, am);
								System.out.println("Balance after withdraw : "+cd.ViewBalance(accountNumber));
								System.out.println("...................................");
							}
							catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
						}
						if(x==4)
						{
							System.out.println("....................Money Transfer....................");
							System.out.print("Enter amount to transfer : ");
							int amt = sc.nextInt();
							System.out.print("Enter account number to transfer : ");
							int ac = sc.nextInt();
							
							try {
								cd.Transfer(accountNumber, amt, ac);
								System.out.println("Amount transfered successfully");
								System.out.println("..............................");
							} catch (Exception e) {
								System.out.println(e.getMessage());
								
							}
						}
						if(x==5)
						{
							System.out.println("Customer Logout successfull !");
							System.out.println("Thank you for choosing online banking services");
							m = false;
						}
					}
					break;
					
				} catch (CustomerException e) {
					System.out.println(e.getMessage());
				}
			}
        }
    }
}

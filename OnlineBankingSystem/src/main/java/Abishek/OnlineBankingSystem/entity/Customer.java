/***
@author Abishek M
*/
package Abishek.OnlineBankingSystem.entity;

public class Customer {
        private int CustomerAccountNumber;
        private String CustomerName;
        private int CustomerBalance;
        private String CustomerPassword;
        private String CustomerMail;
        private String CustomerMobile;
        private String CustomerAddress;
		
        
        
        @Override
		public String toString() {
			return "Customer [CustomeAccountNumber=" + CustomerAccountNumber + ", CustomerName=" + CustomerName
					+ ", CustomerBalance=" + CustomerBalance + ", CustomerPassword=" + CustomerPassword
					+ ", CustomerMail=" + CustomerMail + ", CustomerMobile=" + CustomerMobile + ", CustomerAddress="
					+ CustomerAddress + "]";
		}



		public int getCustomeAccountNumber() {
			return CustomerAccountNumber;
		}



		public void setCustomeAccountNumber(int customeAccountNumber) {
			CustomerAccountNumber = customeAccountNumber;
		}



		public String getCustomerName() {
			return CustomerName;
		}



		public void setCustomerName(String customerName) {
			CustomerName = customerName;
		}



		public int getCustomerBalance() {
			return CustomerBalance;
		}



		public void setCustomerBalance(int customerBalance) {
			CustomerBalance = customerBalance;
		}



		public String getCustomerPassword() {
			return CustomerPassword;
		}



		public void setCustomerPassword(String customerPassword) {
			CustomerPassword = customerPassword;
		}



		public String getCustomerMail() {
			return CustomerMail;
		}



		public void setCustomerMail(String customerMail) {
			CustomerMail = customerMail;
		}



		public String getCustomerMobile() {
			return CustomerMobile;
		}



		public void setCustomerMobile(String customerMobile) {
			CustomerMobile = customerMobile;
		}



		public String getCustomerAddress() {
			return CustomerAddress;
		}



		public void setCustomerAddress(String customerAddress) {
			CustomerAddress = customerAddress;
		}



		public Customer() {
			super();
		}



		public Customer(int customeAccountNumber, String customerName, int customerBalance, String customerPassword,
				String customerMail, String customerMobile, String customerAddress) {
			super();
			CustomerAccountNumber = customeAccountNumber;
			CustomerName = customerName;
			CustomerBalance = customerBalance;
			CustomerPassword = customerPassword;
			CustomerMail = customerMail;
			CustomerMobile = customerMobile;
			CustomerAddress = customerAddress;
		}
        
        
}

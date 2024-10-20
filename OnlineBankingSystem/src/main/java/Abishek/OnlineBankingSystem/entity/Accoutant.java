/***
@author Abishek M
*/
package Abishek.OnlineBankingSystem.entity;

public class Accoutant {
	private String accoutantUsername;
	private String accoutantEmail;
	private String accoutantPassword;
	public Accoutant(String accoutantUsername, String accoutantEmail, String accoutantPassword) {
		super();
		this.accoutantUsername = accoutantUsername;
		this.accoutantEmail = accoutantEmail;
		this.accoutantPassword = accoutantPassword;
	}
	public Accoutant() {
		super();
	}
	public String getAccoutantUsername() {
		return accoutantUsername;
	}
	public void setAccoutantUsername(String accoutantUsername) {
		this.accoutantUsername = accoutantUsername;
	}
	public String getAccoutantEmail() {
		return accoutantEmail;
	}
	public void setAccoutantEmail(String accoutantEmail) {
		this.accoutantEmail = accoutantEmail;
	}
	public String getAccoutantPassword() {
		return accoutantPassword;
	}
	public void setAccoutantPassword(String accoutantPassword) {
		this.accoutantPassword = accoutantPassword;
	}
	@Override
	public String toString() {
		return "Accoutant [accoutantUsername=" + accoutantUsername + ", accoutantEmail=" + accoutantEmail
				+ ", accoutantPassword=" + accoutantPassword + "]";
	}
	
	
	
	
	
	

}

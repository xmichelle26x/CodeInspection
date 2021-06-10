package labcodeinspection;
 
import java.util.Locale;

import org.apache.log4j.Logger; 

/**
 * 
 * @author AdminUser
 *
 */
public class Email {
	  
	/**
	 * myLogger
	 */
    final static Logger LOGGER = Logger.getLogger(Email.class);


	/**
	 * mFirstName
	 */
	private final String mFirstName;
	/**
	 * mLastName
	 */
	private final String mLastName;
	/**
	 * password
	 */
	private transient String password;
	/**
	 * department
	 */
	private String department;
	/**
	 * passwordLength
	 */
	private static final int LENPASS = 8;
	/**
	 * emailUser
	 */
	private String emailUser;

	/**
	 * emailUser
	 * @param firstName
	 * @param lastName
	 */
	public Email(final String firstName, final String lastName) {
		
		this.mFirstName = firstName;
		this.mLastName = lastName;
	}

	/**
	 * ShowInfo
	 */
	public void showInfo() {
		if(LOGGER.isInfoEnabled()){
			LOGGER.info("\nFIRST NAME= " + mFirstName + "\nLAST NAME= " + mLastName);
			LOGGER.info("DEPARMENT= " + department + "\nEMAIL= " + emailUser + "\nPASSWORD= " + password);
		}		
	}

	/**
	 * ShowInfo
	 * @param depChoice longitud
	 */
	public void setDeparment(final int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			break;
		}
	}
	/**
	 * randomPassword
	 * @param length longitud
	 */
	private String randomPassword(final int length) {
		final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			final int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}
	 
	/**
	 * generateEmail 
	 */
	public void generateEmail() {
		this.password = this.randomPassword(Email.LENPASS);
		
		this.emailUser = this.mFirstName.toLowerCase(Locale.US) + this.mLastName.toLowerCase(Locale.US) + "@" + this.department
				+ ".espol.edu.ec";
	}
}

package labcodeinspection;
 
import java.util.Scanner;

import org.apache.log4j.Logger;
 
/**
 * 
 * @author AdminUser
 *
 */
public final class EmailApp {
	 
	/**
	 * logger
	 */
	final private static Logger LOGGER = Logger.getLogger(EmailApp.class);
	
	/**
	 * main
	 * @param args
	 */
	public static void main(final String[] args) {
		  
		final Scanner scanner = new Scanner(System.in); 
		final String firstName = scanner.nextLine();
		final String lastName = scanner.nextLine();
		final int depChoice = scanner.nextInt(); 
		scanner.close();
		if(LOGGER.isInfoEnabled()) { 
			LOGGER.info("Enter your first name: ");
		}
		 
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("Enter your last name: ");
		} 
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("\nDEPARTMENT CODE\n1. for sales\n2. for Development\n3. for accounting\nEnter code: ");
		} 

		final Email email = new Email(firstName, lastName);
		email.setDeparment(depChoice);
		email.generateEmail();
		email.showInfo();
	}
}

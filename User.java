import javax.swing.JOptionPane;

public class User {

	// All global variables
    float balance;
	char previousAction;
	String customerName;
    float previousActionAmount;
	Double randomNumber = Math.floor(Math.random()*(99999999+1)+0);
    int customerId = randomNumber.intValue();

	// Class constructor
    public User (String customersName) {
        customerName = customersName;
    }

	// Deposite method
    void deposit() {
		// Asking user for input then converting that input from string to float
		String stringAmount = JOptionPane.showInputDialog(null, "Enter an amount to deposit:");
		float amount = Float.parseFloat(stringAmount);
		
		// If the user's inputted amount is not zero, perform the following
		if (amount != 0) {
			// Add amount to balance, set previousAction to "d" which stands for deposit, 
			// and set previousActionAmount to the user's inputted amount
			balance += amount;
			previousAction = 'd';
			previousActionAmount = amount;

			// Show the user a success message
			JOptionPane.showMessageDialog(null, "Deposited $" + amount + " to your bank account!");
		}
    }

	// Withdraw method
    void withdraw() {
		// Asking user for input then converting that input from string to float
		String stringAmount = JOptionPane.showInputDialog(null, "Enter an amount to withdraw:");
		float amount = Float.parseFloat(stringAmount);

		// If the user's inputted amount is not zero, perform the following
        if (amount != 0) {
			// remove amount from balance, set previousAction to "w" which stands for withdraw, 
			// and set previousActionAmount to the user's inputted amount
			balance -= amount;
			previousAction = 'w';
			previousActionAmount = amount;

			// Show the user a success message
			JOptionPane.showMessageDialog(null, "Withdrew $" + amount + " from your bank account!");
        }
    }

	// Previous transaction method
    void getPreviousTransaction() {
		switch(previousAction) {
			case 'd':
				// If the previousAction is deposit, show the user the amount and the action
				JOptionPane.showMessageDialog(null, "Deposited $" + previousActionAmount);
				break;
			case 'w':
			// If the previousAction is withdraw, show the user the amount and the action
				JOptionPane.showMessageDialog(null, "Withdrew $" + previousActionAmount);
				break;
			default:
				// If there is no previous activity, show the user an error message
				JOptionPane.showMessageDialog(null, "No previous transaction occured.");
				break;
		}
    }

	// Main method which calls all of our functions
    void showMenu() {
		char option = '\0';

		do {
			// A very long showInputDialog call
			char option1 = JOptionPane.showInputDialog(null, "Welcome, " + customerName + "(" + customerId + ")" + "!" + "\n\n" + "What would you like to do?" + "\n" + "A. Check your balance" + "\n" + "B. Make a deposit" + "\n" + "C. Make a withdrawal" + "\n" + "D. View previous transaction" + "\n" + "E. Exit" + "\n\n" + "Enter an option:").charAt(0);
			
			// Making the user's selection uppercase to allow the user to type an option of any capitalization
			option = Character.toUpperCase(option1);
			
			switch(option) {
			case 'A':
				// If the user wants to see their balance, do this
				JOptionPane.showMessageDialog(null, "Balance = $" + balance);
				break;
			case 'B':
				// If the users want to deposit a certain amount, call the deposit function
				deposit();
				break;
			case 'C':
			// If the users want to withdraw a certain amount, call the withdraw function
				withdraw();
				break;
			case 'D':
				// If the user wants to see their previous action, call the getPreviousTransaction function
				getPreviousTransaction();
				break;
			case 'E':
				break;
			default:
				// If the user is stupid and enters an invalid option, display an error
				JOptionPane.showMessageDialog(null, "Error: invalid option. Please enter only enter A, B, C, D, or E!");
				break;
			}
		} while (option != 'E');

		// When the user exits the application, display a message
		JOptionPane.showMessageDialog(null, "Thank you for banking with us!");
	}
}
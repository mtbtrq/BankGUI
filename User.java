import javax.swing.JOptionPane;

public class User {
    float balance;
	char previousAction;
	String customerName;
    float previousActionAmount;
	Double randomNumber = Math.floor(Math.random()*(99999999+1)+0);
    int customerId = randomNumber.intValue();

    public User (String customersName) {
        customerName = customersName;
    }

    void deposit() {
		String stringAmount = JOptionPane.showInputDialog(null, "Enter an amount to deposit:");
		float amount = Float.parseFloat(stringAmount);
		
		if (amount != 0) {
			balance += amount;
			previousAction = 'd';
			previousActionAmount = amount;

			JOptionPane.showMessageDialog(null, "Deposited $" + amount + " to your bank account!");
		}
    }

    void withdraw() {
		String stringAmount = JOptionPane.showInputDialog(null, "Enter an amount to withdraw:");
		float amount = Float.parseFloat(stringAmount);

        if (amount != 0) {
			previousAction = 'w';
			previousActionAmount = amount;
			balance -= amount;

			JOptionPane.showMessageDialog(null, "Withdrew $" + amount + " from your bank account!");
        }
    }

    void getPreviousTransaction() {
        if (previousAction == 'd') {
			JOptionPane.showMessageDialog(null, "Deposited $" + previousActionAmount);
        } else if (previousAction == 'w') {
			JOptionPane.showMessageDialog(null, "Withdrew $" + previousActionAmount);
        } else {
			JOptionPane.showMessageDialog(null, "No previous transaction occured.");
        }
    }

    void showMenu() {
		char option = '\0';

		do {
			char option1 = JOptionPane.showInputDialog(null, "Welcome, " + customerName + "(" + customerId + ")" + "!" + "\n\n" + "What would you like to do?" + "\n" + "A. Check your balance" + "\n" + "B. Make a deposit" + "\n" + "C. Make a withdrawal" + "\n" + "D. View previous transaction" + "\n" + "E. Exit" + "\n\n" + "Enter an option:").charAt(0);
			option = Character.toUpperCase(option1);
			
			switch(option) {
			case 'A':
				JOptionPane.showMessageDialog(null, "Balance = $" + balance);
				break;
			case 'B':
				deposit();
				break;
			case 'C':
				withdraw();
				break;
			case 'D':
				getPreviousTransaction();
				break;
			case 'E':
				break;
			default:
				JOptionPane.showMessageDialog(null, "Error: invalid option. Please enter only enter A, B, C, D, or E!");
				break;
			}
		} while (option != 'E');

		JOptionPane.showMessageDialog(null, "Thank you for banking with us!");
	}
}
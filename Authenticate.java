import javax.swing.JOptionPane;
import java.util.Objects;

public class Authenticate {

    // Class constructor
    public Authenticate (String userName, String pw) {

        // All the global variables
        int tryCount = 0;
        String title = "Bank";
        int maxTryLimit = 10;
        String usersPassword = null;
        boolean isWrongPassword = false;

        // While the user's inputted password (in the GUI) is not equal to the correct password, do this
        while (!Objects.equals(usersPassword, pw)) {
            // If the user has entered the not entered a password incorrectly, do this
            if (!isWrongPassword) {
                usersPassword = JOptionPane.showInputDialog(null, "Please enter your password:", title, JOptionPane.INFORMATION_MESSAGE);
                if (!Objects.equals(usersPassword, pw)) {
                    // If the user does'nt enter the correct password on the first attempt, make isWrongPassword true
                    isWrongPassword = true;
                }
            } else {
                if (tryCount == maxTryLimit) {
                    // If the user has had too many tries, do this
                    JOptionPane.showMessageDialog(null, "You've had too many incorrect tries!", title, JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else {
                    // If the user is still in limit of the max tries he can perform, do this
                    tryCount += 1;
                    usersPassword = JOptionPane.showInputDialog(null, "Incorrect password entered!\n\nTries remaining: " + (maxTryLimit - tryCount) + "\n\nPlease enter your password:", title, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        // Once the user enters the correct password, perform the following        
        User user = new User(userName);
        user.showMenu();
    }
}
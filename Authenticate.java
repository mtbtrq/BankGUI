import javax.swing.JOptionPane;
import java.util.Objects;

public class Authenticate {

    public Authenticate (String userName, String pw) {

        int tryCount = 0;
        int maxTryLimit = 10;
        String usersPassword = null;
        boolean isWrongPassword = false;

        while (!Objects.equals(usersPassword, pw)) {
            if (!isWrongPassword) {
                usersPassword = JOptionPane.showInputDialog(null, "Please enter your password:");
                if (!Objects.equals(usersPassword, pw)) {
                    isWrongPassword = true;
                }
            } else {
                if (tryCount == maxTryLimit) {
                    JOptionPane.showMessageDialog(null, "You've had too many incorrect tries!");
                    System.exit(0);
                } else {
                    tryCount += 1;
                    usersPassword = JOptionPane.showInputDialog(null, "Incorrect password entered!\n\nTries remaining: " + (maxTryLimit - tryCount) + "\n\nPlease enter your password:");
                }
            }
        }
        
        User user = new User(userName);
        user.showMenu();
    }
}
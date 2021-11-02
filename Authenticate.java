import javax.swing.JOptionPane;
import java.util.Objects;

public class Authenticate {

    public Authenticate (String userName, String pw) {

        String usersPassword = null;
        boolean isWrongPassword = false;
        
        while (!Objects.equals(usersPassword, pw)) {
            if (!isWrongPassword) {
                usersPassword = JOptionPane.showInputDialog(null, "Please enter your password:");
                if (!Objects.equals(usersPassword, pw)) {
                    isWrongPassword = true;
                }
            } else {
                usersPassword = JOptionPane.showInputDialog(null, "Incorrect password entered!\n\nPlease enter your password:");
            }
        }

        User user = new User(userName);
        user.showMenu();
    }
}
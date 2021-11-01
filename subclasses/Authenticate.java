package subclasses;
import javax.swing.JOptionPane;
import java.util.Objects;

public class Authenticate {

    public Authenticate (String userName, String pw) {

        String usersPassword = JOptionPane.showInputDialog(null, "Please enter your password:");

        if (Objects.equals(usersPassword, pw)) {
            User user = new User(userName);
            user.showMenu();
        }
    }
}

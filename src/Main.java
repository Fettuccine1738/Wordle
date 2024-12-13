import  Wordle.ui.UserInterface;
import java.time.LocalDateTime;
public class Main {


    public static void main(String[] args) {

        System.out.println("HELLO !!!");
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Current Date and Time " + date);

        UserInterface myInterface = new UserInterface();

    }
}
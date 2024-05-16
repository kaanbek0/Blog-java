import java.io.IOException;
import java.util.Scanner;

public class deneme
{
    public static void main(String[] args) throws IOException
    {
        UserManager UM = new UserManager();
        Scanner in = new Scanner(System.in);

        System.out.println("What is your motion: ");
        String motion = in.next();

        if(motion.equals("login"))
        {
            System.out.println("Enter your credentials:");
            String name = in.next();
            String password = in.next();
            if(UM.login(name, password))
            {
                System.out.println("Login sucsesfull");
            }
        }

        if(motion.equals("sign in"))
        {
            System.out.println("Enter the new users credentials:");
            String name = in.next();
            String password = in.next();
            UM.SignIn(name, password);
            System.out.println("Sign in sucsessful");
        }
        in.close();
        System.out.println(UM.login("kaan","197298"));

    }
}
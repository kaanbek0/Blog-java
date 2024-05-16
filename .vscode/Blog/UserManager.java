/* To Do:
 * Linear Search(impoerted or writen)      (not useful, loop is good enough)
 * login                                   (done)
 * forgot password                         (not needed rn)
 * Entegration of Map
 * 
 */
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class UserManager {
    
    private Map map = new Map();

    public UserManager() throws FileNotFoundException, IOException
    {
        FileReader fReader = new FileReader("users.txt");        
        Scanner in = new Scanner(fReader);
        while(in.hasNext())
        {
            String[] inter = in.next().split(",");
            map.addUser(inter[0],inter[1]);
        }
        in.close();
    }

    
    public void SignIn(String name, String password) throws FileNotFoundException, IOException
    {
        PrintWriter outWriter = new PrintWriter("users.txt");
        map.addUser(name,password);
        String[] Unames = map.UserNames();
        for(int i=0; i<Unames.length;i++)
        {
            outWriter.println(Unames[i] + ","+ map.getPassword(Unames[i]));
        }
        outWriter.close();


    }

    public boolean login(String name, String password)
    {
        if(map.getPassword(name).equals(password))
        {
            return true;
        }
        return false;
    }
}















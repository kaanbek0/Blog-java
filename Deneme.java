import java.util.Scanner;
public class Deneme
{
  public class Inner
  {
    private int balance;

    public Inner(int a)
    {
      balance = a;
    }

    public int Balance()
    {
      return balance;
    }

    public void Deposit(int a)
    {
      balance += a;
    }

  }
  public static void main(String[] args)
  {
    
    Scanner in = new Scanner(System.in);
    int first = in.nextInt();
    Inner acc = new Inner(first);
    int second = in.nextInt();
    acc.Deposit(second);

    System.out.println(acc.Balance());
    in.close();
  }
}


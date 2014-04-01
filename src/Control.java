import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by AaronJordan on 3/31/14.
 */
public class Control extends Thread
{

    public static Semaphore customers = new Semaphore(0);
    public static Semaphore barber = new Semaphore(0);
    public static Semaphore accessSeats = new Semaphore(1);

    private static int chairs;
    public static int numberOfFreeSeats;

    public static int getChairs()
    {
        return chairs;
    }

    public static void setChairs(int inputChairs)
    {
        chairs = inputChairs;
    }

    public static void main(String[] args)
    {
        Scanner inputChairs = new Scanner(System.in);
        System.out.print("How many chairs are in the barber shop: ");
        int numberOfChairs = Integer.parseInt(inputChairs.next());
        setChairs(numberOfChairs);
        numberOfFreeSeats = getChairs();

        Control barberShop = new Control();
        barberShop.start();
    }

    public void run()
    {
        Barber aaron = new Barber();
        aaron.start();

        for (int i = 1; i < 4; i++)
        {
            Customer aCustomer = new Customer(i);
            aCustomer.start();

            try
            {
                sleep(2000);
            }
            catch (InterruptedException ex) {}
        }
    }
}

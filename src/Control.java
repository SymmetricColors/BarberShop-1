import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Aaron Jordan
 * Computer Operating Systems
 * 3/31/2014
 */

public class Control extends Thread
{

    public static Semaphore customers = new Semaphore(0);
    public static Semaphore barber = new Semaphore(0);
    public static Semaphore accessSeats = new Semaphore(1);

    private static int chairs;
    private static int numberOfCustomers;
    public static int numberOfFreeSeats;
    public static int customerCounter;

    public static int getChairs()
    {
        return chairs;
    }

    public static void setChairs(int inputChairs)
    {
        chairs = inputChairs;
    }

    public static int getNumberOfCustomers()
    {
        return numberOfCustomers;
    }

    public static void setNumberOfCustomers(int inputCustomers)
    {
        numberOfCustomers = inputCustomers;
    }

    public static void main(String[] args)
    {
        Scanner inputChairs = new Scanner(System.in);
        Scanner inputCustomers = new Scanner(System.in);
        System.out.print("How many chairs are in the barber shop: ");
        int localNumberOfChairs = Integer.parseInt(inputChairs.next());
        System.out.print("How many customers are getting their haircut today: ");
        int localNumberOfCustomers = Integer.parseInt(inputCustomers.next());
        setChairs(localNumberOfChairs);
        setNumberOfCustomers(localNumberOfCustomers);
        numberOfFreeSeats = getChairs();
        numberOfCustomers = getNumberOfCustomers();
        customerCounter = getNumberOfCustomers();

        Control barberShop = new Control();
        barberShop.start();
    }

    public void run()
    {
        Barber aaron = new Barber();
        aaron.start();

        for (int i = 1; i <= getNumberOfCustomers(); i++)
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

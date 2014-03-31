/**
 * Created by AaronJordan on 3/31/14.
 */

public class Customer extends Thread
{
    int iD;
    boolean notCut = true;

    public Customer(int i)
    {
        iD = i;
    }

    public void run()
    {
        while (notCut)
        {
            try
            {
                SleepingBarber.accessSeats.acquire();

                if (SleepingBarber.numberOfFreeSeats > 0)
                {
                    System.out.println("Customer " + this.iD + " just sat down.");
                    SleepingBarber.numberOfFreeSeats--;
                    SleepingBarber.customers.release();
                    SleepingBarber.accessSeats.release();

                    try
                    {
                        SleepingBarber.barber.acquire();
                        notCut = false;
                        this.get_haircut();
                    }
                    catch (InterruptedException ex) {}
                }
                else
                {
                    System.out.println("There are no free seats. Customer " + this.iD + " has left the barbershop.");
                    SleepingBarber.accessSeats.release();
                    notCut = false;
                }
            }
            catch (InterruptedException ex) {}
        }
    }

    public void get_haircut()
    {
        System.out.println("Customer " + this.iD + " is getting his hair cut");
        try
        {
            sleep(5000);
        }
        catch (InterruptedException ex) {}
    }
}

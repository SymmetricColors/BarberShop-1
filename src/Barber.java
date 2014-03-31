/**
 * Created by AaronJordan on 3/31/14.
 */

import java.util.concurrent.*;

public class Barber extends Thread
{
    public Barber() {}

    public void run()
    {
        while (true)
        {
            try
            {
                SleepingBarber.customers.acquire();
                SleepingBarber.accessSeats.release();
                SleepingBarber.numberOfFreeSeats++;
                SleepingBarber.barber.release();
                SleepingBarber.accessSeats.release();
                this.cutHair();
            }
            catch (InterruptedException ex) {}
        }
    }

    public void cutHair()
    {
        System.out.println("The barber is cutting hair");
        try
        {
            sleep(5000);
        }
        catch (InterruptedException ex) {}
    }
}

/**
 * Created by AaronJordan on 3/31/14.
 */

public class Barber extends Thread
{
    public Barber() {}

    public void run()
    {
        while (Control.customerCounter > 0)
        {
            try
            {
                Control.customerCounter--;
                Control.customers.acquire();
                Control.accessSeats.release();
                Control.numberOfFreeSeats++;
                Control.barber.release();
                Control.accessSeats.release();
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

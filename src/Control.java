/**
 * Created by AaronJordan on 3/31/14.
 */
public class Control extends Thread
{
    public static void main(String[] args)
    {
        Control barberShop = new Control();
        barberShop.start();
    }

    public void run()
    {
        Barber aaron = new Barber();
        aaron.start();

        for (int i = 1; i < 16; i++)
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

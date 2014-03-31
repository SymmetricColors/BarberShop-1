import java.util.concurrent.*;

/**
 * Created by AaronJordan on 3/31/14.
 */
public class SleepingBarber extends Thread
{
    public static Semaphore customers = new Semaphore(0);
    public static Semaphore barber = new Semaphore(0);
    public static Semaphore accessSeats = new Semaphore(1);

    public static final int CHAIRS = 5;
    public static int numberOfFreeSeats = CHAIRS;
}

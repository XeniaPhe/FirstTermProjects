
import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable
{

    public boolean status;
    public Calendar programTime;
    public boolean programAction;

    public SmartPlug(String alias, String macId)
    {
        this.alias = alias;
        this.macId = macId;
    }

    public void turnOn()
    {
        if (!connectionStatus)
        {
            return;
        }
        if (status)
        {
            System.out.println("Smart Plug - " + alias + " has been already turned on");
        }
        else
        {
            status = true;
            System.out.println("SmartPlug - " + alias + " is turned on now (Current time: " + Helper.GetCurrentTime() + " )");
        }
    }

    public void turnOff()
    {
        if (!connectionStatus)
        {
            return;
        }
        if (status)
        {
            status = false;
            System.out.println("Smart Plug - " + alias + "is turned off now (Current time: " + Helper.GetCurrentTime() + " )");
        }
        else
        {
            System.out.println("Smart Plug - " + alias + " has been already turned off");
        }
    }

    @Override
    public void setTimer(int seconds)
    {

        if (!connectionStatus)
        {
            return;
        }

        programTime.setTimeInMillis(System.currentTimeMillis());
        programTime.add(Calendar.SECOND, seconds);
        System.out.println("Smart Plug - " + alias + " will be turned "
                + (status ? "off " : "on ") + seconds + " seconds later! (Current time: " + Helper.GetCurrentTime() + " )");

    }

    @Override
    public void cancelTimer()
    {
        if (!connectionStatus)
        {
            return;
        }
        programTime = null;

    }

    @Override
    public void runProgram()
    {
        if (!connectionStatus)
        {
            return;
        }
        if (programTime.getTime() != Calendar.getInstance().getTime())
        {
            return;
        }

        if (programAction)
        {
            turnOn();
        }
        else
        {
            turnOff();
        }

        programTime = null;

    }

    @Override
    public boolean testObject()
    {
        if (!connectionStatus)
        {
            return false;
        }

        SmartObjectToString();
        turnOn();
        turnOff();
        return true;
    }

    @Override
    public boolean shutDownObject()
    {
        if (!connectionStatus)
        {
            return false;
        }

        SmartObjectToString();
        if (status)
        {
            turnOn();
        }

        return true;
    }

}

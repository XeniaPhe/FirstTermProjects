
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl, Programmable
{

    public boolean hasLightTurned;
    public Calendar programTime;
    public boolean programAction;

    public SmartLight(String alias, String macId)
    {
        this.alias = alias;
        this.macId = macId;
    }

    public void turnOnLight()
    {
        if (!hasLightTurned)
        {
            hasLightTurned = true;
            System.out.println("Smart Light - " + alias + " is turned on now (Current time: "
                    + Helper.GetCurrentTime() + " )");
        }
        else
        {
            System.out.println("Smart Light - " + alias + " has been already turned on");
        }

    }

    public void turnOffLight()
    {
        if (hasLightTurned)
        {
            hasLightTurned = false;
            System.out.println("Smart Light - " + alias + " is turned off now (Current time: "
                    + Helper.GetCurrentTime() + " )");
        }
        else
        {
            System.out.println("Smart Light - " + alias + " has been already turned off");
        }
    }

    @Override
    public boolean testObject()
    {
        if (!connectionStatus)
        {
            return false;
        }

        SmartObjectToString();
        turnOnLight();
        turnOffLight();
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
        if (hasLightTurned)
        {
            turnOffLight();
        }

        return true;
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
        System.out.println("Smart Light - " + alias + " will be turned "
                + (hasLightTurned ? "off " : "on ") + seconds + " seconds later! (Current time: " + Helper.GetCurrentTime() + " )");
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
            turnOnLight();
        }
        else
        {
            turnOffLight();
        }

        programTime = null;

    }

    @Override
    public void onLeave()
    {

        if (connectionStatus)
        {
            turnOffLight();
        }
    }

    @Override
    public void onCome()
    {
        if (connectionStatus)
        {
            turnOnLight();
        }
    }
}

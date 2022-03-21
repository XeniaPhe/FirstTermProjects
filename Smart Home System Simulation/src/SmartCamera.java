
public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera>
{

    public boolean status;
    public int batteryLife;
    public boolean nightVision;

    public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife)
    {
        this.alias = alias;
        this.macId = macId;
        this.nightVision = nightVision;
        this.batteryLife = batteryLife;
    }

    public void recordOn(boolean isDay)
    {
        if (!connectionStatus)
        {
            return;
        }

        if (isDay)
        {
            if (status)
            {
                System.out.println("Smart Camera - " + alias + " has been already turned on");
            }
            else
            {
                status = true;
                System.out.println("Smart Camera - " + alias + " is turned on now");
            }
        }
        else
        {
            if (!nightVision)
            {
                System.out.println("Sorry! Smart Camera - " + alias + " does not have night vision feature.");
                return;
            }

            if (status)
            {
                System.out.println("Smart Camera - " + alias + " has been already turned on");
            }
            else
            {
                status = true;
                System.out.println("Smart Camera - " + alias + " is turned on now");
            }

        }

    }

    public void recordOff()
    {
        if (!connectionStatus)
        {
            return;
        }

        if (status)
        {
            status = false;
            System.out.println("Smart Camera - " + alias + " is turned off now");
        }
        else
        {
            System.out.println("Smart Camera - " + alias + " has been already turned off");
        }
    }

    @Override
    public int compareTo(SmartCamera o)
    {
        int diff = batteryLife - o.batteryLife;

        return (diff > 0) ? 1 : (diff < 0) ? -1 : 0;
    }

    @Override
    public boolean controlMotion(boolean hasMotion, boolean isDay)
    {

        System.out.println(hasMotion ? "Motion detected!" : "Motion not detected!");

        if (isDay || (!isDay && nightVision))
        {
            recordOn(isDay);
            return true;
        }
        else
        {
            return false;
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
        recordOn(true);
        recordOff();
        recordOn(false);
        recordOff();

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
            recordOff();
        }

        return true;
    }

    @Override
    public String toString()
    {
        return "Smart Camera -> " + alias + "'s battery life is " + batteryLife + " status is "
                + (status ? "recording" : "not recording");
    }

}

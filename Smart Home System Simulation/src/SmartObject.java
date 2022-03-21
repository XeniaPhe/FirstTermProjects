
public abstract class SmartObject
{

    protected String alias;
    protected String macId;
    private String IP;
    public boolean connectionStatus;

    public SmartObject()
    {

    }

    public boolean connect(String IP)
    {
        this.IP = IP;
        connectionStatus = true;

        System.out.println(alias + " connection established");
        return true;
    }

    public boolean disconnect()
    {
        this.IP = null;
        if (connectionStatus == false)
        {
            return false;
        }
        else
        {
            connectionStatus = false;
            return true;
        }

    }

    protected void SmartObjectToString()
    {
        System.out.println("This is " + this.getClass().getName() + " device " + alias
                + "\nMacId : " + macId + "\nIP : " + IP);
    }

    public boolean controlConection()
    {
        if (connectionStatus == false)
        {
            System.out.println("This device is not connected. " + this.getClass().getName() + " -> " + alias);
            return false;
        }
        else
        {
            return true;
        }
    }

    public abstract boolean testObject();

    public abstract boolean shutDownObject();

}

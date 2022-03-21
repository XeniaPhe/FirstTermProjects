
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SmartHome
{

    public ArrayList<SmartObject> smartObjectList;

    public SmartHome()
    {
        smartObjectList = new ArrayList<>();
    }

    public boolean addSmartObject(SmartObject smartObject)
    {

        System.out.println("Adding new Smart object");
        smartObject.connect("10.0.0." + (smartObjectList.size() + 99));
        System.out.println("Test is starting for " + smartObject.getClass().getName());
        smartObject.testObject();
        return smartObjectList.add(smartObject);
    }

    public boolean removeSmartObject(SmartObject smartObject)
    {
        return smartObjectList.remove(smartObject);
    }

    public void controlLocation(boolean onCome)
    {
        for (SmartObject item : smartObjectList)
        {
            if (item instanceof LocationControl)
            {
                if (onCome)
                {
                    ((LocationControl) item).onCome();
                }
                else
                {
                    ((LocationControl) item).onLeave();
                }
            }
        }
    }

    public void controlMotion(boolean hasMotion, boolean isDay)
    {
        for (SmartObject item : smartObjectList)
        {
            if (item instanceof MotionControl)
            {
                ((MotionControl) item).controlMotion(hasMotion, isDay);
            }
        }
    }

    public void controlProgrammable()
    {
        for (SmartObject item : smartObjectList)
        {
            if (item instanceof Programmable)
            {
                ((Programmable) item).runProgram();
            }
        }
    }

    public void controlTimer(int seconds)
    {
        for (SmartObject item : smartObjectList)
        {
            if (item instanceof Programmable)
            {
                if (seconds == 0)
                {
                    ((Programmable) item).cancelTimer();
                }
                else if (seconds > 0)
                {
                    ((Programmable) item).setTimer(seconds);
                }
            }
        }
    }

    public void controlTimerRandomly()
    {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(3);

        randomNumber = (randomNumber == 1) ? 0 : (randomNumber == 2) ? 5 : 10;

        for (SmartObject item : smartObjectList)
        {
            if (item instanceof Programmable)
            {
                if (randomNumber == 0)
                {
                    ((Programmable) item).cancelTimer();
                }
                else if (randomNumber > 0)
                {
                    ((Programmable) item).setTimer(randomNumber);
                }
            }
        }
    }

    public void sortCameras()
    {
        ArrayList<Comparable> cameras = new ArrayList<Comparable>();
        for (SmartObject item : smartObjectList)
        {
            if (item instanceof Comparable)
            {
                cameras.add((Comparable) item);
            }
        }
        Arrays.sort(cameras.toArray(), 0, cameras.size() - 1);

        for (Comparable item : cameras)
        {
            ((SmartCamera) item).SmartObjectToString();
        }
    }
}


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Helper
{

    public static String GetCurrentTime()
    {
        return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    }

}

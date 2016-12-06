package Order;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CurrentTime {


    public static String getTime()
    {
        DateFormat df = new SimpleDateFormat("yy-MM-dd HH:mm");
        Date dateobj = new Date();
        //  System.out.println(df.format(dateobj));

    /*getting current date time using calendar class
     * An Alternative of above*/
        Calendar calobj = Calendar.getInstance();
        String str=df.format(calobj.getTime());
        return str;
    }

}

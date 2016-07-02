import java.util.Date;
import java.util.Calendar;

class Countdown
{
  private int milliseconds;
  private int seconds;
  private int secondsDay;
  private int minutes;
  private int hours;
  private int days;
  private int month;
  private int year;
  private String date;
  
  public Countdown (String date)
  {
    this.date = date;
    
    String[] dateSplit = date.split("\\.");
    //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    //String dateInString = "05.08.2010";
    //Date date = sdf.parse(date);
    days = Integer.parseInt(dateSplit[0]);
    month = Integer.parseInt(dateSplit[1]);
    month--;
    year = Integer.parseInt(dateSplit[2]); 
    
    
    
    
  }
  public String getCountdown()
  {
    
    Calendar thatDate = Calendar.getInstance();
    thatDate.setTime(new Date(0)); /* reset */
    thatDate.set(Calendar.ZONE_OFFSET,2);
    thatDate.set(Calendar.DAY_OF_MONTH,days);
    thatDate.set(Calendar.MONTH,month);
    thatDate.set(Calendar.YEAR, year);
    Calendar today = Calendar.getInstance();
    int SECONDS_IN_A_DAY = 24 * 60 * 60;
    
    long diff =  thatDate.getTimeInMillis() - today.getTimeInMillis();
    
    long diffSec = diff / 1000;
    
    //long days = (diffSec / SECONDS_IN_A_DAY);
    long days = (((diffSec / 24)/60)/60);
    long secondsDay = diffSec % SECONDS_IN_A_DAY;
    long seconds = secondsDay % 60;
    //long milliseconds = seconds / 1000;
    long minutes = (secondsDay / 60) % 60;
    long hours = (secondsDay / 3600) - 2; // % 24 not needed
    
    String countedDate =   " " +days + " :" + hours + " :" + minutes + " :" + seconds + " :" + milliseconds;
    return countedDate;
  }
  
  
}
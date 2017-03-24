package Components;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Test;

/**
 * Created by Aramorchi on 12.03.2017.
 */
public class SecondsTest {
  @Test
  public void minutesTest(){
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.SECOND, 9);
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.SECOND, 25);

    Seconds seconds = new Seconds("s", calendar);
    assertEquals("9", seconds.getFormatComponent());

    Seconds secondsWithTwoNumbers = new Seconds("s", calendarOne);
    assertEquals("25", secondsWithTwoNumbers.getFormatComponent());


  }

  @Test
  public void fullMinutesTest() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.SECOND, 9);
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.SECOND, 25);

    Seconds secondss = new Seconds("ss", calendar);
    assertEquals("09", secondss.getFormatComponent());

    Seconds secondssWithTwoNumbers = new Seconds("ss", calendarOne);
    assertEquals("25", secondssWithTwoNumbers.getFormatComponent());
  }
}
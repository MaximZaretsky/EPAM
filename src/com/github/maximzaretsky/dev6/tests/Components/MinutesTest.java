package Components;

import static org.junit.Assert.*;

import com.sun.javafx.css.CalculatedValue;
import java.util.Calendar;
import org.junit.Test;

/**
 * Created by Aramorchi on 12.03.2017.
 */
public class MinutesTest {

  @Test
  public void minutesTest(){
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MINUTE, 9);
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.MINUTE, 25);

    Minutes minutesm = new Minutes("m", calendar);
    assertEquals("9", minutesm.getFormatComponent());

    Minutes minutesmWithTwoNumbers = new Minutes("m", calendarOne);
    assertEquals("25", minutesmWithTwoNumbers.getFormatComponent());


  }

  @Test
  public void fullMinutesTest() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MINUTE, 9);
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.MINUTE, 25);

    Minutes minutesmm = new Minutes("mm", calendar);
    assertEquals("09", minutesmm.getFormatComponent());

    Minutes minutesmmWithTwoNumbers = new Minutes("mm", calendarOne);
    assertEquals("25", minutesmmWithTwoNumbers.getFormatComponent());
  }
}
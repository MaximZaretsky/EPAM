package Components;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Test;

/**
 * Created by Aramorchi on 12.03.2017.
 */
public class MillisecondsTest {

  @Test
  public void millisecondTest() {
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.MILLISECOND, 250);

    Milliseconds milliseconds = new Milliseconds("f", calendarOne);
    assertEquals("2", milliseconds.getFormatComponent());

    Milliseconds millisecondsff = new Milliseconds("ff", calendarOne);
    assertEquals("25", millisecondsff.getFormatComponent());

    Milliseconds millisecondsfff = new Milliseconds("fff", calendarOne);
    assertEquals("250", millisecondsfff.getFormatComponent());
  }

  @Test
  public void notANullMillisecondTest() {
    Calendar calendarOne = Calendar.getInstance();
    Calendar calendarTwo = Calendar.getInstance();
    calendarOne.set(Calendar.MILLISECOND, 250);
    calendarTwo.set(Calendar.MILLISECOND, 000);

    Milliseconds milliseconds = new Milliseconds("F", calendarOne);
    assertEquals("2", milliseconds.getFormatComponent());

    Milliseconds millisecondsff = new Milliseconds("FF", calendarOne);
    assertEquals("25", millisecondsff.getFormatComponent());

    Milliseconds millisecondsfff = new Milliseconds("FFF", calendarOne);
    assertEquals("250", millisecondsfff.getFormatComponent());

    Milliseconds millisecondsF = new Milliseconds("F", calendarTwo);
    assertEquals("", millisecondsF.getFormatComponent());

    Milliseconds millisecondsFF = new Milliseconds("FF", calendarTwo);
    assertEquals("", millisecondsFF.getFormatComponent());

    Milliseconds millisecondsFFF = new Milliseconds("FFF", calendarTwo);
    assertEquals("", millisecondsFFF.getFormatComponent());
  }
}
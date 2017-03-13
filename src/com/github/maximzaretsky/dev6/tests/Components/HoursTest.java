package Components;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Test;

/**
 * Created by Aramorchi on 12.03.2017.
 */
public class HoursTest {

  @Test
  public void hourTest() {
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.HOUR, 9);
    Hours hours = new Hours("h", calendarOne);

    assertEquals("9", hours.getFormatComponent());
  }

  @Test
  public void fullHourTest() {
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.HOUR, 9);
    Hours hours = new Hours("hh", calendarOne);

    assertEquals("09", hours.getFormatComponent());

    calendarOne.set(Calendar.HOUR, 11);
    Hours hoursWithTwoNumbers = new Hours("hh", calendarOne);

    assertEquals("11", hoursWithTwoNumbers.getFormatComponent());
  }

  @Test
  public void hourOfDayTest() {
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.HOUR_OF_DAY, 0);
    Hours hours = new Hours("H", calendarOne);

    assertEquals("0", hours.getFormatComponent());
  }

  @Test
  public void fullHourOfDayTest() {
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.HOUR_OF_DAY, 0);
    Hours hours = new Hours("HH", calendarOne);

    assertEquals("00", hours.getFormatComponent());

    calendarOne.set(Calendar.HOUR_OF_DAY, 13);
    Hours hoursWithTwoNumbers = new Hours("HH", calendarOne);

    assertEquals("13", hoursWithTwoNumbers.getFormatComponent());
  }

  @Test
  public void amPmTest() {
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.HOUR_OF_DAY, 0);
    Hours hours = new Hours("t", calendarOne);

    assertEquals("A", hours.getFormatComponent());

    calendarOne.set(Calendar.HOUR_OF_DAY, 15);
    Hours hoursPm = new Hours("t", calendarOne);
    assertEquals("P", hoursPm.getFormatComponent());
  }

  @Test
  public void fullAmPmTest() {
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(Calendar.HOUR_OF_DAY, 0);
    Hours hours = new Hours("tt", calendarOne);

    assertEquals("AM", hours.getFormatComponent());

    calendarOne.set(Calendar.HOUR_OF_DAY, 15);
    Hours hoursPm = new Hours("tt", calendarOne);

    assertEquals("PM", hoursPm.getFormatComponent());
  }
}
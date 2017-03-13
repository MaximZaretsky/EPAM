package Components;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Test;

/**
 *
 */
public class DaysTest {

  @Test
  public void getFullNameOfDayweekTest() {
    Calendar calendarOne = Calendar.getInstance();
    calendarOne.set(2017, 2, 8);
    Days days = new Days("dddd", calendarOne);

    assertEquals("Wrong work of method 'getFullNameOfDayweek' !", "Wednesday", days.getFormatComponent());
  }

  @Test
  public void getAbbreviatedNameOfDayweekTest() {
    Calendar calendarTwo = Calendar.getInstance();
    calendarTwo.set(2017, 2, 8);
    Days days = new Days("ddd", calendarTwo);

    assertEquals("Wrong work of method 'getAbbreviatedNameOfDayweek' !", "Wed", days.getFormatComponent());
  }

  @Test
  public void getDayOfMonthTest() {
    Calendar calendarThree = Calendar.getInstance();
    calendarThree.set(2017, 2, 8);
    Days days = new Days("d", calendarThree);

    assertEquals("Wrong work of method 'getDayOfMonth' !", "8", days.getFormatComponent());
  }

  @Test
  public void getFullDayOfMonthTest() {
    Calendar calendarFour = Calendar.getInstance();
    calendarFour.set(2017, 2, 8);
    Days days = new Days("dd", calendarFour);

    assertEquals("Wrong work of method 'getFullDayOfMonth' !", "08", days.getFormatComponent());

    calendarFour.set(2017, 2, 15);
    Days daysWithTwoNumbers = new Days("dd", calendarFour);

    assertEquals("Wrong work of method 'getFullDayOfMonth' !", "15", days.getFormatComponent());
  }
}
package Components;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Test;

/**
 * Created by Aramorchi on 12.03.2017.
 */
public class MonthsTest {

  @Test
  public void abbreviatedNameOfMonthTest() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, Calendar.MARCH);

    Months months = new Months("MMM", calendar);
    assertEquals("Mar", months.getFormatComponent());
  }

  @Test
  public void fullNameOfMonthTest() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, Calendar.MARCH);

    Months months = new Months("MMMM", calendar);
    assertEquals("March", months.getFormatComponent());
  }

  @Test
  public void numberOfMonthTest() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, Calendar.MARCH);

    Months months = new Months("M", calendar);
    assertEquals("3", months.getFormatComponent());
  }

  @Test
  public void fullNumberOfMonthTest() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, Calendar.MARCH);

    Months months = new Months("MM", calendar);
    assertEquals("03", months.getFormatComponent());

    calendar.set(Calendar.MONTH, Calendar.OCTOBER);

    Months monthWithTwoNumbers = new Months("MM", calendar);
    assertEquals("10", monthWithTwoNumbers.getFormatComponent());
  }
}
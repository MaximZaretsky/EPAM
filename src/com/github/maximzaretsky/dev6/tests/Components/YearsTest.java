package Components;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Test;

/**
 * Created by Aramorchi on 12.03.2017.
 */
public class YearsTest {

  @Test
  public void yearTest() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2017);

    Years yearWithOneNumber = new Years("y", calendar);
    assertEquals("7", yearWithOneNumber.getFormatComponent());

    Years yearWithTwoNumber = new Years("yy", calendar);
    assertEquals("17", yearWithTwoNumber.getFormatComponent());

    Years yearWithThreeNumber = new Years("yyy", calendar);
    assertEquals("017", yearWithThreeNumber.getFormatComponent());

    Years yearWithFourNumber = new Years("yyyy", calendar);
    assertEquals("2017", yearWithFourNumber.getFormatComponent());
  }

  @Test
  public void eraTest() {
    Calendar calendar = Calendar.getInstance();

    Years era = new Years("g", calendar);
    assertEquals("A.D.", era.getFormatComponent());
  }
}
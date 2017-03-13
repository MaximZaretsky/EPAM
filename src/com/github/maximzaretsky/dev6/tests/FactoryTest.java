import static org.junit.Assert.*;

import Components.*;
import java.util.Calendar;
import org.junit.Test;

/**
 * Created by Aramorchi on 12.03.2017.
 */
public class FactoryTest {

  @Test
  public void getMillisecondComponentTest(){
    Calendar calendar = Calendar.getInstance();

    String inputStringOne = "ff";
    String inputStringTwo = "F";

    Factory factory = new Factory();
    FormatComponents componentOne = factory.getComponent(inputStringOne, calendar);
    FormatComponents componentTwo = factory.getComponent(inputStringTwo, calendar);

    assertTrue(componentOne instanceof Milliseconds);
    assertTrue(componentTwo instanceof Milliseconds);
  }

  @Test
  public void getDaysComponentTest(){
    Calendar calendar = Calendar.getInstance();

    String inputStringOne = "dd";
    String inputStringTwo = "ddd";

    Factory factory = new Factory();
    FormatComponents componentOne = factory.getComponent(inputStringOne, calendar);
    FormatComponents componentTwo = factory.getComponent(inputStringTwo, calendar);

    assertTrue(componentOne instanceof Days);
    assertTrue(componentTwo instanceof Days);
  }

  @Test
  public void getMinutesComponentTest(){
    Calendar calendar = Calendar.getInstance();

    String inputStringOne = "m";
    String inputStringTwo = "mm";

    Factory factory = new Factory();
    FormatComponents componentOne = factory.getComponent(inputStringOne, calendar);
    FormatComponents componentTwo = factory.getComponent(inputStringTwo, calendar);

    assertTrue(componentOne instanceof Minutes);
    assertTrue(componentTwo instanceof Minutes);
  }


  @Test
  public void getYearsComponentTest(){
    Calendar calendar = Calendar.getInstance();

    String inputStringOne = "y";
    String inputStringTwo = "yyyy";
    String inputStringThree = "g";

    Factory factory = new Factory();
    FormatComponents componentOne = factory.getComponent(inputStringOne, calendar);
    FormatComponents componentTwo = factory.getComponent(inputStringTwo, calendar);
    FormatComponents componentThree = factory.getComponent(inputStringThree, calendar);

    assertTrue(componentOne instanceof Years);
    assertTrue(componentTwo instanceof Years);
    assertTrue(componentThree instanceof Years);
  }

  @Test
  public void getSecondsComponentTest(){
    Calendar calendar = Calendar.getInstance();

    String inputStringOne = "s";
    String inputStringTwo = "ss";

    Factory factory = new Factory();
    FormatComponents componentOne = factory.getComponent(inputStringOne, calendar);
    FormatComponents componentTwo = factory.getComponent(inputStringTwo, calendar);

    assertTrue(componentOne instanceof Seconds);
    assertTrue(componentTwo instanceof Seconds);
  }

  @Test
  public void getHoursComponentTest(){
    Calendar calendar = Calendar.getInstance();

    String inputStringOne = "h";
    String inputStringTwo = "HH";
    String inputStringThree = "tt";
    String inputStringFour = "K";
    String inputStringFive = "z";

    Factory factory = new Factory();
    FormatComponents componentOne = factory.getComponent(inputStringOne, calendar);
    FormatComponents componentTwo = factory.getComponent(inputStringTwo, calendar);
    FormatComponents componentThree = factory.getComponent(inputStringThree, calendar);
    FormatComponents componentFour = factory.getComponent(inputStringFour, calendar);
    FormatComponents componentFive = factory.getComponent(inputStringFive, calendar);

    assertTrue(componentOne instanceof Seconds);
    assertTrue(componentTwo instanceof Seconds);
    assertTrue(componentThree instanceof Seconds);
    assertTrue(componentFour instanceof Seconds);
    assertTrue(componentFive instanceof Seconds);
  }

  @Test
  public void getMonthsComponentTest(){
    Calendar calendar = Calendar.getInstance();

    String inputStringOne = "M";
    String inputStringTwo = "MM";

    Factory factory = new Factory();
    FormatComponents componentOne = factory.getComponent(inputStringOne, calendar);
    FormatComponents componentTwo = factory.getComponent(inputStringTwo, calendar);

    assertTrue(componentOne instanceof Months);
    assertTrue(componentTwo instanceof Months);
  }
}
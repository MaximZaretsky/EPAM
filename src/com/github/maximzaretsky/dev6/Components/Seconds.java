package Components;

import java.util.Calendar;

/**
 * Handles symbols, related to day
 */
public class Seconds extends FormatComponents {
  private final String SECONDS = "s";
  private final String FULL_SECONDS = "ss";
  private String returnComponent;

  /**
   * Constructor of class, which transmit received data to defineMethodForExecution
   * @param formatComponent string, received from factory
   * @param calendar instance of java.util.Calendar
   */
  public Seconds (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  /**
   * Define, which method will be called depending on the received string
   * @param formatComponent string, received from constructor
   * @param calendar calendar, received from constructor
   */
  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.equals(SECONDS)){
      getSeconds(calendar);
    } else if (formatComponent.equals(FULL_SECONDS)){
      getFullSeconds(calendar);
    }
  }

  /**
   * Define seconds in format from 00 to 59
   * @param calendar calendar, received from constructor
   */
  private void getSeconds(Calendar calendar){
    returnComponent = calendar.get(Calendar.SECOND) + "";
  }

  /**
   * Define seconds in format from 00 to 59
   * @param calendar calendar, received from constructor
   */
  private void getFullSeconds(Calendar calendar){
    if (calendar.get(Calendar.SECOND) < 10) {
      returnComponent = "0" + calendar.get(Calendar.SECOND);
    } else {
      returnComponent = calendar.get(Calendar.SECOND) + "";
    }
  }

  /**
   *
   * @return value of milled component
   */
  public String getFormatComponent() {
    return returnComponent;
  }
}

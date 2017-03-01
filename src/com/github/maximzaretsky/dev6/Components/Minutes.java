package Components;

import java.util.Calendar;

/**
 * Handles symbols, related to day
 */
public class Minutes extends FormatComponents{
  private final String MINUTES = "m";
  private final String FULL_MINUTES = "mm";
  private String returnComponent;

  /**
   * Constructor of class, which transmit received data to defineMethodForExecution
   * @param formatComponent string, received from factory
   * @param calendar instance of java.util.Calendar
   */
  public Minutes (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  /**
   * Define, which method will be called depending on the received string
   * @param formatComponent string, received from constructor
   * @param calendar calendar, received from constructor
   */
  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.equals(MINUTES)){
      getMinutes(calendar);
    } else if (formatComponent.equals(FULL_MINUTES)){
      getFullMinutes(calendar);
    }
  }

  /**
   * Define minutes in format from 0 to 59
   * @param calendar calendar, received from constructor
   */
  private void getMinutes(Calendar calendar){
    returnComponent = calendar.get(Calendar.MINUTE) + "";
  }

  /**
   * Define minutes in format from 00 to 59
   * @param calendar calendar, received from constructor
   */
  private void getFullMinutes(Calendar calendar){
    if (calendar.get(Calendar.MINUTE) < 10) {
      returnComponent = "0" + calendar.get(Calendar.MINUTE);
    } else {
      returnComponent = calendar.get(Calendar.MINUTE) + "";
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

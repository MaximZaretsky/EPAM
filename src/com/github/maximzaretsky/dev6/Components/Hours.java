package Components;

import java.util.*;

/**
 * Handles symbols, related to day
 */
public class Hours extends FormatComponents {
  private final String HOUR = "h";
  private final String FULL_HOUR = "hh";
  private final String HOUR_OF_DAY = "H";
  private final String FULL_HOUR_OF_DAY = "HH";

  private String returnComponent;

  /**
   * Constructor of class, which transmit received data to defineMethodForExecution
   * @param formatComponent string, received from factory
   * @param calendar instance of java.util.Calendar
   */
  public Hours (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  /**
   * Define, which method will be called depending on the received string
   * @param formatComponent string, received from constructor
   * @param calendar calendar, received from constructor
   */
  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.equals(HOUR)){
      getHour(calendar);
    } else if (formatComponent.equals(FULL_HOUR)){
      getFullHour(calendar);
    } else if (formatComponent.equals(HOUR_OF_DAY)){
      getHourOfDay(calendar);
    } else if (formatComponent.equals(FULL_HOUR_OF_DAY)){
      getFullHourOfDay(calendar);
    }
  }

  /**
   * Define hours in format from 1 to 12
   * @param calendar calendar, received from constructor
   */
  private void getHour(Calendar calendar) {
    returnComponent = calendar.get(Calendar.HOUR) + "";
  }

  /**
   * Define hours in format from 01 to 12
   * @param calendar calendar, received from constructor
   */
  private void getFullHour(Calendar calendar){
    if (calendar.get(Calendar.HOUR) < 10) {
      returnComponent = "0" + calendar.get(Calendar.HOUR);
    } else {
      returnComponent = calendar.get(Calendar.HOUR) + "";
    }
  }

  /**
   * Define hours in format from 0 to 23
   * @param calendar calendar, received from constructor
   */
  private void getHourOfDay(Calendar calendar){
    returnComponent = calendar.get(Calendar.HOUR_OF_DAY) + "";
  }

  /**
   * Define hours in format from 00 to 23
   * @param calendar calendar, received from constructor
   */
  private void getFullHourOfDay(Calendar calendar){
    if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
      returnComponent = "0" + calendar.get(Calendar.HOUR_OF_DAY);
    } else {
      returnComponent = calendar.get(Calendar.HOUR_OF_DAY) + "";
    }
  }

  /**
   *
   * @return value of milled component
   */
  public String getFormatComponent(){
    return returnComponent;
  }

}

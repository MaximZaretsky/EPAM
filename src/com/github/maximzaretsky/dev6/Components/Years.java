package Components;

import java.util.Calendar;

/**
 * Handles symbols, related to day
 */
public class Years extends FormatComponents{
  private final String YEAR = "y";
  private final String ERA = "g";
  private String returnComponent;

  /**
   * Constructor of class, which transmit received data to defineMethodForExecution
   * @param formatComponent string, received from factory
   * @param calendar instance of java.util.Calendar
   */
  public Years (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  /**
   * Define, which method will be called depending on the received string
   * @param formatComponent string, received from constructor
   * @param calendar calendar, received from constructor
   */
  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.startsWith(YEAR)){
      getYear(formatComponent, calendar);
    } else if (formatComponent.startsWith(ERA)){
      getEra();
    }
  }

  /**
   * Define last numbers of year
   * @param formatComponent amount of need numbers
   * @param calendar calendar, received from constructor
   */
  private void getYear(String formatComponent, Calendar calendar){
    String YearComponent = calendar.get(Calendar.YEAR) + "";

    returnComponent = YearComponent.substring(YearComponent.length() - formatComponent.length());
  }

  /**
   * Define the era
   */
  private void getEra() {
    returnComponent = "A.D.";
  }

  /**
   *
   * @return value of milled component
   */
  public String getFormatComponent() {
    return returnComponent;
  }
}

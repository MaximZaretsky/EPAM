package Components;

import java.util.Calendar;

/**
 * Handles symbols, related to day
 */
public class Milliseconds extends FormatComponents{
  private final String MILLISECONDS = "f";
  private final String NOT_NULL_MILLISECONDS = "F";
  private final int MAXIMAL_LENGTH = 3;
  private String returnComponent;

  /**
   * Constructor of class, which transmit received data to defineMethodForExecution
   * @param formatComponent string, received from factory
   * @param calendar instance of java.util.Calendar
   */
  public Milliseconds(String formatComponent, Calendar calendar){
    defineMethodForExecution(formatComponent, calendar);
  }

  /**
   * Define, which method will be called depending on the received string
   * @param formatComponent string, received from constructor
   * @param calendar calendar, received from constructor
   */
  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.startsWith(MILLISECONDS)){
      getMilliseconds(calendar, formatComponent);
    } else if (formatComponent.startsWith(NOT_NULL_MILLISECONDS)){
      getNotNullMilliseconds(calendar, formatComponent);
    }
  }

  /**
   * Define how many milliseconds needs to display
   * @param calendar calendar, received from constructor
   * @param formatComponent amount of numbers, which need to display
   */
  private void getMilliseconds(Calendar calendar, String formatComponent){
    if (formatComponent.length() <= MAXIMAL_LENGTH) {
      returnComponent = (calendar.get(Calendar.MILLISECOND) + "").substring(0, formatComponent.length());
    } else {
      returnComponent = calendar.get(Calendar.MILLISECOND) + "";
      for (int i = MAXIMAL_LENGTH; i < formatComponent.length(); i++) {
        returnComponent += "0";
      }
    }
  }

  /**
   * Define how many milliseconds needs to display, if value of milliseconds not equal 0
   * @param calendar calendar, received from constructor
   * @param formatComponent amount of numbers, which need to display
   */
  private void getNotNullMilliseconds(Calendar calendar, String formatComponent){
    if (calendar.get(Calendar.MILLISECOND) != 0) {
      if (formatComponent.length() <= MAXIMAL_LENGTH) {
        returnComponent = (calendar.get(Calendar.MILLISECOND) + "").substring(0, formatComponent.length());
      } else {
        returnComponent = calendar.get(Calendar.MILLISECOND) + "";
        for (int i = MAXIMAL_LENGTH; i < formatComponent.length(); i++) {
          returnComponent += "0";
        }
      }
    } else {
      returnComponent = "";
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

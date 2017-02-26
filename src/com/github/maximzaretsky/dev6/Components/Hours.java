package Components;

import java.util.*;

/**
 * Created by Aramorchi on 24.02.2017.
 */
public class Hours extends FormatComponents {
  private final String HOUR = "h";
  private final String FULL_HOUR = "hh";
  private final String HOUR_OF_DAY = "H";
  private final String FULL_HOUR_OF_DAY = "HH";

  private String returnComponent;

  public Hours (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

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

  private void getHour(Calendar calendar){
    returnComponent = calendar.get(Calendar.HOUR) + "";
  }

  private void getFullHour(Calendar calendar){
    if (calendar.get(Calendar.HOUR) < 10) {
      returnComponent = "0" + calendar.get(Calendar.HOUR);
    } else {
      returnComponent = calendar.get(Calendar.HOUR) + "";
    }
  }

  private void getHourOfDay(Calendar calendar){
    returnComponent = calendar.get(Calendar.HOUR_OF_DAY) + "";
  }

  private void getFullHourOfDay(Calendar calendar){
    if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
      returnComponent = "0" + calendar.get(Calendar.HOUR_OF_DAY);
    } else {
      returnComponent = calendar.get(Calendar.HOUR_OF_DAY) + "";
    }
  }

  public String getFormatComponent(){
    return returnComponent;
  }

}

package Components;

import java.util.Calendar;

/**
 * Created by Aramorchi on 24.02.2017.
 */
public class Seconds extends FormatComponents {
  private final String SECONDS = "s";
  private final String FULL_SECONDS = "ss";
  private String returnComponent;

  public Seconds (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.equals(SECONDS)){
      getSeconds(calendar);
    } else if (formatComponent.equals(FULL_SECONDS)){
      getFullSeconds(calendar);
    }
  }

  private void getSeconds(Calendar calendar){
    returnComponent = calendar.get(Calendar.SECOND) + "";
  }

  private void getFullSeconds(Calendar calendar){
    if (calendar.get(Calendar.SECOND) < 10) {
      returnComponent = "0" + calendar.get(Calendar.SECOND);
    } else {
      returnComponent = calendar.get(Calendar.SECOND) + "";
    }
  }

  public String getFormatComponent(){
    return returnComponent;
  }
}

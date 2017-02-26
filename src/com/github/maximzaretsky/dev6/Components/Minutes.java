package Components;

import java.util.Calendar;

/**
 * Created by Aramorchi on 24.02.2017.
 */
public class Minutes extends FormatComponents{
  private final String MINUTES = "m";
  private final String FULL_MINUTES = "mm";
  private String returnComponent;

  public Minutes (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.equals(MINUTES)){
      getMinutes(calendar);
    } else if (formatComponent.equals(FULL_MINUTES)){
      getFullMinutes(calendar);
    }
  }

  private void getMinutes(Calendar calendar){
    returnComponent = calendar.get(Calendar.MINUTE) + "";
  }

  private void getFullMinutes(Calendar calendar){
    if (calendar.get(Calendar.MINUTE) < 10) {
      returnComponent = "0" + calendar.get(Calendar.MINUTE);
    } else {
      returnComponent = calendar.get(Calendar.MINUTE) + "";
    }
  }

  public String getFormatComponent(){
    return returnComponent;
  }
}

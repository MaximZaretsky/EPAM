package Components;

import java.util.Calendar;

/**
 * Created by Aramorchi on 25.02.2017.
 */
public class Milliseconds extends FormatComponents{
  private final String MILLISECONDS = "f";
  private final String NOT_NULL_MILLISECONDS = "F";
  private final int MAXIMAL_LENGTH = 3;
  private String returnComponent;

  public Milliseconds(String formatComponent, Calendar calendar){
    defineMethodForExecution(formatComponent, calendar);
  }

  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.startsWith(MILLISECONDS)){
      getMilliseconds(calendar, formatComponent);
    } else if (formatComponent.startsWith(NOT_NULL_MILLISECONDS)){
      getNotNullMilliseconds(calendar, formatComponent);
    }
  }

  private void getMilliseconds(Calendar calendar, String formatComponent){
    if (formatComponent.length() <= MAXIMAL_LENGTH) {
      returnComponent = (calendar.get(Calendar.MILLISECOND) + "").substring(0, formatComponent.length() + 1);
    } else {
      returnComponent = calendar.get(Calendar.MILLISECOND) + "";
      for (int i = MAXIMAL_LENGTH; i < formatComponent.length(); i++) {
        returnComponent += "0";
      }
    }
  }

  private void getNotNullMilliseconds(Calendar calendar, String formatComponent){
    if (calendar.get(Calendar.MILLISECOND) != 0) {
      if (formatComponent.length() <= MAXIMAL_LENGTH) {
        returnComponent = (calendar.get(Calendar.MILLISECOND) + "").substring(0, formatComponent.length() + 1);
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

  public String getFormatComponent(){
    return returnComponent;
  }
}

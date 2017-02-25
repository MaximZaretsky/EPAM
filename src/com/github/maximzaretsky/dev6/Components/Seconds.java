package Components;

import java.util.Calendar;

/**
 * Created by Aramorchi on 24.02.2017.
 */
public class Seconds extends FormatComponents {

  public Seconds (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  private void defineMethodForExecution(String formatComponent, Calendar calendar){

  }

  public String getFormatComponent(){
    return "wazzup6";
  }
}

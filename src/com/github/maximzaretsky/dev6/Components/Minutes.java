package Components;

import java.util.Calendar;

/**
 * Created by Aramorchi on 24.02.2017.
 */
public class Minutes extends FormatComponents{

  public Minutes (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  private void defineMethodForExecution(String formatComponent, Calendar calendar){

  }

  public String getFormatComponent(){
    return "wazzup4";
  }

}

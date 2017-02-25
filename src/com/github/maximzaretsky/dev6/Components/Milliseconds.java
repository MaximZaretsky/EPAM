package Components;

import java.util.Calendar;

/**
 * Created by Aramorchi on 25.02.2017.
 */
public class Milliseconds extends FormatComponents{

  public Milliseconds(String formatComponent, Calendar calendar){
    defineMethodForExecution(formatComponent, calendar);
  }

  private void defineMethodForExecution(String formatComponent, Calendar calendar){

  }

  public String getFormatComponent(){
    return "wazzup3";
  }
}

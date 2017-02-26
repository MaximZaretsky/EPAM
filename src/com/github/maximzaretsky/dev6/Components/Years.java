package Components;

import java.util.Calendar;

public class Years extends FormatComponents{
  private final String YEAR = "y";
  private final String ERA = "g";
  private String returnComponent;

  public Years (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.startsWith(YEAR)){
      getYear(formatComponent, calendar);
    } else if (formatComponent.startsWith(ERA)){
      getEra(calendar);
    }
  }

  private void getYear(String formatComponent, Calendar calendar){
    String YearComponent = calendar.get(Calendar.YEAR) + "";

    returnComponent = YearComponent.substring(YearComponent.length() - formatComponent.length());
  }

  private void getEra(Calendar calendar) {
    returnComponent = "A.D.";
  }

  public String getFormatComponent(){
    return returnComponent;
  }
}

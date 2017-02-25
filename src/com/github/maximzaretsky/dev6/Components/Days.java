package Components;

import java.util.Calendar;

/**
 * Created by Aramorchi on 24.02.2017.
 */
public class Days extends FormatComponents{
  private final String DAY_OF_MONTH = "d";
  private final String FULL_DAY_OF_MONTH = "dd";
  private final String ABBREVIATED_NAME_OF_DAYWEEK = "ddd";
  private final String FULL_NAME_OF_DAYWEEK = "dddd";

  private String returnComponent;

  public Days(String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.equals(DAY_OF_MONTH)){
      getDayOfMonth(calendar);
    } else if (formatComponent.equals(FULL_DAY_OF_MONTH)){
        getFullDayOfMonth(calendar);
    } else if (formatComponent.equals(ABBREVIATED_NAME_OF_DAYWEEK)){
        getAbbreviatedNameOfDayWeek(calendar);
    } else if (formatComponent.equals(FULL_NAME_OF_DAYWEEK)){
        getFullNameOfDayweek(calendar);
    }
  }

  private void getDayOfMonth(Calendar calendar){
    returnComponent = calendar.get(Calendar.DAY_OF_MONTH) + "";
  }

  private void getFullDayOfMonth(Calendar calendar){
    if ((calendar.get(Calendar.DAY_OF_MONTH) + "").length() < 2) {
      returnComponent = "0" + calendar.get(Calendar.DAY_OF_MONTH);
    } else {
      returnComponent = calendar.get(Calendar.DAY_OF_MONTH) + "";
    }
  }

  private void getAbbreviatedNameOfDayWeek(Calendar calendar){
    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
      returnComponent = "Sun";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
        returnComponent = "Mon";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
        returnComponent = "Tue";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
        returnComponent = "Wed";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
        returnComponent = "Thur";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
        returnComponent = "Fri";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
        returnComponent = "Sat";
    }
  }

  private void getFullNameOfDayweek(Calendar calendar){
    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
      returnComponent = "Sunday";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
      returnComponent = "Monday";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
      returnComponent = "Tuesday";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
      returnComponent = "Wednesday";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
      returnComponent = "Thursday";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
      returnComponent = "Friday";
    } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
      returnComponent = "Saturday";
    }
  }

  public String getFormatComponent(){
    return returnComponent;
  }
}

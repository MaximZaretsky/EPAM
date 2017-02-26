package Components;

import java.util.Calendar;

/**
 * Created by Aramorchi on 24.02.2017.
 */
public class Months extends FormatComponents{
  private final String NUMBER_OF_MONTH = "M";
  private final String FULL_NUMBER_OF_MONTH = "MM";
  private final String ABBREVIATED_NAME_OF_MONTH = "MMM";
  private final String FULL_NAME_OF_MONTH = "MMMM";
  private String returnComponent;

  public Months (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  private void defineMethodForExecution(String formatComponent, Calendar calendar){
    if (formatComponent.equals(NUMBER_OF_MONTH)){
      getNumberOfMonth(calendar);
    } else if (formatComponent.equals(FULL_NUMBER_OF_MONTH)){
      getFullNumberOfMonth(calendar);
    } else if (formatComponent.equals(ABBREVIATED_NAME_OF_MONTH)){
      getAbbreviatedNameOfMonth(calendar);
    } else if (formatComponent.equals(FULL_NAME_OF_MONTH)){
      getFullNameOfMonth(calendar);
    }
  }

  private void getNumberOfMonth(Calendar calendar){
    returnComponent = calendar.get(Calendar.MONTH) + "";
  }

  private void getFullNumberOfMonth(Calendar calendar){
    if ((calendar.get(Calendar.MONTH) + "").length() < 2) {
      returnComponent = "0" + calendar.get(Calendar.MONTH);
    } else {
      returnComponent = calendar.get(Calendar.MONTH) + "";
    }
  }

  private void getAbbreviatedNameOfMonth(Calendar calendar){
    if (calendar.get(Calendar.MONTH) == Calendar.JANUARY) {
      returnComponent = "Jan";
    } else if (calendar.get(Calendar.MONTH) == Calendar.FEBRUARY) {
      returnComponent = "Feb";
    } else if (calendar.get(Calendar.MONTH) == Calendar.MARCH) {
      returnComponent = "Mar";
    } else if (calendar.get(Calendar.MONTH) == Calendar.APRIL) {
      returnComponent = "Apr";
    } else if (calendar.get(Calendar.MONTH) == Calendar.MAY) {
      returnComponent = "May";
    } else if (calendar.get(Calendar.MONTH) == Calendar.JUNE) {
      returnComponent = "Jun";
    } else if (calendar.get(Calendar.MONTH) == Calendar.JULY) {
      returnComponent = "Jul";
    } else if (calendar.get(Calendar.MONTH) == Calendar.AUGUST) {
      returnComponent = "Aug";
    } else if (calendar.get(Calendar.MONTH) == Calendar.SEPTEMBER) {
      returnComponent = "Sep";
    } else if (calendar.get(Calendar.MONTH) == Calendar.OCTOBER) {
      returnComponent = "Oct";
    } else if (calendar.get(Calendar.MONTH) == Calendar.NOVEMBER) {
      returnComponent = "Nov";
    } else if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER) {
      returnComponent = "Dec";
    }
  }

  private void getFullNameOfMonth(Calendar calendar){
    if (calendar.get(Calendar.MONTH) == Calendar.JANUARY) {
      returnComponent = "January";
    } else if (calendar.get(Calendar.MONTH) == Calendar.FEBRUARY) {
      returnComponent = "February";
    } else if (calendar.get(Calendar.MONTH) == Calendar.MARCH) {
      returnComponent = "March";
    } else if (calendar.get(Calendar.MONTH) == Calendar.APRIL) {
      returnComponent = "April";
    } else if (calendar.get(Calendar.MONTH) == Calendar.MAY) {
      returnComponent = "May";
    } else if (calendar.get(Calendar.MONTH) == Calendar.JUNE) {
      returnComponent = "June";
    } else if (calendar.get(Calendar.MONTH) == Calendar.JULY) {
      returnComponent = "July";
    } else if (calendar.get(Calendar.MONTH) == Calendar.AUGUST) {
      returnComponent = "August";
    } else if (calendar.get(Calendar.MONTH) == Calendar.SEPTEMBER) {
      returnComponent = "September";
    } else if (calendar.get(Calendar.MONTH) == Calendar.OCTOBER) {
      returnComponent = "October";
    } else if (calendar.get(Calendar.MONTH) == Calendar.NOVEMBER) {
      returnComponent = "November";
    } else if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER) {
      returnComponent = "December";
    }
  }

  public String getFormatComponent(){
    return returnComponent;
  }
}

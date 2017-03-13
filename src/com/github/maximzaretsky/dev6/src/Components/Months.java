package Components;

import java.util.Calendar;

/**
 * Handles symbols, related to day
 */
public class Months extends FormatComponents{
  private final String NUMBER_OF_MONTH = "M";
  private final String FULL_NUMBER_OF_MONTH = "MM";
  private final String ABBREVIATED_NAME_OF_MONTH = "MMM";
  private final String FULL_NAME_OF_MONTH = "MMMM";
  private String returnComponent;
  private final int ADD_THIS_NUMBER_TO_KNOW_REAL_NUMBER_OF_MONTH = 1;

  /**
   * Constructor of class, which transmit received data to defineMethodForExecution
   * @param formatComponent string, received from factory
   * @param calendar instance of java.util.Calendar
   */
  public Months (String formatComponent, Calendar calendar) {
    defineMethodForExecution(formatComponent, calendar);
  }

  /**
   * Define, which method will be called depending on the received string
   * @param formatComponent string, received from constructor
   * @param calendar calendar, received from constructor
   */
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

  /**
   * Define number of month in format from 1 to 12
   * @param calendar calendar, received from constructor
   */
  private void getNumberOfMonth(Calendar calendar){
    returnComponent = (calendar.get(Calendar.MONTH) + ADD_THIS_NUMBER_TO_KNOW_REAL_NUMBER_OF_MONTH) + "";
  }

  /**
   * Define number of month in format from 01 to 12
   * @param calendar calendar, received from constructor
   */
  private void getFullNumberOfMonth(Calendar calendar){
    if (((calendar.get(Calendar.MONTH) + ADD_THIS_NUMBER_TO_KNOW_REAL_NUMBER_OF_MONTH) + "").length() < 2) {
      returnComponent = "0" + (calendar.get(Calendar.MONTH) + ADD_THIS_NUMBER_TO_KNOW_REAL_NUMBER_OF_MONTH);
    } else {
      returnComponent = (calendar.get(Calendar.MONTH) + ADD_THIS_NUMBER_TO_KNOW_REAL_NUMBER_OF_MONTH) + "";
    }
  }

  /**
   * Define abbreviated name of month
   * @param calendar calendar, received from constructor
   */
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

  /**
   * Define full name of month
   * @param calendar calendar, received from constructor
   */
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

  /**
   *
   * @return value of milled component
   */
  public String getFormatComponent() {
    return returnComponent;
  }
}

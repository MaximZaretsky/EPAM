package Checkers;

/**
 * This class check existence of day under received number
 */
public class DayOfMonthChecker implements DateComponentChecker {
  private final int NUMBER_OF_LEAP_YEAR = 4;
  private final int MINIMAL_VALUE_OF_DAY = 1;

  private final int JANUARY_LENGTH = 31;
  private final int FEBRUARY_LENGTH = 28;
  private final int LEAP_FEBRUARY_LENGTH = 29;
  private final int MARCH_LENGTH = 31;
  private final int APRIL_LENGTH = 30;
  private final int MAY_LENGTH = 31;
  private final int JUNE_LENGTH = 30;
  private final int JULY_LENGTH = 31;
  private final int AUGUST_LENGTH = 31;
  private final int SEPTEMBER_LENGTH = 30;
  private final int OCTOBER_LENGTH = 31;
  private final int NOVEMBER_LENGTH = 30;
  private final int DECEMBER_LENGTH = 31;

  private final int[] LENGTH_OF_MONTHS_IN_STANDART_YEAR = {JANUARY_LENGTH, FEBRUARY_LENGTH, MARCH_LENGTH,
                                                           APRIL_LENGTH, MAY_LENGTH, JUNE_LENGTH,
                                                           JULY_LENGTH, AUGUST_LENGTH, SEPTEMBER_LENGTH,
                                                           OCTOBER_LENGTH, NOVEMBER_LENGTH, DECEMBER_LENGTH};
  private final int[] LENGTH_OF_MONTHS_IN_LEAP_YEAR = {JANUARY_LENGTH, LEAP_FEBRUARY_LENGTH, MARCH_LENGTH,
                                                       APRIL_LENGTH, MAY_LENGTH, JUNE_LENGTH,
                                                       JULY_LENGTH, AUGUST_LENGTH, SEPTEMBER_LENGTH,
                                                       OCTOBER_LENGTH, NOVEMBER_LENGTH, DECEMBER_LENGTH};

  /**
   * Check existence of day under received number
   *
   * @param month received month
   * @param day received day
   * @param year received year
   * @return exist or not received day
   */
  public boolean checkValidity(String month, String day, String year){
    boolean answer;

    if (leapYear(year)) {
      answer = checkDayOfMonthOfLeapYear(day, month);
    } else {
        answer = checkDayOfMonthOfStandartYear(day, month);
    }
    return answer;
  }

  /**
   * Check leap or not received year
   *
   * @param yearString received year
   * @return true if year leap
   */
  private boolean leapYear(String yearString) {
    boolean answer;
    int year = Integer.parseInt(yearString);

    if (year % NUMBER_OF_LEAP_YEAR == 0){
      answer = true;
    } else {
        answer = false;
    }
    return answer;
  }

  /**
   * Check existence of received day if received year are leap
   *
   * @param dayString received day
   * @param monthString received month
   * @return exist this day or not
   */
  private boolean checkDayOfMonthOfLeapYear(String dayString, String monthString) {
    boolean answer;
    int day = Integer.parseInt(dayString);
    int month = Integer.parseInt(monthString);
    int monthInArray = month - 1;

    if (month <= LENGTH_OF_MONTHS_IN_STANDART_YEAR.length) {
      if (day >= MINIMAL_VALUE_OF_DAY
          && day <= LENGTH_OF_MONTHS_IN_LEAP_YEAR[monthInArray]) {
        answer = true;
      } else {
        answer = false;
      }
    } else {
      answer = false;
    }

    return answer;
  }

  /**
   * Check existence of received day if received year are not leap
   *
   * @param dayString received day
   * @param monthString received month
   * @return exist this day or not
   */
  private boolean checkDayOfMonthOfStandartYear(String dayString, String monthString) {
    boolean answer;
    int day = Integer.parseInt(dayString);
    int month = Integer.parseInt(monthString);
    int monthInArray = month - 1;

    if (month <= LENGTH_OF_MONTHS_IN_STANDART_YEAR.length) {
      if (day >= MINIMAL_VALUE_OF_DAY
          && day <= LENGTH_OF_MONTHS_IN_STANDART_YEAR[monthInArray]) {
        answer = true;
      } else {
        answer = false;
      }
    } else {
        answer = false;
    }
    return answer;
  }
}

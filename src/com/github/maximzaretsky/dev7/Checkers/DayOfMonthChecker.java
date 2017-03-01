package Checkers;

/**
 * Created by Aramorchi on 28.02.2017.
 */
public class DayOfMonthChecker implements DateComponentChecker {
  private final int NUMBER_OF_LEAP_YEAR = 4;

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

  public boolean checkValidity(String month, String day, String year){
    boolean answer;

    if (leapYear(year)) {
      answer = checkDayOfMonthOfLeapYear(day, month);
    } else {
        answer = checkDayOfMonthOfStandartYear(day, month);
    }
    return answer;
  }

  private boolean leapYear(String yearString) {
    boolean answer;
    int year = Integer.parseInt(yearString);

    if (year % NUMBER_OF_LEAP_YEAR != 0){
      answer = true;
    } else {
        answer = false;
    }
    return answer;
  }

  private boolean checkDayOfMonthOfLeapYear(String dayString, String monthString) {
    boolean answer;
    int day = Integer.parseInt(dayString);
    int monthInArray = Integer.parseInt(monthString) - 1;

    if (day >= LENGTH_OF_MONTHS_IN_LEAP_YEAR[monthInArray] && day <= LENGTH_OF_MONTHS_IN_LEAP_YEAR[monthInArray]) {
      answer = true;
    } else {
        answer = false;
    }

    return answer;
  }

  private boolean checkDayOfMonthOfStandartYear(String dayString, String monthString) {
    boolean answer;
    int day = Integer.parseInt(dayString);
    int monthInArray = Integer.parseInt(monthString) - 1;

    if (day >= LENGTH_OF_MONTHS_IN_STANDART_YEAR[monthInArray] && day <= LENGTH_OF_MONTHS_IN_STANDART_YEAR[monthInArray]) {
      answer = true;
    } else {
      answer = false;
    }

    return answer;
  }
}

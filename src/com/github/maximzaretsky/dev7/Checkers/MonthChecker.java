package Checkers;

/**
 * Check existence of received month
 */
public class MonthChecker implements DateComponentChecker {
  private final int MINIMAL_NUMBER_OF_MONTH = 1;
  private final int MAXIMAL_NUMBER_OF_MONTH = 12;

  /**
   * Check validity of received month
   * @param month received month
   * @param day received day
   * @param year received year
   * @return valid month or not
   */
  public boolean checkValidity(String month, String day, String year) {
    boolean answer;

    answer = checkExistenceOfMonth(month);

    return answer;
  }

  /**
   * Check existence of received month
   * @param monthString number of received month
   * @return exist or not
   */
  private boolean checkExistenceOfMonth(String monthString) {
    boolean answer;
    int month = Integer.parseInt(monthString);

    if (month >= MINIMAL_NUMBER_OF_MONTH && month <= MAXIMAL_NUMBER_OF_MONTH) {
      answer = true;
    } else {
        answer = false;
    }
    return answer;
  }
}

package Checkers;

/**
 * Check existence of received year
 */
public class YearChecker implements DateComponentChecker {
  private final int MINIMAL_VALUE_OF_YEAR = 0;

  /**
   * Check validity of received year
   * @param day received day
   * @param month received month
   * @param year received year
   * @return valid or not
   */
  public boolean checkValidity(String day, String month, String year){
    boolean answer;

    answer = checkExistenceOfYear(year);

    return answer;
  }

  /**
   * Check existence of received year
   *
   * @param yearString received year
   * @return exist or not
   */
  private boolean checkExistenceOfYear(String yearString) {
    boolean answer;
    int year = Integer.parseInt(yearString);

    if (year >= MINIMAL_VALUE_OF_YEAR) {
      answer = true;
    } else {
      answer = false;
    }
    return answer;
  }
}

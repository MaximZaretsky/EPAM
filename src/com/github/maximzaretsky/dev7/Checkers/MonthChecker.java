package Checkers;

/**
 * Created by Aramorchi on 28.02.2017.
 */
public class MonthChecker implements DateComponentChecker {
  private final int MINIMAL_NUMBER_OF_MONTH = 1;
  private final int MAXIMAL_NUMBER_OF_MONTH = 12;

  public boolean checkValidity(String month, String day, String year) {
    boolean answer;

    answer = checkExistenceOfMonth(month);

    return answer;
  }

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

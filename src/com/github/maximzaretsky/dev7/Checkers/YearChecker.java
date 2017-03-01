package Checkers;

/**
 * Created by Aramorchi on 28.02.2017.
 */
public class YearChecker implements DateComponentChecker {
  private final int MINIMAL_VALUE_OF_YEAR = 0;

  public boolean checkValidity(String day, String month, String year){
    boolean answer;

    answer = checkExistenceOfYear(year);

    return answer;
  }

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

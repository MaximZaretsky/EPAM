package Checkers;

/**
 * Created by Aramorchi on 28.02.2017.
 */
public class HourChecker implements TimeComponentChecker {
  private final int MINIMAL_HOUR = 0;
  private final int MAXIMAL_HOUR = 23;
  private boolean answer;

  public boolean checkValidity(String hourString) {
    int hour = Integer.parseInt(hourString);
    if ( hour >= MINIMAL_HOUR && hour <= MAXIMAL_HOUR ){
      answer = true;
    } else {
      answer = false;
    }
    return answer;
  }
}

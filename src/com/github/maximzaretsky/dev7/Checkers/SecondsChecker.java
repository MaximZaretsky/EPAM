package Checkers;

/**
 * Created by Aramorchi on 28.02.2017.
 */
public class SecondsChecker implements TimeComponentChecker {
  private final int MINIMAL_SECOND = 0;
  private final int MAXIMAL_SECOND = 59;
  private boolean answer;

  public boolean checkValidity(String secondString) {
    int second = Integer.parseInt(secondString);
    if ( second >= MINIMAL_SECOND && second <= MAXIMAL_SECOND ){
      answer = true;
    } else {
      answer = false;
    }
    return answer;
  }
}

package Checkers;

/**
 * Check existence of received minute
 */
public class MinuteChecker implements TimeComponentChecker {
  private final int MINIMAL_MINUTE = 0;
  private final int MAXIMAL_MINUTE = 59;
  private boolean answer;

  /**
   * Check existence of received minute
   *
   * @param minuteString received minute
   * @return exist minute or not
   */
  public boolean checkValidity(String minuteString) {
    int minute = Integer.parseInt(minuteString);
    if ( minute >= MINIMAL_MINUTE && minute <= MAXIMAL_MINUTE ){
      answer = true;
    } else {
      answer = false;
    }
    return answer;
  }
}

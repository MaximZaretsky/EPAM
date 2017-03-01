package Checkers;

/**
 * Interface for checkers for time components
 */
public interface TimeComponentChecker {

  /**
   * Check validity of received component
   * @param timeComponent received component
   * @return valid or not
   */
  public boolean checkValidity(String timeComponent);
}

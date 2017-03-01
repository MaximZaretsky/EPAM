package Checkers;

/**
 * Check validity of received date
 */
public interface DateComponentChecker {

  /**
   * Check validity of received date
   * @param month received month
   * @param day received day
   * @param second received second
   * @return valid or not
   */
  public boolean checkValidity(String month, String day, String second);
}

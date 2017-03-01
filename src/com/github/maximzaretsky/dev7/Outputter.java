/**
 * Print necessary message depending on result
 */
public class Outputter {
  private final String POSITIVE_MESSAGE = "This date valid";
  private final String NEGATIVE_MESSAGE = "This date invalid!";

  /**
   * Define method which will be print result
   *
   * @param determinantTrue determinant for method
   */
  public void defineMessageForOutput(boolean determinantTrue) {
    if (determinantTrue) {
      printMessageForPositiveResult();
    } else {
        printMessageForNegativeResult();
    }
  }

  /**
   * Print message in case of good result
   */
  private void printMessageForPositiveResult() {
    System.out.println(POSITIVE_MESSAGE);
  }

  /**
   * Print message in case of bad result
   */
  private void printMessageForNegativeResult() {
    System.out.println(NEGATIVE_MESSAGE);
  }
}

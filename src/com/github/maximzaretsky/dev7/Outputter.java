/**
 * Created by Aramorchi on 01.03.2017.
 */
public class Outputter {
  private final String POSITIVE_MESSAGE = "This date valid";
  private final String NEGATIVE_MESSAGE = "This date invalid!";

  public void defineMessageForOutput(boolean determinantTrue) {
    if (determinantTrue) {
      printMessageForPositiveResult();
    } else {
        printMessageForNegativeResult();
    }
  }

  private void printMessageForPositiveResult() {
    System.out.println(POSITIVE_MESSAGE);
  }

  private void printMessageForNegativeResult() {
    System.out.println(NEGATIVE_MESSAGE);
  }
}

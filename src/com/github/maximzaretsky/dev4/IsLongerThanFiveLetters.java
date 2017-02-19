import java.util.List;

/**
 * This class check, which words from received array
 * contain 5 or more letters
 */
public class IsLongerThanFiveLetters implements Operations {
  private int amountOfLongWords = 0;
  private final int NUMBER_OF_LETTERS = 5;

  /**
   * This method receive text, and start execution of operation
   *
   * @param text is milled text, got from user
   */
  public void doOperation(List<String> text){
    longerOrNot(text);
  }

  /**
   * This method define, word contain more letters, than
   * NUMBERS_OF_LETTERS, or not
   *
   * @param text is milled text, got from user
   */
  private void longerOrNot(List<String> text){
    for(String words: text){
      if (words.length() >= NUMBER_OF_LETTERS) {
        amountOfLongWords++;
      }
    }
  }

  /**
   * This method print amount of long words
   */
  public void printResult() {
    System.out.println("Amount of long words (5 or more letters) in all entered text is: " + amountOfLongWords);
  }
}

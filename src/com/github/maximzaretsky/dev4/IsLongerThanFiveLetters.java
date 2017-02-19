import java.util.List;

/**
 * Created by Aramorchi on 18.02.2017.
 */
public class IsLongerThanFiveLetters implements Operations {
  private int amountOfLongWords = 0;
  private final int NUMBER_OF_LETTERS = 5;

  public void doOperation(List<String> text){
    longerOrNot(text);
  }

  private void longerOrNot(List<String> text){
    for(String words: text){
      if (words.length() >= NUMBER_OF_LETTERS) {
        amountOfLongWords++;
      }
    }
  }

  public void printResult() {
    System.out.println("Amount of long words (5 or more letters) in all entered text is: " + amountOfLongWords);
  }
}

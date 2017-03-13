import java.util.ArrayList;
import java.util.List;

/**
 * Split input string on String array,
 * using whitespace as a splitter
 */
public class Splitter {
  private List<String> splittedInputString = new ArrayList<>();

  /**
   * This constructor transmit input string to
   * method split
   * @param inputString string, which we got from console
   */
  public Splitter(String inputString) {
    split(inputString);
  }

  /**
   * Split input string on String array,
   * using whitespace as a splitter
   *
   * @param stringForSplitting string, which we will split
   */
  private void split(String stringForSplitting){
    String[] splitted = stringForSplitting.split(" ");

    for (String splitWords: splitted) {
      splittedInputString.add(splitWords);
    }
  }

  /**
   *
   * @return list of splitted parameters
   */
  public List<String> getSplittedInputString() {
    return splittedInputString;
  }
}

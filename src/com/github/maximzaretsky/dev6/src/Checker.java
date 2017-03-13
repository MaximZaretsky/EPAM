/**
 * Check input string on correct input
 */
public class Checker {

  /**
   * First phase of checking. Check, contain input string
   * or not contain other symbols, except permitted
   *
   * @param inputString string, got from console
   * @return correct input or not
   */
  public boolean correctInput(String inputString) {
    boolean correctInput = true;
    String editedFormatInformation = inputString.replaceAll("[^dfghmstyzFHKM ]", "");
    if (editedFormatInformation.length() != inputString.length()) {
      correctInput = false;
    } else {
        correctInput = checkMoreDetail(inputString);
    }
    return correctInput;
  }

  /**
   * Second phase of checking
   * @param informationForCheck string, passed the first phase
   * @return correct input or not
   */
  private boolean checkMoreDetail(String informationForCheck) {
    String[] words = informationForCheck.split(" ");

    boolean correctInput = true;
    for(String word: words) {
      for (int i = 1; i < word.length(); i++) {
        if (word.charAt(i) != word.charAt(i - 1)) {
          correctInput = false;
        }
      }
    }
    return correctInput;
  }

}

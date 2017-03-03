/**
 * Check validity of received string with format components
 */
public class InputChecker {

  /**
   * Check was input correct or not
   *
   * @param inputString received from user string
   * @return valid string or not
   */
  public boolean correctInput(String inputString) {
    boolean correctInput;
    String editedFormatInformation = inputString.replaceAll("[^0-9:/ ]", "");
    if (editedFormatInformation.length() != inputString.length()) {
      correctInput = false;
    } else {
      correctInput = true;
    }
    return correctInput;
  }
}

/**
 * Created by Aramorchi on 28.02.2017.
 */
public class InputChecker {
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

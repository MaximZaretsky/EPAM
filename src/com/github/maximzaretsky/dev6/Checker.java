/**
 * Created by Aramorchi on 25.02.2017.
 */
public class Checker {
  public boolean check(String inputString) {
    boolean correctInput = true;
    String editedFormatInformation = inputString.replaceAll("[^dfghmstyzKMH ]", "");
    if (editedFormatInformation.length() != inputString.length()) {
      correctInput = false;
    } else {
        correctInput = checkMoreDetail(inputString);
    }
    return correctInput;
  }

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

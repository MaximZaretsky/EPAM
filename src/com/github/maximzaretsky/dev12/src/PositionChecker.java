import java.util.List;

/**
 * Check validity of entered fields
 */
public class PositionChecker {

  private final int INDEX_OF_LETTER_PART = 0;
  private final int INDEX_OF_DIGIT_PART = 1;

  private final int MAXIMAL_LENGTH_OF_FIELD = 2;
  private final String REGEX_FOR_CHECKING_VALIDITY_OF_INPUT_FIELD = "[^A-H1-8]";

  /**
   * Check syntax validity of entered field
   *
   * @param inputField string with coordinates of field
   * @return valid or not
   */
  public boolean checkSyntaxValidityOfInputField(String inputField) {
    boolean answer;

    if (inputField.length() > MAXIMAL_LENGTH_OF_FIELD) {
      answer = false;
    } else if (inputField.replaceAll(REGEX_FOR_CHECKING_VALIDITY_OF_INPUT_FIELD, "").length() < inputField.length()) {
        answer = false;
    } else if (Character.isAlphabetic(inputField.charAt(INDEX_OF_LETTER_PART)) && Character.isDigit(inputField.charAt(INDEX_OF_DIGIT_PART))) {
        answer = true;
    } else {
        answer = false;
    }
    return answer;
  }

  /**
   * Check validity of entered position of chequer.
   * It will be invalid, if color of field white
   *
   * @param startPosition coordinates of field
   * @return valid or not
   */
  public boolean checkPositionValidity(List<Integer> startPosition) {
    boolean answer;

    int letterPart = startPosition.get(INDEX_OF_LETTER_PART);
    int digitPart = startPosition.get(INDEX_OF_DIGIT_PART);

    if (Math.abs(letterPart - digitPart) % 2 == 0) {
      answer = true;
    } else if (letterPart - digitPart == 0) {
      answer = true;
    } else {
      answer = false;
    }

    return answer;
  }

  /**
   * Check possibility to turn up into necessary field
   *
   * @param color color of chequer
   * @param startPosition start position of chequer
   * @param necessaryPosition necessary position of chequer
   * @return possible or not
   */
  public boolean checkPossibilityToTurnUpIntoNecessaryField(ColorOfChequer color, List<Integer> startPosition, List<Integer> necessaryPosition) {
    int horizontalDistanceBetweenFieldsForChequer = Math.abs(necessaryPosition.get(INDEX_OF_LETTER_PART) - startPosition.get(INDEX_OF_LETTER_PART));
    int verticalDistanceBetweenFields = startPosition.get(INDEX_OF_DIGIT_PART) - necessaryPosition.get(INDEX_OF_DIGIT_PART);

    boolean answer;

    if (color.equals(ColorOfChequer.WHITE)) {
      if (verticalDistanceBetweenFields > 0) {
        answer = false;
      } else {
        if (horizontalDistanceBetweenFieldsForChequer > Math.abs(verticalDistanceBetweenFields)) {
          answer = false;
        } else {
          answer = true;
        }
      }
    } else {
      if (verticalDistanceBetweenFields < 0) {
        answer = false;
      } else {
        if (horizontalDistanceBetweenFieldsForChequer > Math.abs(verticalDistanceBetweenFields)) {
          answer = false;
        } else {
          answer = true;
        }
      }
    }
    return answer;
  }

}

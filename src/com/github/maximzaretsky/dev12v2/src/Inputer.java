import java.util.*;

/**
 * Inputer for reading from console
 */
public class Inputer {

  private final int MAXIMAL_LENGTH_OF_FIELD = 2;
  private final String REGEX_FOR_CHECKING_VALIDITY_OF_INPUT_FIELD = "[^A-H1-8]";
  private final int INDEX_OF_LETTER_PART = 0;
  private final int INDEX_OF_DIGIT_PART = 1;

  /**
   * Define type of input data and call necessary checkers
   *
   * @param type type of input data
   * @param scanner Scanner for reading from console
   * @return String with input information
   */
  public String inputChequerData(TypeOfInputData type, Scanner scanner) {
    String information = "";

    boolean correctInput = false;
    while (!correctInput) {
      System.out.println("Enter correct " + type.toString() + " of your chequer: ");

      if (type.equals(TypeOfInputData.COLOR)) {
        information = scanner.next();
        correctInput = checkValidityOfColor(information);
      } else if (type.equals(TypeOfInputData.START_POSITION) || type.equals(TypeOfInputData.NECESSARY_POSITION)) {
        information = scanner.next();
        correctInput = checkValidityOfPosition(information);
      } else {
        information = "Wrong type of input information";
      }
    }
    return information;
  }

  /**
   * Check syntax validity of entered field
   *
   * @param inputField string with coordinates of field
   * @return valid or not
   */
  public boolean checkValidityOfPosition(String inputField) {
    boolean answer;

    if (inputField.length() > MAXIMAL_LENGTH_OF_FIELD) {
      answer = false;
    } else if (inputField.replaceAll(REGEX_FOR_CHECKING_VALIDITY_OF_INPUT_FIELD, "").length()
        < inputField.length()) {
      answer = false;
    } else if (Character.isAlphabetic(inputField.charAt(INDEX_OF_LETTER_PART)) && Character
        .isDigit(inputField.charAt(INDEX_OF_DIGIT_PART))) {
      answer = true;
    } else {
      answer = false;
    }
    return answer;
  }

  /**
   * Check validity of color
   *
   * @param color String, containing color
   * @return valid color or not
   */
  public boolean checkValidityOfColor(String color) {
    boolean answer;

    if (color.equalsIgnoreCase("white") || color.equalsIgnoreCase("black")) {
      answer = true;
    } else {
      answer = false;
    }
    return answer;
  }
}

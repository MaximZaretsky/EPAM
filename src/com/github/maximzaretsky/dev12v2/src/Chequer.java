import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contain methods for work with chequer
 */
public class Chequer {

  private final int INDEX_OF_LETTER_PART = 0;
  private final int INDEX_OF_DIGIT_PART = 1;
  private final int MAXIMAL_VALUE_OF_FIELD = 8;
  private final int NEXT_FIELD = 1;

  private ColorOfChequer color;
  private List<Integer> startPosition = new ArrayList<>(2);
  private List<Integer> currentPosition;
  private List<Integer> necessaryPosition = new ArrayList<>(2);

  private final Map<Character, Integer> letterPartOfField = new HashMap<>();

  /**
   * Initialize all parameters of chequer
   *
   * @param color color of chequer
   * @param startPosition start position of chequer
   * @param necessaryPosition necessary position of chequer
   */
  public Chequer(String color, String startPosition, String necessaryPosition) {
    initializeMap();
    initializeColor(color);
    initializePosition(TypeOfInputData.START_POSITION, startPosition);
    initializePosition(TypeOfInputData.NECESSARY_POSITION, necessaryPosition);
  }

  /**
   * Find number of steps to reaching necessary position
   * if its possible
   *
   * @return message with number of steps or message about impossibility
   * of reaching necessary position
   */
  public String findOutNumberOfSteps() {
    String answer;

    if (isValidPosition(startPosition) && isValidPosition(necessaryPosition) && isPossibleToTurnUpIntoNecessaryField()) {
      answer = "Number of steps = " + calculateNumberOfSteps();
    } else {
      answer = "It's impossible";
    }
    return answer;
  }

  /**
   * Calculate number of steps for reaching
   * necessary position
   *
   * @return number of steps
   */
  public int calculateNumberOfSteps() {
    int numberOfSteps = 0;
    this.currentPosition = startPosition;

    while (!currentPosition.equals(necessaryPosition)) {
      if (currentPosition.get(INDEX_OF_LETTER_PART) - necessaryPosition.get(INDEX_OF_LETTER_PART) < 0) {
        currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) + NEXT_FIELD);
        currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) + move());

      } else if (currentPosition.get(INDEX_OF_LETTER_PART) - necessaryPosition.get(INDEX_OF_LETTER_PART) > 0) {
        currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) - NEXT_FIELD);
        currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) + move());

      } else if (currentPosition.get(INDEX_OF_LETTER_PART) - necessaryPosition.get(INDEX_OF_LETTER_PART) == 0) {
        if (currentPosition.get(INDEX_OF_LETTER_PART) == MAXIMAL_VALUE_OF_FIELD) {
          currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) - NEXT_FIELD);
          currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) + move());

        } else {
          currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) + NEXT_FIELD);
          currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) + move());
        }
      }

      numberOfSteps++;
    }
    return numberOfSteps;
  }

  private int move() {
    int answer;

    if (color.equals(ColorOfChequer.BLACK)) {
      answer = -NEXT_FIELD;
    } else {
      answer = NEXT_FIELD;
    }
    return answer;
  }

  /**
   * Check validity of entered position of chequer.
   * It will be invalid, if color of field white
   *
   * @param position coordinates of field
   * @return valid or not
   */
  public boolean isValidPosition(List<Integer> position) {
    boolean answer;

    int letterPart = position.get(INDEX_OF_LETTER_PART);
    int digitPart = position.get(INDEX_OF_DIGIT_PART);

    if (Math.abs(letterPart - digitPart) % 2 == 0 || letterPart - digitPart == 0) {
      answer = true;
    } else {
      answer = false;
    }

    return answer;
  }

  /**
   * Calculate, possible or not reach necessary position
   *
   * @return possible or not
   */
  public boolean isPossibleToTurnUpIntoNecessaryField() {
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

  /**
   * Initialize color of chequer
   *
   * @param color string, containing color of chequer
   */
  private void initializeColor(String color) {
    if (color.equalsIgnoreCase("white")) {
      this.color = ColorOfChequer.WHITE;
    } else if (color.equalsIgnoreCase("black")) {
      this.color = ColorOfChequer.BLACK;
    }
  }

  /**
   * Initialize one of positions of chequer
   *
   * @param typeOfPosition start or necessary position
   * @param position String, containing position
   */
  private void initializePosition(TypeOfInputData typeOfPosition, String position) {
    if (typeOfPosition.equals(TypeOfInputData.START_POSITION)) {
      this.startPosition = split(position);
    } else if (typeOfPosition.equals(TypeOfInputData.NECESSARY_POSITION)) {
      this.necessaryPosition = split(position);
    }
  }

  /**
   * Split input string with coordinates of field on
   * horizontal coordinate and vertical coordinate
   *
   * @param coordinates String with coordinates
   * @return list with horizontal and vertical coordinates
   */
  private List<Integer> split(String coordinates) {
    List<Integer> splittedCoordinates = new ArrayList<>();
    splittedCoordinates
        .add(INDEX_OF_LETTER_PART, defineIndex(coordinates.charAt(INDEX_OF_LETTER_PART)));
    splittedCoordinates
        .add(INDEX_OF_DIGIT_PART, Integer.parseInt(coordinates.substring(INDEX_OF_DIGIT_PART)));

    return splittedCoordinates;
  }

  /**
   * Define int values of letter part of coordinates, using map with coordinates
   *
   * @param letterPartOfField vertical letter coordinate of field
   * @return vertical int coordinate of field
   */
  private int defineIndex(char letterPartOfField) {
    return this.letterPartOfField.get(letterPartOfField);
  }

  /**
   * Put int values of letter part of coordinates into map
   */
  private void initializeMap() {
    letterPartOfField.put('A', 1);
    letterPartOfField.put('B', 2);
    letterPartOfField.put('C', 3);
    letterPartOfField.put('D', 4);
    letterPartOfField.put('E', 5);
    letterPartOfField.put('F', 6);
    letterPartOfField.put('G', 7);
    letterPartOfField.put('H', 8);
  }

  /**
   * Return color of chequer
   *
   * @return color of chequer
   */
  public ColorOfChequer getColor() {
    return color;
  }

  /**
   * Return start position of chequer
   *
   * @return start position of chequer
   */
  public List<Integer> getStartPosition() {
    return startPosition;
  }

  /**
   * Return necessary position of chequer
   *
   * @return necessary position of chequer
   */
  public List<Integer> getNecessaryPosition() {
    return necessaryPosition;
  }
}

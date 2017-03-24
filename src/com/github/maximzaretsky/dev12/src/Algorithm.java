import java.util.List;

/**
 * Contain algorithms for calculating necessary number of moves
 * for reaching necessary position of chequer
 */
public class Algorithm {
  private final int INDEX_OF_LETTER_PART = 0;
  private final int INDEX_OF_DIGIT_PART = 1;
  private final int MAXIMAL_VALUE_OF_FIELD = 8;
  private final int NEXT_FIELD = 1;

  private List<Integer> currentPosition;

  /**
   * Define which algorithm will be call: for white chequer
   * or for black chequer
   *
   * @param color color of chequer
   * @param startPosition start position of chequer
   * @param necessaryPosition necessary position of chequer
   * @return number of moves for reaching necessary field
   */
  public int defineMethodForExecution(ColorOfChequer color, List<Integer> startPosition, List<Integer> necessaryPosition) {
    int answer;

    if (color == ColorOfChequer.WHITE) {
      answer = calculateNumberOfStepsForWhiteChequer(startPosition, necessaryPosition);
    } else {
      answer = calculateNumberOfStepsForBlackChequer(startPosition, necessaryPosition);
    }
    return answer;
  }

  /**
   * Calculate number of moves for black chequer for reaching necessary field
   *
   * @param startPosition start position of chequer
   * @param necessaryPosition necessary position of chequer
   * @return number of moves
   */
  public int calculateNumberOfStepsForBlackChequer(List<Integer> startPosition, List<Integer> necessaryPosition) {
    int numberOfSteps = 0;
    this.currentPosition = startPosition;

    while (!currentPosition.equals(necessaryPosition)) {
      if (currentPosition.get(INDEX_OF_LETTER_PART) - necessaryPosition.get(INDEX_OF_LETTER_PART) < 0) {
        currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) + NEXT_FIELD);
        currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) - NEXT_FIELD);
        numberOfSteps++;
      } else if (currentPosition.get(INDEX_OF_LETTER_PART) - necessaryPosition.get(INDEX_OF_LETTER_PART) > 0) {
        currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) - NEXT_FIELD);
        currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) - NEXT_FIELD);
        numberOfSteps++;
      } else if (currentPosition.get(INDEX_OF_LETTER_PART) - necessaryPosition.get(INDEX_OF_LETTER_PART) == 0) {
        if (currentPosition.get(INDEX_OF_LETTER_PART) == MAXIMAL_VALUE_OF_FIELD) {
          currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) - NEXT_FIELD);
          currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) - NEXT_FIELD);
          numberOfSteps++;
        } else {
          currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) + NEXT_FIELD);
          currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) - NEXT_FIELD);
          numberOfSteps++;
        }
      }
    }
    return numberOfSteps;
  }

  /**
   * Calculate number of moves for white chequer for reaching necessary field
   *
   * @param startPosition start position of chequer
   * @param necessaryPosition necessary position of chequer
   * @return number of moves
   */
  public int calculateNumberOfStepsForWhiteChequer(List<Integer> startPosition, List<Integer> necessaryPosition) {
    int numberOfSteps = 0;
    this.currentPosition = startPosition;

    while (!currentPosition.equals(necessaryPosition)) {
      if (currentPosition.get(INDEX_OF_LETTER_PART) - necessaryPosition.get(INDEX_OF_LETTER_PART) < 0) {
        currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) + NEXT_FIELD);
        currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) + NEXT_FIELD);
        numberOfSteps++;
      } else if (currentPosition.get(INDEX_OF_LETTER_PART) - necessaryPosition.get(INDEX_OF_LETTER_PART) > 0) {
          currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) - NEXT_FIELD);
          currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) + NEXT_FIELD);
          numberOfSteps++;
      } else if (currentPosition.get(INDEX_OF_LETTER_PART) - necessaryPosition.get(INDEX_OF_LETTER_PART) == 0) {
          if (currentPosition.get(INDEX_OF_LETTER_PART) == MAXIMAL_VALUE_OF_FIELD) {
            currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) - NEXT_FIELD);
            currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) + NEXT_FIELD);
            numberOfSteps++;
          } else {
            currentPosition.set(INDEX_OF_LETTER_PART, currentPosition.get(INDEX_OF_LETTER_PART) + NEXT_FIELD);
            currentPosition.set(INDEX_OF_DIGIT_PART, currentPosition.get(INDEX_OF_DIGIT_PART) + NEXT_FIELD);
            numberOfSteps++;
          }
      }
    }
    return numberOfSteps;
  }
}

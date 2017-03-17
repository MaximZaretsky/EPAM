import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Created by Aramorchi on 17.03.2017.
 */
public class PositionCheckerTest {

  @Test
  public void checkSyntaxValidityOfInputFieldPositiveTest() {
    String validString = "B2";

    PositionChecker positionChecker = new PositionChecker();

    assertTrue(positionChecker.checkSyntaxValidityOfInputField(validString));
  }

  @Test
  public void checkSyntaxValidityOfInputFieldNegativeTest() {
    String invalidStringOne = "B25";
    String invalidStringTwo = "z2";
    String invalidStringThree = "22";

    PositionChecker positionChecker = new PositionChecker();

    assertFalse(positionChecker.checkSyntaxValidityOfInputField(invalidStringOne));
    assertFalse(positionChecker.checkSyntaxValidityOfInputField(invalidStringTwo));
    assertFalse(positionChecker.checkSyntaxValidityOfInputField(invalidStringThree));
  }

  @Test
  public void checkPositionValidityPositiveTest() {
    List<Integer> startPosition = new ArrayList<>();
    startPosition.add(0, 5);
    startPosition.add(1, 5);

    PositionChecker positionChecker = new PositionChecker();

    assertTrue(positionChecker.checkPositionValidity(startPosition));
  }

  @Test
  public void checkPositionValidityNegativeTest() {
    List<Integer> startPosition = new ArrayList<>();
    startPosition.add(0, 4);
    startPosition.add(1, 3);

    PositionChecker positionChecker = new PositionChecker();

    assertFalse(positionChecker.checkPositionValidity(startPosition));
  }

  @Test
  public void checkPossibilityToTurnUpIntoNecessaryFieldPositiveTest() {
    ColorOfChequer colorOfWhiteChequer = ColorOfChequer.WHITE;
    ColorOfChequer colorOfBlackChequer = ColorOfChequer.BLACK;

    List<Integer> startPosition = new ArrayList<>();
    startPosition.add(0, 3);
    startPosition.add(1, 1);

    List<Integer> necessaryPosition = new ArrayList<>();
    necessaryPosition.add(0, 5);
    necessaryPosition.add(1, 5);

    PositionChecker positionChecker = new PositionChecker();

    assertTrue(positionChecker.checkPossibilityToTurnUpIntoNecessaryField(colorOfWhiteChequer, startPosition, necessaryPosition));
    assertTrue(positionChecker.checkPossibilityToTurnUpIntoNecessaryField(colorOfBlackChequer, necessaryPosition, startPosition));
  }

  @Test
  public void checkPossibilityToTurnUpIntoNecessaryFieldNegativeTest() {
    ColorOfChequer colorOfWhiteChequer = ColorOfChequer.WHITE;
    ColorOfChequer colorOfBlackChequer = ColorOfChequer.BLACK;

    List<Integer> startPosition = new ArrayList<>();
    startPosition.add(0, 3);
    startPosition.add(1, 1);

    List<Integer> necessaryPosition = new ArrayList<>();
    necessaryPosition.add(0, 5);
    necessaryPosition.add(1, 5);

    PositionChecker positionChecker = new PositionChecker();

    assertFalse(positionChecker.checkPossibilityToTurnUpIntoNecessaryField(colorOfWhiteChequer, necessaryPosition, startPosition));
    assertFalse(positionChecker.checkPossibilityToTurnUpIntoNecessaryField(colorOfBlackChequer, startPosition, necessaryPosition));
  }
}
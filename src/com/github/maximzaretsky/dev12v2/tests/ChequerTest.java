import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Created by Aramorchi on 26.03.2017.
 */
public class ChequerTest {

  @Test
  public void findOutNumberOfStepsPositiveTest() {
    String colorWhite = "white";
    String startPositionWhite = "C3";
    String necessaryPositionWhite = "B8";

    String colorBlack = "black";
    String startPositionBlack = "B8";
    String necessaryPositionBlack = "C3";

    Chequer whiteChequer = new Chequer(colorWhite, startPositionWhite, necessaryPositionWhite);
    Chequer blackChequer = new Chequer(colorBlack, startPositionBlack, necessaryPositionBlack);

    assertEquals("Number of steps = 5", whiteChequer.findOutNumberOfSteps());
    assertEquals("Number of steps = 5", blackChequer.findOutNumberOfSteps());
  }

  @Test
  public void findOutNumberOfStepsNegativeTest() {
    String colorWhite = "white";
    String startPositionWhite = "C4";
    String necessaryPositionWhite = "B8";

    String colorBlack = "black";
    String startPositionBlack = "B8";
    String necessaryPositionBlack = "C4";

    Chequer whiteChequer = new Chequer(colorWhite, startPositionWhite, necessaryPositionWhite);
    Chequer blackChequer = new Chequer(colorBlack, startPositionBlack, necessaryPositionBlack);

    assertEquals("It's impossible", whiteChequer.findOutNumberOfSteps());
    assertEquals("It's impossible", blackChequer.findOutNumberOfSteps());
  }

  @Test
  public void calculateNumberOfStepsTest() {
    String colorWhite = "white";
    String startPositionWhite = "C3";
    String necessaryPositionWhite = "B8";

    String colorBlack = "black";
    String startPositionBlack = "B8";
    String necessaryPositionBlack = "C3";

    Chequer whiteChequer = new Chequer(colorWhite, startPositionWhite, necessaryPositionWhite);
    Chequer blackChequer = new Chequer(colorBlack, startPositionBlack, necessaryPositionBlack);

    assertEquals(5, whiteChequer.calculateNumberOfSteps());
    assertEquals(5, blackChequer.calculateNumberOfSteps());
  }

  @Test
  public void isValidPositionPositiveTest() {
    String colorWhite = "white";
    String startPositionWhite = "C3";
    String necessaryPositionWhite = "B8";

    Chequer whiteChequer = new Chequer(colorWhite, startPositionWhite, necessaryPositionWhite);

    assertTrue(whiteChequer.isValidPosition(whiteChequer.getStartPosition()));
  }

  @Test
  public void isValidPositionNegativeTest() {
    String colorWhite = "white";
    String startPositionWhite = "C4";
    String necessaryPositionWhite = "B8";

    Chequer whiteChequer = new Chequer(colorWhite, startPositionWhite, necessaryPositionWhite);

    assertFalse(whiteChequer.isValidPosition(whiteChequer.getStartPosition()));
  }

  @Test
  public void isPossibleToTurnUpIntoNecessaryFieldPositiveTest() {
    String colorWhite = "white";
    String startPositionWhite = "C3";
    String necessaryPositionWhite = "B8";

    Chequer whiteChequer = new Chequer(colorWhite, startPositionWhite, necessaryPositionWhite);

    assertTrue(whiteChequer.isPossibleToTurnUpIntoNecessaryField());
  }

  @Test
  public void isPossibleToTurnUpIntoNecessaryFieldNegativeTest() {
    String colorWhite = "white";
    String startPositionWhite = "F4";
    String necessaryPositionWhite = "B5";

    Chequer whiteChequer = new Chequer(colorWhite, startPositionWhite, necessaryPositionWhite);

    assertFalse(whiteChequer.isPossibleToTurnUpIntoNecessaryField());
  }
}
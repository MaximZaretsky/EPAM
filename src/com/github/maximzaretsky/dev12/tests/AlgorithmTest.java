import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Created by Aramorchi on 16.03.2017.
 */
public class AlgorithmTest {

  @Test
  public void calculateNumberOfStepsForWhiteChequerTest() {
    Algorithm algorithm = new Algorithm();
    List<Integer> startPosition = new ArrayList<>();
    startPosition.add(0, 3);
    startPosition.add(1, 1);

    List<Integer> necessaryPosition = new ArrayList<>();
    necessaryPosition.add(0, 5);
    necessaryPosition.add(1, 5);

    assertEquals(4, algorithm.calculateNumberOfStepsForWhiteChequer(startPosition, necessaryPosition));
  }

  @Test
  public void calculateNumberOfStepsForBlackChequerTest() {
    Algorithm algorithm = new Algorithm();
    List<Integer> startPosition = new ArrayList<>();
    startPosition.add(0, 5);
    startPosition.add(1, 5);

    List<Integer> necessaryPosition = new ArrayList<>();
    necessaryPosition.add(0, 3);
    necessaryPosition.add(1, 1);

    assertEquals(4, algorithm.calculateNumberOfStepsForBlackChequer(startPosition, necessaryPosition));
  }

  @Test
  public void defineMethodForExecutionTest() {
    Algorithm algorithm = new Algorithm();
    ColorOfChequer colorOfWhiteChequer = ColorOfChequer.WHITE;
    ColorOfChequer colorOfBlackChequer = ColorOfChequer.BLACK;

    List<Integer> startPosition = new ArrayList<>();
    startPosition.add(0, 3);
    startPosition.add(1, 1);

    List<Integer> necessaryPosition = new ArrayList<>();
    necessaryPosition.add(0, 5);
    necessaryPosition.add(1, 5);

    assertEquals(4, algorithm.defineMethodForExecution(colorOfWhiteChequer, startPosition, necessaryPosition));
    assertEquals(4, algorithm.defineMethodForExecution(colorOfBlackChequer, necessaryPosition, startPosition));
  }
}
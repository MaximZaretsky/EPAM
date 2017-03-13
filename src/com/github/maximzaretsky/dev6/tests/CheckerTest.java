import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by Aramorchi on 12.03.2017.
 */
public class CheckerTest {

  @Test
  public void correctInputTest() {
    String inputString = "dd ffff MM HH";

    Checker checker = new Checker();
    assertTrue(checker.correctInput(inputString));
  }

  @Test
  public void incorrectInputTest() {
    String inputString = "flugegehaimen";

    Checker checker = new Checker();
    assertFalse(checker.correctInput(inputString));
  }

  @Test
  public void oneMoreIncorrectInputTest() {
    String inputString = "fg gg dm MH";

    Checker checker = new Checker();
    assertFalse(checker.correctInput(inputString));
  }
}
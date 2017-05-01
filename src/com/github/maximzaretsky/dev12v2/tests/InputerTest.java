import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by Aramorchi on 26.03.2017.
 */
public class InputerTest {

  @Test
  public void checkValidityOfPositionPositiveTest() {
    Inputer inputer = new Inputer();

    String position = "A2";

    assertTrue(inputer.checkValidityOfPosition(position));

  }

  @Test
  public void checkValidityOfColorPositiveTest() {
    Inputer inputer = new Inputer();

    String positionOne = "white";
    String positionTwo = "black";

    assertTrue(inputer.checkValidityOfColor(positionOne));
    assertTrue(inputer.checkValidityOfColor(positionTwo));
  }

  @Test
  public void checkValidityOfPositionNegativeTest() {
    Inputer inputer = new Inputer();

    String positionOne = "A25";
    String positionTwo = "L7";

    assertFalse(inputer.checkValidityOfPosition(positionOne));
    assertFalse(inputer.checkValidityOfPosition(positionTwo));
  }

  @Test
  public void checkValidityOfColorNegativeTest() {
    Inputer inputer = new Inputer();

    String positionOne = "red";

    assertFalse(inputer.checkValidityOfColor(positionOne));
  }

}
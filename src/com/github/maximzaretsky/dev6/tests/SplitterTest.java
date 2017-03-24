import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SplitterTest {

  @Test
  public void splitterTest() {
    String stringToSplit = "aa bb cc";
    List<String> expectedArray = new ArrayList<>();

    expectedArray.add("aa");
    expectedArray.add("bb");
    expectedArray.add("cc");

    Splitter splitter = new Splitter(stringToSplit);
    assertEquals(expectedArray, splitter.getSplittedInputString());
  }
}
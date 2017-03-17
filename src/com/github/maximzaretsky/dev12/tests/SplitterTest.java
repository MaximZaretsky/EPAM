import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Created by Aramorchi on 17.03.2017.
 */
public class SplitterTest {

  @Test
  public void splitTest() {
    List<Integer> coordinates = new ArrayList<>();
    coordinates.add(2);
    coordinates.add(2);

    Splitter splitter = new Splitter();
    String coordinatesString = "B2";


    assertEquals(coordinates, splitter.split(coordinatesString));

  }

}
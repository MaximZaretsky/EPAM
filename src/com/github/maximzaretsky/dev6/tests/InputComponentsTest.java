import static org.junit.Assert.*;

import Components.Hours;
import Components.Milliseconds;
import java.util.Calendar;
import org.junit.Test;

/**
 * Created by Aramorchi on 12.03.2017.
 */
public class InputComponentsTest {

  @Test
  public void addComponentTest() {
    Calendar calendar = Calendar.getInstance();
    Milliseconds milliseconds = new Milliseconds("ff", calendar);
    Hours hours = new Hours("tt", calendar);

    InputComponents inputComponents = new InputComponents();

    inputComponents.addComponent(milliseconds);
    assertEquals(1, inputComponents.getOutputComponents().size());

    inputComponents.addComponent(hours);
    assertEquals(2, inputComponents.getOutputComponents().size());
  }
}
import Components.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Keep components for output, which
 * we got from the factory
 */
public class InputComponents {
  private List<FormatComponents> outputComponents = new ArrayList<>();

  /**
   * Add component into list of components
   * @param inputComponents component, received from factory
   */
  public void addComponent(FormatComponents inputComponents) {
    outputComponents.add(inputComponents);
  }

  /**
   * Print value of each component
   */
  public void printComponents() {
    for (FormatComponents component: outputComponents) {
      System.out.print(component.getFormatComponent() + " ");
    }
  }

  public List<FormatComponents> getOutputComponents() {
    return outputComponents;
  }
}

import Components.*;
import java.util.ArrayList;
import java.util.List;

public class InputComponents {
  private List<FormatComponents> outputComponents = new ArrayList<>();

  public void addComponent(FormatComponents inputComponents) {
    outputComponents.add(inputComponents);
  }

  public void printComponents() {
    for (FormatComponents component: outputComponents) {
      System.out.print(component.getFormatComponent() + " ");
    }
  }

}

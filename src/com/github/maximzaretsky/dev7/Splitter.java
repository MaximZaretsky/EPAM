import java.util.ArrayList;
import java.util.List;

public class Splitter {
  private List<String> formatComponents = new ArrayList<>();
  private List<String> timeComponents = new ArrayList<>();
  private List<String> dateComponents = new ArrayList<>();

  private final int INDEX_OF_DATE_COMPONENTS = 0;
  private final int INDEX_OF_TIME_COMPONENTS = 1;

  public void splitOnComponents(String inputFormat){
    String[] splittedComponents = inputFormat.split(" ");

    for(String formatComponent: splittedComponents){
      this.formatComponents.add(formatComponent);
    }

    splitDate(formatComponents.get(INDEX_OF_DATE_COMPONENTS));
    splitTime(formatComponents.get(INDEX_OF_TIME_COMPONENTS));
  }

  private void splitTime(String timeComponents){
    String[] splittedTimeComponents = timeComponents.split(":");

    for(String timeComponent: splittedTimeComponents){
      this.timeComponents.add(timeComponent);
    }
  }

  private void splitDate(String dateComponents){
    String[] splittedDateComponents = dateComponents.split("/");

    for(String dateComponent: splittedDateComponents){
      this.dateComponents.add(dateComponent);
    }
  }

  public List<String> getDateComponents() {
    return dateComponents;
  }

  public List<String> getTimeComponents() {
    return timeComponents;
  }
}

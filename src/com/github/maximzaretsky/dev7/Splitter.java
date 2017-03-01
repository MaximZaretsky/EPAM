import java.util.ArrayList;
import java.util.List;

/**
 * Split input string on components of data and time
 */
public class Splitter {
  private List<String> formatComponents = new ArrayList<>();
  private List<String> timeComponents = new ArrayList<>();
  private List<String> dateComponents = new ArrayList<>();

  private final int INDEX_OF_DATE_COMPONENTS = 0;
  private final int INDEX_OF_TIME_COMPONENTS = 1;

  /**
   * Split input String on string with data and string with time
   *
   * @param inputFormat received String
   */
  public void splitOnComponents(String inputFormat){
    String[] splittedComponents = inputFormat.split(" ");

    for(String formatComponent: splittedComponents){
      this.formatComponents.add(formatComponent);
    }

    splitDate(formatComponents.get(INDEX_OF_DATE_COMPONENTS));
    splitTime(formatComponents.get(INDEX_OF_TIME_COMPONENTS));
  }

  /**
   * Split strings with time on time components
   *
   * @param timeComponents string with time
   */
  private void splitTime(String timeComponents){
    String[] splittedTimeComponents = timeComponents.split(":");

    for(String timeComponent: splittedTimeComponents){
      this.timeComponents.add(timeComponent);
    }
  }

  /**
   * Split string with date on date components
   *
   * @param dateComponents string with date
   */
  private void splitDate(String dateComponents){
    String[] splittedDateComponents = dateComponents.split("/");

    for(String dateComponent: splittedDateComponents){
      this.dateComponents.add(dateComponent);
    }
  }

  /**
   * Getter for date components
   *
   * @return list with date components
   */
  public List<String> getDateComponents() {
    return dateComponents;
  }

  /**
   * Getter for time components
   *
   * @return list with time components
   */
  public List<String> getTimeComponents() {
    return timeComponents;
  }
}

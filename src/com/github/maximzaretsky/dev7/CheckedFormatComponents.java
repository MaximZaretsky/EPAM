import Checkers.DateComponentChecker;
import Checkers.TimeComponentChecker;
import java.util.ArrayList;
import java.util.List;

/**
 * Get result of check for each component
 */
public class CheckedFormatComponents {
  private List<Boolean> checkedComponents = new ArrayList<>();

  private final int MONTH = 0;
  private final int DAY_OF_MONTH = 1;
  private final int YEAR = 2;

  private final int HOUR = 0;
  private final int MINUTE = 1;
  private final int SECOND = 2;

  /**
   * Add results of check for each  date component in list with checked components
   *
   * @param dataComponents list with date components
   * @param month checker for month
   * @param dayOfMonth checker for day of month
   * @param year checker for year
   */
  public void checkDateComponents(List<String> dataComponents, DateComponentChecker month, DateComponentChecker dayOfMonth, DateComponentChecker year) {
    checkedComponents.add(month.checkValidity(dataComponents.get(MONTH), dataComponents.get(DAY_OF_MONTH), dataComponents.get(YEAR)));
    checkedComponents.add(dayOfMonth.checkValidity(dataComponents.get(MONTH), dataComponents.get(DAY_OF_MONTH), dataComponents.get(YEAR)));
    checkedComponents.add(year.checkValidity(dataComponents.get(MONTH), dataComponents.get(DAY_OF_MONTH), dataComponents.get(YEAR)));
  }

  /**
   * Add results of check for each time component in list with checked components
   *
   * @param timeComponents list with time components
   * @param hour checker for hour
   * @param minute checker for minute
   * @param second checker for second
   */
  public void checkTimeComponents(List<String> timeComponents, TimeComponentChecker hour, TimeComponentChecker minute, TimeComponentChecker second) {
    checkedComponents.add(hour.checkValidity(timeComponents.get(HOUR)));
    checkedComponents.add(minute.checkValidity(timeComponents.get(MINUTE)));
    checkedComponents.add(second.checkValidity(timeComponents.get(SECOND)));
  }

  /**
   * Valid received data and time or not
   *
   * @return valid or not
   */
  public boolean getVerdict() {
    boolean answer = true;

    for (Boolean component: checkedComponents) {
      if (component != true) {
        answer = component;
      }
    }
    return answer;
  }
}

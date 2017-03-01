import Checkers.DateComponentChecker;
import Checkers.TimeComponentChecker;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aramorchi on 01.03.2017.
 */
public class CheckedFormatComponents {
  private List<Boolean> checkedComponents = new ArrayList<>();

  private final int MONTH = 0;
  private final int DAY_OF_MONTH = 1;
  private final int YEAR = 2;

  private final int HOUR = 0;
  private final int MINUTE = 1;
  private final int SECOND = 2;

  public void checkDateComponents(List<String> dataComponents, DateComponentChecker month, DateComponentChecker dayOfMonth, DateComponentChecker year) {
    checkedComponents.add(month.checkValidity(dataComponents.get(MONTH), dataComponents.get(DAY_OF_MONTH), dataComponents.get(YEAR)));
    checkedComponents.add(dayOfMonth.checkValidity(dataComponents.get(MONTH), dataComponents.get(DAY_OF_MONTH), dataComponents.get(YEAR)));
    checkedComponents.add(year.checkValidity(dataComponents.get(MONTH), dataComponents.get(DAY_OF_MONTH), dataComponents.get(YEAR)));
  }

  public void checkTimeComponents(List<String> timeComponents, TimeComponentChecker hour, TimeComponentChecker minute, TimeComponentChecker second) {
    checkedComponents.add(hour.checkValidity(timeComponents.get(HOUR)));
    checkedComponents.add(minute.checkValidity(timeComponents.get(MINUTE)));
    checkedComponents.add(second.checkValidity(timeComponents.get(SECOND)));
  }

  public boolean getVerdict() {
    boolean answer = true;

    for (Boolean component: checkedComponents) {
      answer = component;
    }

    return answer;
  }
}

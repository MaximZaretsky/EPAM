import Components.*;
import java.util.*;

public class Factory{
  public FormatComponents getComponent(String componentString, Calendar calendar) {
    FormatComponents component = null;
    if (componentString.startsWith("f") || componentString.startsWith("F")) {
      component = new Milliseconds(componentString, calendar);
    } else if (componentString.startsWith("d")) {
        component = new Days(componentString, calendar);
    } else if (componentString.startsWith("m")) {
        component = new Minutes(componentString, calendar);
    } else if (componentString.startsWith("y") || componentString.startsWith("g")) {
        component = new Years(componentString, calendar);
    } else if (componentString.startsWith("s")) {
        component = new Seconds(componentString, calendar);
    } else if (componentString.startsWith("h") || componentString.startsWith("H") || componentString.startsWith("K")
               || componentString.startsWith("t") || componentString.startsWith("z")) {
        component = new Hours(componentString, calendar);
    } else if (componentString.startsWith("M")) {
        component = new Months(componentString, calendar);
    }
    return component;
  }

}

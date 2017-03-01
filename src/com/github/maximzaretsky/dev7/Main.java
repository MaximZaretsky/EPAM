import Checkers.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Splitter splitter = new Splitter();
    InputChecker inputChecker = new InputChecker();

    String inputComponents = in.nextLine();
    while (!inputChecker.correctInput(inputComponents)) {
      System.out.println("Please, enter correct!");
      inputComponents = in.nextLine();
    }
    splitter.splitOnComponents(inputComponents);

    CheckedFormatComponents checkedFormatComponents = new CheckedFormatComponents();

    MonthChecker monthChecker = new MonthChecker();
    DayOfMonthChecker dayOfMonthChecker = new DayOfMonthChecker();
    YearChecker yearChecker = new YearChecker();

    checkedFormatComponents.checkDateComponents(splitter.getDateComponents(), monthChecker, dayOfMonthChecker, yearChecker);

    HourChecker hourChecker = new HourChecker();
    MinuteChecker minuteChecker = new MinuteChecker();
    SecondsChecker secondsChecker = new SecondsChecker();

    checkedFormatComponents.checkTimeComponents(splitter.getTimeComponents(), hourChecker, minuteChecker, secondsChecker);

    Outputter outputter = new Outputter();
    outputter.defineMessageForOutput(checkedFormatComponents.getVerdict());
  }
}

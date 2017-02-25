import java.util.*;

public class Main {
  public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    Factory factory = new Factory();
    Checker checker = new Checker();
    Scanner in = new Scanner(System.in);

    System.out.println("Please, enter necessary parts of date, split their by whitespace");
    String formatInformation = in.nextLine();

    while (!checker.check(formatInformation)) {
      System.out.println("Please, input correct format!");
      formatInformation = in.nextLine();
    }

    Splitter splitter = new Splitter(formatInformation);
    InputComponents inputComponents = new InputComponents();
    List<String> splittedInputInformation = splitter.getSplittedInputString();

    for(String splittedWord: splittedInputInformation) {
      inputComponents.addComponent(factory.getComponent(splittedWord, calendar));
    }

    inputComponents.printComponents();
  }
}

import java.util.Scanner;

/**
 * Created by Aramorchi on 18.02.2017.
 */
public class Main {

  public static void main(String[] args) {

    /**
     * @param REQUIRED_NUMBERS_OF_ENTER contain necessary number of enter , after which
     *        you may stop program, if you need
     * @param timesWasEntered contain number of times, when you entered text
     */
    final int REQUIRED_NUMBERS_OF_ENTER = 3;
    int timesWasEntered = 0;
    boolean timeToStopEnter = false;

    Scanner in = new Scanner(System.in);
    TextProcessor handler = new TextProcessor();
    FrequencyOfLettersPairs frequencyOfLettersPairs = new FrequencyOfLettersPairs();
    IsLongerThanFiveLetters isLongerThanFiveLetters = new IsLongerThanFiveLetters();
    OperationsList operationsList = new OperationsList();

    operationsList.addOperation(frequencyOfLettersPairs);
    operationsList.addOperation(isLongerThanFiveLetters);

    System.out.println("Enter text at least 3 times. Enter 'break', if you want stop entry");
    while (!timeToStopEnter) {
      String inputText = in.nextLine();

      if (!inputText.equals("break")) {
      handler.handleInputText(inputText);

      operationsList.doOperations(handler.getClearText());
      operationsList.printResultsOfOperations();

      timesWasEntered++;
      } else if (inputText.equals("break") && timesWasEntered < REQUIRED_NUMBERS_OF_ENTER) {
        System.out.println("We need more text! At least " + (REQUIRED_NUMBERS_OF_ENTER - timesWasEntered) + "times");
        continue;
      } else {
        timeToStopEnter = true;
      }
    }
  }
}

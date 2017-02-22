/**
 * Created by Maxim Zaretsky on 18.02.2017.
 * @author Maxim Zaretsky
 */

import java.util.Scanner;

public class Main {

  /**
   * Entry point of program
   */
  public static void main(String[] args) {
    final int REQUIRED_NUMBERS_OF_ENTER = 3; // How many times we should enter text, before we can stop program
    int timesWasEntered = 0; // Store the value of how many times we entered text
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
      handler.extractInputWords(inputText);

      operationsList.doOperations(handler.getClearText());
      operationsList.printResultsOfOperations();

      timesWasEntered++;
      } else if (inputText.equals("break") && timesWasEntered < REQUIRED_NUMBERS_OF_ENTER) {
        System.out.println("We need more text! At least " + (REQUIRED_NUMBERS_OF_ENTER - timesWasEntered) + " times");
        continue;
      } else {
        timeToStopEnter = true;
      }
    }
  }
}

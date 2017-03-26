import java.util.Scanner;

/**
 * Contain entry point of program
 */
public class Main {

  /**
   * Entry point of program
   */
  public static void main(String[] args) {
    try {
      Scanner in = new Scanner(System.in);

      TypeOfInputData colorOfChequer = TypeOfInputData.COLOR;
      TypeOfInputData startCoordinates = TypeOfInputData.START_POSITION;
      TypeOfInputData necessaryCoordinates = TypeOfInputData.NECESSARY_POSITION;

      Inputer inputer = new Inputer();

      String color = inputer.inputChequerData(colorOfChequer, in);
      String startPosition = inputer.inputChequerData(startCoordinates, in);
      String necessaryPosition = inputer.inputChequerData(necessaryCoordinates, in);

      Chequer chequer = new Chequer(color, startPosition, necessaryPosition);
      System.out.println(chequer.findOutNumberOfSteps());
    } catch (Exception e) {
      System.out.println("Something going wrong :(");
    }
  }
}



import java.util.List;
import java.util.Scanner;

/**
 * Contain entry point of program
 */
public class Main {

  /**
   * Entry point of program
   */
  public static void main(String[] args) {
    Scanner in  = new Scanner(System.in);
    Chequer chequer = new Chequer();
    PositionChecker positionChecker = new PositionChecker();

    String colorOfChequer;

    boolean correctInput = false;
    while (!correctInput) {
      System.out.println("Enter correct color of your chequer: ");
      colorOfChequer = in.next();

      if(colorOfChequer.equalsIgnoreCase("white")) {
        chequer.setColor(ColorOfChequer.WHITE);
        correctInput = true;
        } else if(colorOfChequer.equalsIgnoreCase("black")) {
        chequer.setColor(ColorOfChequer.BLACK);
        correctInput = true;
        } else {
        correctInput = false;
      }
    }

    String startCoordinates;

    correctInput = false;
    while (!correctInput) {
      System.out.println("Enter correct coordinates of your chequer: ");
      startCoordinates = in.next();

      if(positionChecker.checkSyntaxValidityOfInputField(startCoordinates)) {
        Splitter splitter = new Splitter();
        List<Integer> fieldCoordinates = splitter.split(startCoordinates);

        if(positionChecker.checkPositionValidity(fieldCoordinates)) {
          chequer.setStartPosition(fieldCoordinates);
          correctInput = true;
        } else {
          correctInput = false;
        }
      } else {
        correctInput = false;
      }
    }

    String necessaryCoordinates;

    correctInput = false;
    while (!correctInput) {
      System.out.println("Enter correct coordinates of necessary position: ");
      necessaryCoordinates = in.next();

      if(positionChecker.checkSyntaxValidityOfInputField(necessaryCoordinates)) {
        Splitter splitter = new Splitter();
        List<Integer> fieldCoordinates = splitter.split(necessaryCoordinates);

        if(positionChecker.checkPositionValidity(fieldCoordinates)) {
          chequer.setNecessaryPosition(fieldCoordinates);
          correctInput = true;
        } else {
          correctInput = false;
        }
      } else {
        correctInput = false;
      }
    }

    boolean possibilityOfReach = positionChecker.checkPossibilityToTurnUpIntoNecessaryField(chequer.getColor(), chequer.getStartPosition(), chequer.getNecessaryPosition());

    if (possibilityOfReach) {
      Algorithm algorithm = new Algorithm();
      int answer = algorithm.defineMethodForExecution(chequer.getColor(), chequer.getStartPosition(), chequer.getNecessaryPosition());
      System.out.println("Number of moves to reach necessary position: " + answer);
    } else {
      System.out.println("It's impossible");
    }
  }
}

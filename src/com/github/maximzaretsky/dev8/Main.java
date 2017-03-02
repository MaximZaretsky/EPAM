import java.util.Scanner;

/**
 * Contain entry point of program
 */
public class Main {

  /**
   * Entry point of program
   */
  public static void main(String[] args) {
    Checker checker = new Checker();
    Scanner in = new Scanner(System.in);

    System.out.println("Enter number of rows of first matrix");
    int rows = in.nextInt();

    System.out.println("Enter number of columns of first matrix");
    int columns = in.nextInt();

    while (!checker.checkRowsAndColumnsValues(rows, columns)) {
      System.out.println("Not correct values!");

      System.out.println("Enter number of rows of first matrix");
      rows = in.nextInt();

      System.out.println("Enter number of columns of first matrix");
      columns = in.nextInt();
    }

    System.out.println("Enter number of rows of second matrix");
    int secondRows = in.nextInt();
    System.out.println("Enter number of columns of second matrix");
    int secondColumns = in.nextInt();

    while (!checker.checkRowsAndColumnsValues(secondRows, secondColumns)) {
      System.out.println("Not correct values!");

      System.out.println("Enter number of rows of second matrix");
      secondRows = in.nextInt();

      System.out.println("Enter number of columns of second matrix");
      secondColumns = in.nextInt();
    }

    if (checker.checkPossibilityOfMultyplyingOfMatrixes(columns, secondRows)) {
      Matrix matrixOne = new Matrix(rows, columns);
      System.out.println("Enter numbers of first matrix");
      matrixOne.setMatrix(in);

      Matrix matrixTwo = new Matrix(secondRows, secondColumns);
      System.out.println("Enter numbers of second matrix");
      matrixTwo.setMatrix(in);

      MatrixOperations matrixOperations = new MatrixOperations();
      Matrix result = matrixOperations.multiply(matrixOne, matrixTwo);
      System.out.println("Result matrix: ");
      result.printMatrix();
    } else {
      System.out.println("Not valid sizes of matrixes!");
    }

  }
}

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Contain matrix and methods for work with her fields
 */
public class Matrix {
  private BigDecimal[][] matrix;

  /**
   * Create matrix with receive parameters
   *
   * @param rows number of rows
   * @param cols number of columns
   */
  public Matrix(int rows, int cols) {
    matrix = new BigDecimal[rows][cols];
  }

  /**
   * Set element in received position
   * @param row number of row
   * @param column number of column
   * @param value value for this position
   */
  public void setElement(int row, int column, BigDecimal value) {
    matrix[row][column] = value;
  }

  /**
   * Return value of element of necessary position
   *
   * @param row number of row
   * @param column number of column
   * @return value of element in necessary position
   */
  public BigDecimal getElement(int row, int column) {
    return matrix[row][column];
  }

  /**
   * Return amount of rows in matrix
   *
   * @return amount of rows
   */
  public int getRowsNum() {
    return matrix.length;
  }

  /**
   * Return amount of columns in matrix
   *
   * @return amount of columns
   */
  public int getColumnsNum() {
    return matrix[0].length;
  }

  /**
   * Method for initializing of all matrix
   *
   * @param scanner Scanner, necessary for getting value of elements from user
   */
  public void setMatrix(Scanner scanner) {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++){
        matrix[row][col] = scanner.nextBigDecimal();
      }
    }
  }

  /**
   * Print matrix in correct form
   */
  public void printMatrix() {
    for (int row = 0; row < matrix.length; row++) {
      System.out.print("\n");
      for (int col = 0; col < matrix[row].length; col++){
        System.out.print(matrix[row][col] + " ");
      }
    }
  }

}
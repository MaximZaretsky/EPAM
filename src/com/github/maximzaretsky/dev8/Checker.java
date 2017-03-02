/**
 * Check validity of received parameters of matrix
 */
public class Checker {

  /**
   * Check possibility of multiplying two matrices
   *
   * @param numberOfColumnsOfMatrixOne number of columns of first matrix
   * @param numberOfRowsOfMatrixTwo number of rows of second matrix
   * @return possible multiplying or not
   */
  public boolean checkPossibilityOfMultyplyingOfMatrixes(int numberOfColumnsOfMatrixOne, int numberOfRowsOfMatrixTwo) {
    boolean answer;

    if (numberOfColumnsOfMatrixOne == numberOfRowsOfMatrixTwo) {
      answer = true;
    } else {
        answer = false;
    }

    return answer;
  }

  /**
   * Check possibility of creation matrix with received parameters
   *
   * @param rowsValue received value of rows
   * @param colsValue received value of columns
   * @return possible creation or not
   */
  public boolean checkRowsAndColumnsValues(Object rowsValue, Object colsValue) {
    boolean answer;

    if (rowsValue instanceof Integer && colsValue instanceof Integer) {
      int rows = (int)rowsValue;
      int cols = (int)colsValue;

      if (rows < 1 || cols < 1) {
        answer = false;
      } else {
        answer = true;
      }
    } else {
      answer = false;
    }
    return answer;
  }
}

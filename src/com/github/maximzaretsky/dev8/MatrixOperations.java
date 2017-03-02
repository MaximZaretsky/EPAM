/**
 * Contain operations for work with matrices
 */
public class MatrixOperations {

  /**
   * Multiply two received matrices
   *
   * @param firstMatrix first received matrix
   * @param secondMatrix second received matrix
   * @return matrix which we get in result of multiplying
   */
  public Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) {

    int firstRows = firstMatrix.getRowsNum();
    int firstCols = firstMatrix.getColumnsNum();

    int secondRows = secondMatrix.getRowsNum();
    int secondCols = secondMatrix.getColumnsNum();

    Matrix result = new Matrix(firstRows, secondCols);

    for (int thisRow = 0; thisRow < firstRows; ++thisRow)
      for (int otherCol = 0; otherCol < secondCols; ++otherCol){
        for (int thisCol = 0; thisCol < firstCols; ++thisCol) {
          result.setElement(thisRow, otherCol, firstMatrix.getElement(thisRow, thisCol).multiply(secondMatrix.getElement(thisCol, otherCol)));
        }
      }
    return result;
  }
}

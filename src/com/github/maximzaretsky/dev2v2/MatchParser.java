package com.github.maximzaretsky.dev2v2;

import com.github.maximzaretsky.dev2v2.Result;
import java.math.*;

public class MatchParser {
  
  private final char PLUS = '+';
  private final char MINUS = '-';
  private final char DIVIDE = '/';
  private final char MULTIPLY = '*';
  private final char LEFT_BRACKET = '(';
  private final char RIGHT_BRACKET = ')';
  private final char DOT = '.';
  
  public BigDecimal Parse(String expression) throws Exception {
    Result result = PlusMinus(expression);
    if (!result.getRest().isEmpty()) {
      System.err.println("Error: can't full parse");
      System.err.println("rest: " + result.getRest());
    }
    return result.getAcc();
  }
  
  /** 
   * This method calculate operations of additions and subtraction,
   * which were not treated by method MulDiv
   */
  private Result PlusMinus(String expression) throws Exception {
    Result current = MulDiv(expression);
    BigDecimal acc = current.getAcc();

    while (current.getRest().length() > 0) {
      if (!(current.getRest().charAt(0) == PLUS || current.getRest().charAt(0) == MINUS)) {
        break;
      }
      char sign = current.getRest().charAt(0);
      String next = current.getRest().substring(1);

      current = MulDiv(next);
      if (sign == PLUS) {
        acc = current.getAcc().add(acc);
      } else {
          acc = current.getAcc().negate().add(acc);
        }
    }
    return new Result(acc, current.getRest());
  }
  
  /** 
   * This method calculate operations of multiplying and dividing,
   * which were not treated by method Bracket
   */
  private Result MulDiv(String expression) throws Exception {
    Result current = Bracket(expression);

    BigDecimal acc = current.getAcc();
    while (true) {
      if (current.getRest().length() == 0) {
        return current;
      }
      char sign = current.getRest().charAt(0);
      if ((sign != MULTIPLY && sign != DIVIDE)) {
        return current;
      }
      String next = current.getRest().substring(1);
      Result right = Bracket(next);

      if (sign == MULTIPLY) {
        acc = acc.multiply(right.getAcc(), MathContext.DECIMAL32);
      } else {
          acc = acc.divide(right.getAcc(), 10, RoundingMode.HALF_UP);
        }

      current = new Result(acc, right.getRest());
    }
  }
  
  /** 
   * This method realize brackets, define,
   * was bracket closed or not
   */
  private Result Bracket(String expression) throws Exception {
    char zeroChar = expression.charAt(0);
    if (zeroChar == LEFT_BRACKET) {
      Result result = PlusMinus(expression.substring(1));
      if (!result.getRest().isEmpty() && result.getRest().charAt(0) == RIGHT_BRACKET) { // check, was bracket closed, or not
        result.setRest(result.getRest().substring(1));
      } else {
          System.err.println("Error: not close bracket");
        }
      return result;
    }
    return Num(expression);
  }
  
  /** 
   * This method isolates numbers
   * from given string, which contains expression,
   * converts this numbers into BigDecimal format.
   * Also, this method define, was string empty or not
   * @param dot_cnt counts the number of dots in number 
   * @param dPart convert our number from String to double
   * @param bdPart convert number from double to BigDecimal
   */
  private Result Num(String expression) throws Exception {
    int i = 0;
    int dot_cnt = 0;
    boolean negative = false;

    if ( expression.charAt(0) == MINUS ) {
      negative = true;
      expression = expression.substring( 1 );
    }

    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == DOT)) {
      if (expression.charAt(i) == DOT && ++dot_cnt > 1) {
        throw new Exception("not valid number '" + expression.substring(0, i + 1) + "'");
      }
      i++;
    }
    if ( i == 0 ) { 
      throw new Exception( "can't get valid number in '" + expression + "'" );
    }

    double dPart = Double.parseDouble(expression.substring(0, i));
    if ( negative ) {
      dPart = -dPart;
    }
    String restPart = expression.substring(i);
    BigDecimal bdPart = new BigDecimal(dPart);

    return new Result(bdPart, restPart);
  }
}
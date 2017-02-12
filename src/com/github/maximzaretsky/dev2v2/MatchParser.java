package com.github.maximzaretsky.dev2v2;

import com.github.maximzaretsky.dev2v2.Result;
import java.math.*;

public class MatchParser {
  
  public BigDecimal Parse(String s) throws Exception {
    Result result = PlusMinus(s);
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
  private Result PlusMinus(String s) throws Exception {
    Result current = MulDiv(s);
    BigDecimal acc = current.getAcc();

	while (current.getRest().length() > 0) {
      if (!(current.getRest().charAt(0) == '+' || current.getRest().charAt(0) == '-')) {
        break;
      }
      char sign = current.getRest().charAt(0);
      String next = current.getRest().substring(1);

	  current = MulDiv(next);
      if (sign == '+') {
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
  private Result MulDiv(String s) throws Exception {
    Result current = Bracket(s);

    BigDecimal acc = current.getAcc();
    while (true) {
      if (current.getRest().length() == 0) {
        return current;
      }
      char sign = current.getRest().charAt(0);
      if ((sign != '*' && sign != '/')) {
        return current;
      }
      String next = current.getRest().substring(1);
      Result right = Bracket(next);

      if (sign == '*') {
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
  private Result Bracket(String s) throws Exception {
    char zeroChar = s.charAt(0);
    if (zeroChar == '(') {
      Result r = PlusMinus(s.substring(1));
      if (!r.getRest().isEmpty() && r.getRest().charAt(0) == ')') {
        r.setRest(r.getRest().substring(1));
      } else {
          System.err.println("Error: not close bracket");
        }
      return r;
    }
    return Num(s);
  }
  
  /** 
   * This method isolates numbers
   * from given string, which contains expression,
   * converts this numbers into BigDecimal format.
   * Also, this method define, was string empty or not
   */
  private Result Num(String s) throws Exception {
    int i = 0;
    int dot_cnt = 0;
    boolean negative = false;
	
    if ( s.charAt(0) == '-' ) {
      negative = true;
      s = s.substring( 1 );
    }

    while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
      if (s.charAt(i) == '.' && ++dot_cnt > 1) {
        throw new Exception("not valid number '" + s.substring(0, i + 1) + "'");
      }
      i++;
    }
    if ( i == 0 ) { 
      throw new Exception( "can't get valid number in '" + s + "'" );
    }

    double dPart = Double.parseDouble(s.substring(0, i));
    if ( negative ) {
      dPart = -dPart;
    }
    String restPart = s.substring(i);
    BigDecimal bdPart = new BigDecimal(dPart);

    return new Result(bdPart, restPart);
  }
}
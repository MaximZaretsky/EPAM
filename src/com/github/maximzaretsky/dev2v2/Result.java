package com.github.maximzaretsky.dev2v2;

import java.math.BigDecimal;

/**
 * This class contain the result of
 * evaluating the treated part of the expression
 * and the rest of expression
 */
 
public class Result {
  private BigDecimal acc;
  private String rest;

  public Result (BigDecimal acc, String rest) {
    this.acc = acc;
    this.rest = rest;
  }
  
  public BigDecimal getAcc () {
	return acc;
  }

  public void setAcc (BigDecimal acc) {
    this.acc = acc;
  }

  public String getRest () {
    return rest;
  }

  public void setRest (String rest) {
    this.rest = rest;
  }	
}
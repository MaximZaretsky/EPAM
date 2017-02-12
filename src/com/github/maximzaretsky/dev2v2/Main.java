package com.github.maximzaretsky.dev2v2;

import java.util.*;
import com.github.maximzaretsky.dev2v2.MatchParser;

public class Main {
  public static void main(String[] args) {
	String formulas = "";
    MatchParser p = new MatchParser();	
	if (args.length == 0) {
      System.out.println("Enter your expression:");		
	  Scanner scan = new Scanner(System.in);  
      formulas = scan.next();
	} else {
		for (int count = 0; count < args.length; count++) {
			formulas += args[count];
	    }
	  }
    try {
      System.out.println( formulas + "=" + p.Parse(formulas) );
    } catch(Exception e) {
        System.err.println( "Error while parsing '"+ formulas +"' with message: " + e.getMessage() );
      } 
  }
}	
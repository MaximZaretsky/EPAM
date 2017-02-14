package com.github.maximzaretsky.dev2v2;

import java.util.*;
import com.github.maximzaretsky.dev2v2.MatchParser;

public class Main {
  public static void main(String[] args) {
    String expression = "";
    MatchParser parser = new MatchParser();
    if (args.length == 0) {
      System.out.println("Enter your expression:");
      Scanner scan = new Scanner(System.in);  
      expression = scan.next();
    } else {
        for (int count = 0; count < args.length; count++) {
          expression += args[count];
        }
      }
    try {
      System.out.println( expression + "=" + parser.Parse(expression) );
    } catch(Exception e) {
        System.err.println( "Error while parsing '"+ expression +"' with message: " + e.getMessage() );
      } 
  }
}
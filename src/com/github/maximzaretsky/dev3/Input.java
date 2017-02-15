package com.github.maximzaretsky.dev3;

import java.util.*;

public class Input {
  private List<String> userInformation = new ArrayList<>();
  private Scanner in = new Scanner(System.in);
  
  public void readInput() {
    while (true) {
      String inputInformation = in.nextLine();
      if (!inputInformation.equals("break")){ // TODO: split on two methods
        userInformation.add(inputInformation);
      } else {
          break;
      }
    }
  }
  
  public List<String> getUserInformation() {
    return userInformation;
  }
}
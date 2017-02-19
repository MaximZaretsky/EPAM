package com.github.maximzaretsky.dev3;

import java.util.*;

public class AverageUserAge {
  private int averageAge;
  private List<Integer> agesOfUsers = new ArrayList<>();
  
  public AverageUserAge(List<Integer> agesOfUsers) {
    this.agesOfUsers = agesOfUsers;
  }
  
  /**
   * This method for founding
   * average age of users
   * @param averageAge contain average age of user,
   * rounding into less side
   */
  public int foundAverageAge() {
    Integer[] ages = convertToArray(agesOfUsers);
    for (int i = 0; i < ages.length; i++) {
      averageAge += ages[i];
    }
    averageAge /= ages.length;
    
    return averageAge;
  }
  
  /**
   * This method return ages of user,
   * converted to array
   */
  private Integer[] convertToArray(List<Integer> agesOfUsers) {
    Integer[] convertedArray = new Integer[agesOfUsers.size()];
    convertedArray = agesOfUsers.toArray(convertedArray);
    
    return convertedArray;
  }
  
}
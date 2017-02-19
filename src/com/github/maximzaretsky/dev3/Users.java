package com.github.maximzaretsky.dev3;

import java.util.*;

public class Users {
  private List<String> namesOfUsers = new ArrayList<>();
  private List<String> surnamesOfUsers = new ArrayList<>();
  private List<Boolean> gendersOfUsers = new ArrayList<>();
  private List<Integer> agesOfUsers = new ArrayList<>();
  
  public void extractFields(List<String> users) {
    for (int i = 0; i < users.size(); i++) {
      splitOnBlocks(users.get(i));
    }
  }
  
  /**
   * This method convert to boolean type
   * gender of user
   */
  private void convertToGenderType(String genderData) {
    if (genderData.equals("male")) {
      gendersOfUsers.add(true);
    } else if (genderData.equals("female")) {
        gendersOfUsers.add(false);
    } 
  }
  
  /**
   * This method split user information,
   * convert them to String array
   */
  private void splitOnBlocks(String user) {
    setFields(user.split(","));
  }
  
  /**
   * Add users information into lists of
   * users parameters
   */
  private void setFields(String[] userInformation) {
    namesOfUsers.add(userInformation[0]);
    surnamesOfUsers.add(userInformation[1]);
    convertToGenderType(userInformation[2]);
    convertToAgeType(userInformation[3]);
  }
  
  private void convertToAgeType(String ageData) {
    agesOfUsers.add(Integer.parseInt(ageData));
  }
  
  public List<String> getNames() {
    return namesOfUsers;
  }
  
  public List<String> getSurnames() {
    return surnamesOfUsers;
  }
  
  public List<Boolean> getGenders() {
    return gendersOfUsers;
  }
  
  public List<Integer> getAges() {
    return agesOfUsers;
  }
  
  public void printAllFields() {
    System.out.println(namesOfUsers);
    System.out.println(surnamesOfUsers);
    System.out.println(gendersOfUsers);
    System.out.println(agesOfUsers);
  }
}
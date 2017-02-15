package com.github.maximzaretsky.dev3;

import com.github.maximzaretsky.dev3.Input;
import com.github.maximzaretsky.dev3.Users;

public class Main {
  public static void main(String[] args) {
    System.out.println("Enter users information in format 'Name,Surname,Gender,age'");
    System.out.println("Enter 'break', if you entered all users");
    
    Input input = new Input();
    Users users = new Users();
    
    input.readInput();
    
    users.extractFields(input.getUserInformation());
    users.printAllFields();
  }
}
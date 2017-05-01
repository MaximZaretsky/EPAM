package Microframework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aramorchi on 01.05.2017.
 */
public class CommandsReader {

  private List<String> commandsExtractedFromFile = new ArrayList<>();

  public List<String> getCommandsExtractedFromFile() {
    String commandString;
    try (BufferedReader reader = new BufferedReader(new FileReader("instructions.txt"))) {
      while ((commandString = reader.readLine()) != null) {
        commandsExtractedFromFile.add(commandString);
      }
    } catch (IOException ex) {
      System.out.println("Not found file");
    }
    for (String command: commandsExtractedFromFile) {
      System.out.println(command);
    }
    return commandsExtractedFromFile;
  }

}

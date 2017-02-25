import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aramorchi on 25.02.2017.
 */
public class Splitter {
  private List<String> splittedInputString = new ArrayList<>();

  public Splitter(String inputString){
    split(inputString);
  }

  private void split(String stringForSplitting){
    String[] splitted = stringForSplitting.split(" ");

    for (String splitWords: splitted) {
      splittedInputString.add(splitWords);
    }
  }

  public List<String> getSplittedInputString(){
    return splittedInputString;
  }
}

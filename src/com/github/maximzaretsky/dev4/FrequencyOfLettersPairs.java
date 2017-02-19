import java.math.BigDecimal;
import java.util.*;

public class FrequencyOfLettersPairs implements Operations {
  private List<String> pairsOfLetters = new ArrayList<>();
  private Set<String> uniquePairsOfLetters = new HashSet<>();
  private Map<String, Integer> amountOfPairInText = new HashMap<>();
  private List<String> words = new ArrayList<>();

  public void doOperation(List<String> text){
    this.words = text;
    splitOnPairs();
    howOftenIsMeets();
  }

  public void printResult() {
    Set<String> keys = amountOfPairInText.keySet();
    BigDecimal amountOfPairs = BigDecimal.valueOf(pairsOfLetters.size());
    for (String key: keys){
      BigDecimal valueOfKey = BigDecimal.valueOf(amountOfPairInText.get(key));
      BigDecimal frequency = valueOfKey.divide(amountOfPairs, 5, BigDecimal.ROUND_HALF_UP);
      System.out.println("Frequency of this pair: '" + key +"' in all pairs are: " + frequency);
    }
  }

  /**
   *
   *
   */
  private void splitOnPairs(){
    for(String word: words){
      for(int i = 0; i < word.length() - 1; i++){
        pairsOfLetters.add(word.substring(i, i+2));
      }
    }
  }

  private void howOftenIsMeets(){
    for (String pairs: pairsOfLetters){
      uniquePairsOfLetters.add(pairs);
    }

    for (String uniquePair: uniquePairsOfLetters){
      int amount= 0;
      for (String pairs: pairsOfLetters){
        if (uniquePair.contains(pairs)){
          amount++;
        }
      }
      amountOfPairInText.put(uniquePair, amount);
    }
  }
}

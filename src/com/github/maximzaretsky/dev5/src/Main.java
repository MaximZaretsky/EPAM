import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  /**
   * Entry point of program
   */
  public static void main(String[] args) {
    final int MAXIMAL_PRODUCTIVITY = 1;
    final int MINIMAL_COST = 2;
    final int MINIMUM_OF_NOT_JUNIOR = 3;

    Scanner in = new Scanner(System.in);
    List<Programmer> programmers = new ArrayList<>();
    List<Qualification> team = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      Junior junior = new Junior();
      programmers.add(junior);
    }
    for (int i = 10; i < 20; i++) {
      Middle middle = new Middle();
      programmers.add(middle);
    }
    for (int i = 20; i < 30; i++) {
      Senior senior = new Senior();
      programmers.add(senior);
    }
    for (int i = 30; i < 40; i++) {
      Lead lead = new Lead();
      programmers.add(lead);
    }

    System.out.println("Enter number of main criterion for development your program: \n"
                      + "1.Maximal productivity within budget \n"
                      + "2.Minimal cost within productivity \n"
                      + "3.Minimal quantity of programmer higher, than Junior within productivity \n");

    int criterion = in.nextInt();

    if (criterion == MAXIMAL_PRODUCTIVITY) {
      MaximalProductivity maximalProductivity = new MaximalProductivity();
      System.out.println("Enter your budget: ");
      System.out.println(maximalProductivity.findMaximalProductivity(in.nextInt(), programmers, team));
    } else if (criterion == MINIMAL_COST) {
        System.out.println("Enter your budget: ");
        int budget = in.nextInt();

        System.out.println("Enter necessary productivity: ");
        int productivity = in.nextInt();

        MinimalCost minimalCost = new MinimalCost();
        //minimalCost.findMinimalCost(budget, productivity, programmers, team);
    } else if (criterion == MINIMUM_OF_NOT_JUNIOR) {
        System.out.println("Enter your budget: ");
        int budget = in.nextInt();

        System.out.println("Enter necessary productivity: ");
        int productivity = in.nextInt();

        MinimumOfNotJunior minimumOfNotJunior = new MinimumOfNotJunior();
        //minimumOfNotJunior.findMinimumOfNotJunior(budget, productivity, programmers, team);
    } else {
        System.out.println("Was entered wrong number of criterion!");
    }
  }
}

import java.util.List;

/**
 * Find maximal productivity team within received budget of customer
 */
public class MaximalProductivity {

  /**
   *
   * @param budget received budget from customer
   * @param programmers type of programmers in company
   * @param team void list for adding programmers
   * @return team of programmers
   */
  public List<Qualification> findMaximalProductivity(int budget, List<Programmer> programmers, List<Qualification> team) {
    int maximum = 0;
    int sawedBudget = 0;

    while(sawedBudget < budget) {
      for (int i = 1; i < programmers.size(); i++) {
        if (programmers.get(i).getProductivity() > programmers.get(maximum).getProductivity() &&  budget >= (sawedBudget + programmers.get(i).getSalary())) {
          maximum = i;
        }
      }
      sawedBudget += programmers.get(maximum).getSalary();
      team.add(programmers.get(maximum).getQualification());
    }
    return team;
  }
}

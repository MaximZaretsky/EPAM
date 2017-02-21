/**
 * Realization of Senior Programmer
 */
public class Senior implements Programmer {
  private Qualification SENIOR = Qualification.SENIOR;
  private int salary = 4000;
  private int productivity = 30;

  /**
   * @return salary of Senior
   */
  public int getSalary() {
    return salary;
  }

  /**
   * @return productivity of Senior
   */
  public int getProductivity() {
    return productivity;
  }

  /**
   * @return qualification of Senior
   */
  public Qualification getQualification() {
    return SENIOR;
  }
}

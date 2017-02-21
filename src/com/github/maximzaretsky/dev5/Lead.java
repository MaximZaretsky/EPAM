/**
 * Realization of Lead Programmer
 */
public class Lead implements Programmer {
  private Qualification LEAD = Qualification.LEAD;
  private int salary = 5000;
  private int productivity = 40;

  /**
   * @return salary of Lead
   */
  public int getSalary() {
    return salary;
  }

  /**
   * @return productivity of Lead
   */
  public int getProductivity() {
    return productivity;
  }

  /**
   * @return qualification of Lead
   */
  public Qualification getQualification() {
    return LEAD;
  }
}

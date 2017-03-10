package ProductOperations;

/**
 * Our product, which has ID, name and quantity
 */
public class Product {

  private int productID;
  private String productName;
  private int quantity;

  /**
   * Return product ID
   *
   * @return product Id
   */
  public int getProductID(){
    return productID;
  }

  /**
   * Return product name
   *
   * @return product name
   */
  public String getProductName(){
    return productName;
  }

  /**
   * Return quantity of product
   *
   * @return quantity
   */
  public int getQuantity(){
    return quantity;
  }

  /**
   * Set product ID
   *
   * @param productID product ID
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * Set product name
   *
   * @param productName product name
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * Set quantity of product
   *
   * @param quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}

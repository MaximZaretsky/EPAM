package ProductOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductOperations.Order which has ID, name of shopper, email of shopper,
 * list of products and status of order
 */
public class Order {
  private int orderID;
  private String shopperName;
  private String shopperEmail;
  private List<Product> contents = new ArrayList<>();
  private boolean orderComleted;

  /**
   * Return ID of order
   *
   * @return ID of order
   */
  public int getOrderID() {
    return orderID;
  }

  /**
   * Return email of shopper
   *
   * @return email of shopper
   */
  public String getShopperEmail() {
    return shopperEmail;
  }

  /**
   * Return name of shopper
   *
   * @return name of shopper
   */
  public String getShopperName() {
    return shopperName;
  }

  /**
   * Return list of products
   *
   * @return list of products
   */
  public List<Product> getContents() {
    return contents;
  }

  /**
   * Return status of order
   *
   * @return true or false
   */
  public boolean isOrderComleted() {
    return orderComleted;
  }

  /**
   * Set status of order
   *
   * @param orderComleted status of order
   */
  public void setOrderComleted(boolean orderComleted) {
    this.orderComleted = orderComleted;
  }

  /**
   * Set ID of order
   *
   * @param orderID ID of order
   */
  public void setOrderID(int orderID) {
    this.orderID = orderID;
  }

  /**
   * Set name of shopper
   *
   * @param shopperName name of shopper
   */
  public void setShopperName(String shopperName) {
    this.shopperName = shopperName;
  }

  /**
   * Set email of shopper
   *
   * @param shopperEmail name of shopper
   */
  public void setShopperEmail(String shopperEmail) {
    this.shopperEmail = shopperEmail;
  }

  /**
   * Set list of products
   *
   * @param contents list of products
   */
  public void setContents(List<Product> contents) {
    this.contents = contents;
  }
}

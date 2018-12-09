/**
 * @author Gregorio Lozada
 *
 * Sept 29, 2018
 *
 * Updated Oct 27, 2018: Implements comparable as well as define its compareTo method
 *
 * Product: An abstract class that implements the interface Item. Its constructor takes in a string
 * called name and initializes its private fields. Product also defines the methods in the Item
 * interface and overrides Object's toString method.
 *
 * Instructions to create this class were provided by Oracle Academy
 */

import java.util.Date;

public abstract class Product implements Item, Comparable<Product> {

  /**
   * Product serial number
   */
  private int serialNumber;

  /**
   * Product manufacturer
   */
  private String manufacturer;

  /**
   * Date product was manufactured on
   */
  private Date manufacturedOn;

  /**
   * Name of product
   */
  private String name;

  //This will store the next number to be assigned to serialNumber
  private static int currentProductionNumber = 1;

  /**
   * Initializes all private fields as well as increment currentProductionNumber the next instance
   * of product
   *
   * @param name the name of this instance of product
   */
  public Product(String name) {
    this.name = name;
    // Assign manufacturer to Item's field of the same name
    this.manufacturer = Item.manufacturer;

    // Assign serial number from the currentProductionNumber
    serialNumber = currentProductionNumber;

    // Increment currentProductionNumber for the next instance
    // This was identified as a bug
    currentProductionNumber++;

    // Initialize manufacturedOn to the current date
    manufacturedOn = new Date();
  }

  /**
   * Setter method for serialNumber
   *
   * @param productionNumber what serialNumber will be set to
   */
  public void setProductionNumber(int productionNumber) {
    serialNumber = productionNumber;
  }

  /**
   * Setter method for name
   *
   * @param name string that name will be set to
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter method fro name
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Getter method for manufactured date
   *
   * @return manufacturedOn
   */
  public Date getManufactureDate() {
    // This was identified as a bug
    return manufacturedOn;
  }

  /**
   * Getter method for serial number
   *
   * @return serialNumber
   */
  public int getSerialNumber() {
    return serialNumber;
  }

  /**
   * Override toString to return the product's information such as manufacturer, serial number,
   * date, and name
   *
   * @return the information of the specific instance of this class
   */
  @Override
  public String toString() {
    String productInfo;

    productInfo = "Manufacturer : " + manufacturer + "\n" +
        "Serial Number : " + serialNumber + "\n" +
        "Date : " + manufacturedOn + "\n" +
        "Name : " + name;

    return productInfo;
  }


  /**
   * Used to order products in a list
   *
   * @param product product being compared
   * @return if s1 is greater than s2, it returns positive number, if s1 less than s2, it returns
   * negative number, and if s1 is equal to s2, it returns 0
   */
  public int compareTo(Product product) {
    return this.name.compareTo(product.getName());
  }
}

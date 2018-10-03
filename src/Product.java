/**
 * Gregorio Lozada Sept 29, 2018
 *
 * Product: An abstract class that implements the interface Item. Its constructor takes in a string
 * called and initializes its private fields. Product also defines the methods in the Item interface
 * and overrides Object's toString method.
 *
 * Instructions to create this class were provided by Oracle Academy.
 */

import java.util.Date;

public abstract class Product implements Item {

  private int serialNumber;
  private String manufacturer;
  private Date manufacturedOn;
  private String name;

  //This will store the next number to be assigned to serialNumber
  private static int currentProductionNumber = 0;

  /**
   * Initializes all private fields as well as increment currentProductionNumber the next instance
   * of product
   *
   * @param name the name of this instance of product
   */
  public Product(String name) {
    this.name = name;
    //Assign manufacturer to Item's field of the same name
    this.manufacturer = Item.manufacturer;

    //Assign serial number from the currentProductionNumber
    serialNumber = currentProductionNumber;

    //Increment currentProductionNumber for the next instance
    //This was identified as a bug
    currentProductionNumber++;

    //Initialize manufacturedOn to the current date
    manufacturedOn = new Date();
  }

  public void setProductionNumber(int productionNumber) {
    serialNumber = productionNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Date getManufactureDate() {
    //This was identified as a bug
    return manufacturedOn;
  }

  public int getSerialNumber() {
    return serialNumber;
  }

  /**
   * Override toString to return the product's information such as manufacturer, serial number,
   * date, and name.
   *
   * @return the information of the specific instance of this class
   */
  @Override
  public String toString() {
    String productInfo;

    productInfo = "Manufacturer  : " + manufacturer + "\n" +
        "Serial Number : " + serialNumber + "\n" +
        "Date          : " + manufacturedOn + "\n" +
        "Name          : " + name;

    return productInfo;
  }
}

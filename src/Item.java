/**
 * Gregorio Lozada Sept 29, 2018
 *
 * ItemType: Enum that contains values for each type of item as well as a type's code. It also has a
 * constructor that takes in a string called code and sets the constant field of the same name to
 * it.
 *
 * Item: Interface that contains a constant string called manufacturer, as well as getters and
 * setters for serial number, name, and manufacture date.
 *
 * Instructions to create both the enum and interface were provided by Oracle Academy.
 */

import java.util.Date;

enum ItemType {
  Audio("AU"),
  Visual("VI"),
  AudioMobile("AM"),
  VisualMobile("VM");

  public final String code;

  /**
   * Sets the constant field code to the string parameter of the same name
   *
   * @param code the code for the item type
   */
  ItemType(String code) {
    this.code = code;
  }
}

public interface Item {

  //Constant called manufacturer set to "Oracle Production"
  final String manufacturer = "Oracle Production";

  //A method setProductionNumber that would have one integer parameter
  public void setProductionNumber(int productionNumber);

  //A method setName that would have one String parameter
  public void setName(String name);

  //A method getName that would return a String
  public String getName();

  //A method getManufactureDate that would return a Date
  public Date getManufactureDate();

  //A method getSerialNumber that would return an int
  public int getSerialNumber();
}

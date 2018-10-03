/**
 * Gregorio Lozada Sept 29, 2018
 *
 * Item: Interface that contains a constant string called manufacturer, as well as getters and
 * setters for serial number, name, and manufacture date.
 *
 * Instructions to create the interface was provided by Oracle Academy.
 */

import java.util.Date;

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

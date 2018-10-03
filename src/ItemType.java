/**
 * Gregorio Lozada Sept 29, 2018
 *
 * ItemType: Enum that contains values for each type of item as well as a type's code. It also has a
 * constructor that takes in a string called code and sets the constant field of the same name to
 * it.
 *
 * Instructions to create the enum was provided by Oracle Academy.
 */

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

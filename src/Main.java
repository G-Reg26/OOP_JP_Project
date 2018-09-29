/**
 * Gregorio Lozada Sept 29, 2018
 *
 * Main: Creates two objects of type Widget and prints them out to the console.
 *
 * Widget: Class that extends the abstract class product. Its constructor takes in a string called
 * name and passes it to product's constructor.
 *
 * Code for class Main and Widget were provided by Prof. Scott VanSelow through Canvas.
 */

public class Main {

  public static void main(String[] args) {
    //Create widget named Widget1
    Widget w1 = new Widget("Widget1");
    //Print out w1
    System.out.println(w1.toString());
    //Create widget named Widget1
    Widget w2 = new Widget("Widget2");
    //Print out w2
    System.out.println(w2.toString());

    //For each value in ItemType
    for (ItemType it : ItemType.values()) {
      //Print type and its code
      System.out.println(it + " " + it.code);
    }
  }
}

class Widget extends Product {

  /**
   * Takes the the string parameter and passes it to the super class constructor, in this case
   * Product's constructor
   *
   * @param name the name of the widget
   */
  public Widget(String name) {
    super(name);
  }
}

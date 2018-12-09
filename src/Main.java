/**
 * @author Gregorio Lozada
 *
 * Oct 27, 2018
 *
 * Main: Tests the Java collection ArrayList by creating a list of Product objects, sorts the list,
 * and prints the list out to the console.
 *
 * Code for class Main was provided by the JPP 16 assignment in repl.it.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Main {

  /**
   * Creates an ArrayList of Product objects, sets the list, sorts the list, and prints out the
   * list
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {

    // Write one line of code to create an ArrayList of products
    ArrayList<Product> productList;

    // Write one line of code to call testCollection and assign the result to the ArrayList
    productList = testCollection();

    // Write one line of code to sort the ArrayList
    Collections.sort(productList);

    // Call the print method on the ArrayList
    print(productList);

    System.out.println();

    printType(productList, AudioPlayer.class);
  }

  // Step 15
  // Complete the header for the testCollection method here

  /**
   * Tests the java collection ArrayList by initializing objects of subclasses of the Product class
   * and adds them to a list
   *
   * @return returns the list of product objects
   */
  public static ArrayList<Product> testCollection() {

    AudioPlayer a1 = new AudioPlayer("iPod Mini", "MP3");
    AudioPlayer a2 = new AudioPlayer("Walkman", "WAV ");
    MoviePlayer m1 = new MoviePlayer("DBPOWER MK101",
        new Screen(" 720x480", 40, 22), MonitorType.LCD);
    MoviePlayer m2 = new MoviePlayer("Pyle PDV156BK",
        new Screen("1366x768", 40, 22), MonitorType.LED);

    // Write one line of code here to create the collection
    ArrayList<Product> products = new ArrayList<>();

    products.add(a1);
    products.add(a2);
    products.add(m1);
    products.add(m2);
    return products;
  }

  /**
   * Prints each object in the parameter list to the console
   *
   * How to implement this code was provided by the user gexicide from stack overflow:
   * https://stackoverflow.com/questions/22860582/java-generics-wildcard-vs-type-parametere/22860768
   *
   * @param list the list that will be printed out to the console
   * @param <T> the class of the objects stored in list
   */
  public static <T> void print(ArrayList<T> list) {
    for (T listObject : list) {
      System.out.println(listObject);
    }
  }

  /**
   * Prints each object in the parameter list of a certain type to the console
   *
   * @param list the list that will be printed out
   * @param type the type of object that will be printed
   * @param <T> the class of the objects stored in list
   */
  public static <T> void printType(ArrayList<T> list, Class<?> type) {
    for (T listObject : list) {
      if (listObject.getClass() == type) {
        System.out.println(listObject);
      }
    }
  }
}
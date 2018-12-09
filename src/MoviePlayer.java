/**
 * @author Gregorio Lozada
 *
 * Oct 27, 2018
 *
 * MoviePlayer: A class that extends Product and implements the interface MultiMediaControl. Its
 * constructor takes in a string called name that is passed to Product's constructor, a Screen
 * object, and a MonitorType object that are used to initialize its private fields. MoviePlayer also
 * defines the methods in the MultimediaControl interface and overrides Object's toString method.
 *
 * Instructions to create this class were provided by Oracle Academy.
 */

public class MoviePlayer extends Product implements MultimediaControl {

  /**
   * Screen of this product
   */
  Screen screen;

  /**
   * Type of monitor of this product
   */
  MonitorType monitorType;

  /**
   * Takes in the string name and passes name to Movie Player's super class as well as takes in a
   * screen and monitor type and sets the private fields with them.
   *
   * @param name name of the Movie Player object
   * @param screen screen of the Movie Player object
   * @param monitorType monitor type of the Movie Player object
   */
  public MoviePlayer(String name, Screen screen, MonitorType monitorType) {
    super(name);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /**
   * Print out the word "Playing"
   */
  public void play() {
    System.out.println("Playing");
  }

  /**
   * Print out the word "Stopping"
   */
  public void stop() {
    System.out.println("Stopping");
  }

  /**
   * Print out the word "Previous"
   */
  public void previous() {
    System.out.println("Previous");
  }

  /**
   * Print out the word "Next"
   */
  public void next() {
    System.out.println("Next");
  }

  /**
   * Override toString to return the movie player's information such as screen, and monitor type.
   *
   * @return the information of the specific instance of this class
   */
  public String toString() {
    String screenInfo;

    screenInfo = super.toString() + "\n" +
        "Screen : " + screen + "\n" +
        "Monitor Type : " + monitorType;

    return screenInfo;
  }
}
/**
 * @author Gregorio Lozada
 *
 * Oct 27, 2018
 *
 * Main: Users can create/add products to be produced, as well as how many to produced. Users can
 * also view products that have been produced and see product statistics, which consists of how many
 * products have been produced, how many of those are audio or movie players, and how many unique
 * items have been produced. Products can be added at any time and the user deicdes when to end the
 * program.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // All products produced will be stored in this list
    ArrayList<Product> productsProduced = new ArrayList<>();
    // Only one of each kind of product will be stored in this list
    ArrayList<Product> products = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    boolean exit = false;

    int selection = 0;

    while (!exit) {
      printMenu(0);

      // Get user input on what action to perform
      selection = menuSelection(scan, 1, 5);

      switch (selection) {
        case 1:
          // Create a new product and add only of of the newly created products to the products list
          createProduct(scan, productsProduced);
          products.add(productsProduced.get(productsProduced.size() - 1));
          break;
        case 2:
          // If products have been produced
          if (products.size() > 0) {
            // Have user select what kind of unique product to produce and how many then...
            System.out.println("Select which product to produce:");
            for (int i = 0; i < products.size(); i++) {
              System.out.println((i + 1) + ". " + products.get(i).getName());
            }

            selection = menuSelection(scan, 1, products.size());

            Product productToProduce = products.get(selection - 1);

            int amount = 0;

            do {
              System.out.println("How many would you like to produce?");
              amount = intInput(scan);
            } while (!(amount > 0));

            // produce the amount specified
            for (int i = 0; i < amount; i++) {
              if (productToProduce instanceof MoviePlayer) {
                Screen screen = new Screen
                    (((MoviePlayer) productToProduce).screen.resolution,
                        ((MoviePlayer) productToProduce).screen.refreshRate,
                        ((MoviePlayer) productToProduce).screen.responseTime);

                productsProduced.add(new MoviePlayer(productToProduce.getName(), screen,
                    ((MoviePlayer) productToProduce).monitorType));
              } else if (productToProduce instanceof AudioPlayer) {
                productsProduced.add(new AudioPlayer(productToProduce.getName(),
                    ((AudioPlayer) productToProduce).getAudioSpecification()));
              }
            }
          } else {
            System.out.println("No products have been produced\n");
          }
          break;
        case 3:
          // Print all the products that have been produced
          if (productsProduced.size() > 0) {
            print(productsProduced);
          } else {
            System.out.println("No products have been produced\n");
          }
          break;
        case 4:
          // Print production statistics
          System.out.println("Products produced: " + productsProduced.size());
          int moviePlayers = 0;
          int audioPlayers = 0;

          for (Product product : productsProduced) {
            if (product instanceof MoviePlayer) {
              moviePlayers++;
            } else if (product instanceof AudioPlayer) {
              audioPlayers++;
            }
          }

          System.out.println("Movie Players Produced: " + moviePlayers);
          System.out.println("Audio Players Produced: " + audioPlayers);
          System.out.println("Unique Products Produced: " + products.size());
          System.out.println();
          break;
        case 5:
          // Exit program
          System.out.println("Goodbye");
          exit = true;
          break;
        default:
          break;
      }
    }
  }

  /**
   * Print a menu depending on the index passed
   *
   * @param index index of the menu to print
   */
  public static void printMenu(int index) {
    switch (index) {
      case 0:
        System.out.println("Select an option:");
        System.out.println("1. Create Product");
        System.out.println("2. Add Product");
        System.out.println("3. View Products");
        System.out.println("4. Product Statistics");
        System.out.println("5. Exit");
        break;
      case 1:
        System.out.println("What type of product would you like to create?:");
        System.out.println("1. Audio Player");
        System.out.println("2. Movie Player");
        break;
      case 2:
        System.out.println("What type of monitor does this movie player have?:");
        System.out.println("1. LCD");
        System.out.println("2. LED");
        break;
      case 3:

        break;
    }
  }

  /**
   * Asks user what type of product to create. Users can choose to create an audio player or movie
   * player
   *
   * @param scan scanner to read input
   * @param products list of products that will be used to add newly created products
   */
  public static void createProduct(Scanner scan, ArrayList<Product> products) {
    int selection = 0;

    // Ask user what type of product to produce
    printMenu(1);

    selection = menuSelection(scan, 1, 2);

    switch (selection) {
      case 1:
        createAudioPlayer(scan, products);
        break;
      case 2:
        createMoviePlayer(scan, products);
        break;
      default:
        break;
    }
  }

  /**
   * Creates an audio player using input from user
   *
   * @param scan scanner to read input
   * @param products list of products that will be used to add newly created products
   */
  public static void createAudioPlayer(Scanner scan, ArrayList<Product> products) {
    String name = "";
    String specification = "";

    System.out.println("Please enter product name:");
    name = scan.nextLine();

    System.out.println("Please enter audio specification");
    specification = scan.nextLine();

    int amount = 0;

    do {
      System.out.println("How many would you like to produce?");
      amount = intInput(scan);
    } while (!(amount > 0));

    // Produce the amount of audio players specified using the input submitted by the user
    for (int i = 0; i < amount; i++) {
      products.add(new AudioPlayer(name, specification));
    }
  }

  /**
   * Creates a movie player using input from user
   *
   * @param scan scanner to read input
   * @param products list of products that will be used to add newly created products
   */
  public static void createMoviePlayer(Scanner scan, ArrayList<Product> products) {
    String name = "";
    String resolution = "";
    int refreshRate = 0;
    int responseTime = 0;
    MonitorType monitorType = MonitorType.LCD;

    System.out.println("Please enter product name:");
    name = scan.nextLine();

    System.out.println("Please enter screen resolution (Ex. 1920x1080)");
    do {
      resolution = scan.nextLine();
    } while (!validResolutionInput(resolution));

    do {
      System.out.println("Please enter screen refresh rate (Must be greater than 0)");
      refreshRate = intInput(scan);
    } while (!(refreshRate > 0));

    do {
      System.out.println("Please enter screen response time (Must be greater than 0)");
      responseTime = intInput(scan);
    } while (!(responseTime > 0));

    int selection = 0;

    // Ask user what type of monitor the movie player being created will have
    do {
      printMenu(2);

      selection = intInput(scan);
    } while (!(selection > 0 && selection < 3));

    switch (selection) {
      case 1:
        monitorType = MonitorType.LCD;
        break;
      case 2:
        monitorType = MonitorType.LED;
        break;
      default:
        break;
    }

    Screen screen;

    int amount = 0;

    do {
      System.out.println("How many would you like to produce?");
      amount = intInput(scan);
    } while (!(amount > 0));

    // Produce the amount of movie players specified using the input submitted by the user
    for (int i = 0; i < amount; i++) {
      screen = new Screen(resolution, refreshRate, responseTime);
      products.add(new MoviePlayer(name, screen, monitorType));
    }
  }

  /**
   * Checks to see if the user submitted resolution is formatted correctly
   *
   * @param reso string to check
   * @return true if format is correct, false if otherwise
   */
  public static boolean validResolutionInput(String reso) {
    if (reso.contains("x")) {
      // Check if width is an integer
      try {
        Integer.parseInt(reso.substring(0, reso.indexOf("x")));
      } catch (Exception e) {
        System.out.print("Resolution width is in incorrect format: ");
        System.out.print(reso.substring(0, reso.indexOf("x")) + "\n");
        System.out.println("Ex. 1920x1080");
        return false;
      }

      // Check if height is an integer
      try {
        Integer.parseInt(reso.substring(reso.indexOf("x") + 1));
      } catch (Exception e) {
        System.out.print("Resolution height is in incorrect format: ");
        System.out.print(reso.substring(reso.indexOf("x") + 1) + "\n");
        System.out.println("Ex. 1920x1080");
        return false;
      }

      return true;
    } else {
      System.out.println("Resolution is in incorrect format");
      System.out.println("Ex. 1920x1080");
      return false;
    }
  }

  /**
   * Get input on which action the user wants the program to perform depending on what the current
   * menu is being displayed. Makes sure user does not enter a value less than or greater than the
   * boundary set
   *
   * @param scan scanner to read input
   * @param lowBound lowest integer value user can enter
   * @param upperBound highest integer value user can enter
   * @return integer value entered by the user
   */
  public static int menuSelection(Scanner scan, int lowBound, int upperBound) {
    boolean validSelection = false;
    int selection = 0;

    while (!validSelection) {
      selection = intInput(scan);

      if (selection >= lowBound && selection <= upperBound) {
        validSelection = true;
      } else {
        System.out.println("Please enter a number between " + lowBound + " and " + upperBound);
      }
    }

    return selection;
  }

  /**
   * Makes sure user input is an integer and not some other type of value
   *
   * @param scan scanner to read input
   * @return integer value entered by the user
   */
  public static int intInput(Scanner scan) {
    int input = 0;
    boolean validInput = false;

    while (!validInput) {
      try {
        input = scan.nextInt();
        validInput = true;
      } catch (InputMismatchException imException) {
        System.out.println("Please enter a whole number");
        scan.next();
      }
    }

    scan.nextLine();
    return input;
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
      System.out.println();
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
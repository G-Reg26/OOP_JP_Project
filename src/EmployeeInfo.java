/**
 * @author Gregorio Lozada
 *
 * Nov 2, 2018
 *
 * EmployeeInfo: A class that defines the attributes and behaviors of employee information. For each
 * instance created, the user will have to enter in a valid name, with first name, last name, and a
 * space in between them, as well as a department id with a pattern of a capital letter, followed by
 * three lowercase letters, followed by two numbers. Using the name entered by the user, a code will
 * also be set using the first initial of the first name followed by the full last name.
 *
 * Instructions to create this class were provided by Oracle Academy.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeInfo {

  /**
   * Employee name
   */
  private StringBuilder name;

  /**
   * Employee code (Fist initial + full last name)
   */
  private String code;

  /**
   * Department id
   */
  private String deptId;

  /**
   * Pattern for department id (Capital letter + three lowercase letters + two numbers)
   */
  private Pattern p;

  /**
   * Scanner used to get user input
   */
  private Scanner in;

  /**
   * Sets employee information by getting input from user. If user information is not valid,
   * employee information will be set to default values
   */
  EmployeeInfo() {
    // The department code is made up of four letters and two numbers
    p = Pattern.compile("[A-Z][a-z]{3}\\d{2}");

    // As there will be multiple inputs across the class now the scanner will need to be declared
    // and...
    // This was identified as a bug
    in = new Scanner(System.in);

    setName();
    setDeptId();

    // closed in the constructor
    in.close();
  }

  /**
   * Getter method for the field name
   *
   * @return name
   */
  public StringBuilder getName() {
    return name;
  }

  /**
   * Getter method for the field code
   *
   * @return code
   */
  public String getCode() {
    return code;
  }

  /**
   * Getter method for the field deptId
   *
   * @return deptId
   */
  public String getDeptId() {
    return deptId;
  }

  /**
   * Gets a name from the user then checks to make sure it is in the right format
   */
  private void setName() {
    name = new StringBuilder(inputName());

    if (checkName(name)) {
      createEmployeeCode(name);
    } else {
      code = "guest";
    }
  }

  /**
   * Gets department Id from user then checks to make sure it is in the right pattern
   */
  private void setDeptId() {
    String deptId = getId();

    // If the pattern matches then the given id is set to deptId
    if (validId(deptId)) {
      deptId = reverseString(deptId);
      this.deptId = deptId;
    }
    // otherwise a default value of None01 should be assigned.
    else {
      this.deptId = "None01";
    }
  }

  /**
   * Get the user's name from the user
   *
   * @return input from the user
   */
  private String inputName() {
    System.out.print("Please enter your first and last name: ");

    return in.nextLine();
  }

  /**
   * Get the id from the user
   *
   * @return input from the user
   */
  private String getId() {
    System.out.print("Please enter your department ID: ");

    return in.nextLine();
  }

  /**
   * Checks to see if the name the user entered is in the right format (First name and last name
   * with a space in between
   *
   * @param name string that is being checked
   * @return true if the string, name, is in the right format false if otherwise.
   */
  private boolean checkName(StringBuilder name) {
    return name.toString().contains(" ");
  }

  /**
   * Used to check if the input matches the pattern
   *
   * @param id input from user
   * @return true if input pattern matches the pattern p false if otherwise.
   */
  private boolean validId(String id) {
    Matcher m = p.matcher(id);
    if (m.matches()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Create an employee code for the user using the name they entered. the format of an employee
   * code is first initial + full last name
   *
   * @param name string being used to create employee code
   */
  private void createEmployeeCode(StringBuilder name) {
    code = name.charAt(0) + name.substring(name.indexOf(" ") + 1);
  }

  /**
   * Reverses the string passed as an argument
   *
   * @param id string to be reversed
   * @return reversed string
   */
  public String reverseString(String id) {
    if (id.length() < 1) {
      return id;
    } else {
      return reverseString(id.substring(1)) + id.charAt(0);
    }
  }

  /**
   * Returns the attributes of an instance of this class in string form
   *
   * @return string of the attributes of this class and their values
   */
  public String toString() {
    return "Employee Code : " + code + "\n" +
        "Department Number : " + deptId + "\n";
  }
}

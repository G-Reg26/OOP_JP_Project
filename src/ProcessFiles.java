/**
 * @author Gregorio Lozada
 *
 * Dec 9, 2018
 *
 * ProcessFiles: Creates a directory and file, as well as writes to the file. Can write employee
 * information or a list of products.
 *
 * Instructions to create this class were provided by Oracle Academy.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProcessFiles {

  private Path p;
  private Path p2;
  private Path p3;

  /**
   * Calls createDirectory when object is created
   */
  public ProcessFiles() {
    createDirectory();
  }

  /**
   * Checks if directories and files exists, and if they do not, then they are created
   */
  private void createDirectory() {
    p = Paths.get("C:/LineTests");
    p2 = Paths.get(p + "/TestResults.txt");

    try {
      if (!Files.isDirectory(p)) {
        Files.createDirectory(p);
      }
    } catch (IOException ioException) {
      System.out.println("Failed to create directory");
    }

    try {
      if (!Files.exists(p2)) {
        Files.createFile(p2);
      }
    } catch (IOException ioException) {
      System.out.println("Failed to create file: " + p2);
    }

    p3 = p.resolve(p2.toString());
  }

  /**
   * Writes employee info to file
   *
   * @param emp employee information to write to file
   * @throws IOException throws exception for the buffered writer
   */
  public void writeFile(EmployeeInfo emp) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter(p3.toFile(), true));

    String lines[] = emp.toString().split("\\r?\\n");

    for (String line : lines) {
      out.write(line);
      out.newLine();
    }

    out.close();
  }

  /**
   * Writes products list to file
   *
   * @param products products list to write to file
   * @throws IOException throws exception for the buffered writer
   */
  public void writeFile(ArrayList<Product> products) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter(p3.toFile(), true));

    for (Product product : products) {
      String lines[] = product.toString().split("\\r?\\n");

      for (String line : lines) {
        out.write(line);
        out.newLine();
      }
    }

    out.close();
  }
}

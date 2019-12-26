package ir.mehranbehnam.balancedbrakets;

import java.util.Scanner;

/**
 * An abstract class useful to start application.
 *
 * @author Mehran Behnam
 */
abstract class Application {
  /** to get file path from CLI. */
  private static final Scanner scanner = new Scanner(System.in);
  /** Regular expression to check file path validity. */
  private static final String filePath = "^/([A-z0-9-_+]+/)*([A-z0-9]+\\.(java))$";

  /** Method that called to start application */
  void start() {
    System.out.println("Enter file path:");
    String fileAddress = scanner.nextLine();
    checkAddressValidity(fileAddress);
    ExtractBrackets extractBrackets = new ExtractBrackets(fileAddress);
    boolean validator = new BalancedBrackets(extractBrackets.getBrackets()).validator();

    System.out.println(validator);
  }

  /**
   * Tries to match path with {@link Application#filePath} or exit program with -1 code.
   *
   * @param path file path
   */
  private void checkAddressValidity(String path) {
    if (!path.matches(Application.filePath)) {
      System.out.println("Invalid file path.");
      System.exit(-1);
    }
  }
}

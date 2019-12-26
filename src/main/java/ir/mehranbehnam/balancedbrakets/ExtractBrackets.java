package ir.mehranbehnam.balancedbrakets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To extract brackets from file.
 *
 * @author Mehran Behnam
 */
class ExtractBrackets {
  /** Regular expression to fin brackets. */
  private Pattern pattern = Pattern.compile("[{}()\\[\\]]");
  /** to join found brackets together. */
  private StringBuilder stringBuilder = new StringBuilder();

  /** @param file file path */
  ExtractBrackets(String file) {
    readFile(file);
  }

  /**
   * Tries read all lines of file, join them together and append brackets.
   *
   * @param file file path
   */
  private void readFile(String file) {
    try {
      List<String> allLines = Files.readAllLines(Paths.get(file));

      String join = String.join("", allLines);

      appendBrackets(join);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Join brackets together in a string.
   *
   * @param string the string that needs to extract brackets.
   */
  private void appendBrackets(String string) {
    Matcher m = pattern.matcher(string);

    while (m.find()) stringBuilder.append(string.charAt(m.start()));
  }

  /** @return brackets */
  String getBrackets() {

    return stringBuilder.toString();
  }
}

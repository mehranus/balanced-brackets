package ir.mehranbehnam.balancedbrakets;

import java.util.Stack;

/** @author Mehran Behnam */
class BalancedBrackets {
  /** string of brackets. */
  private String brackets;
  /** Used for figure out of brackets balance. */
  private Stack<Character> stack = new Stack<>();

  /** @param brackets string of brackets */
  BalancedBrackets(String brackets) {
    this.brackets = brackets;
  }

  /** @return return true when all brackets in string are balance. */
  boolean validator() {
    for (int i = 0; i < brackets.length(); i++) {
      char c = brackets.charAt(i);
      if (isOpen(c)) {
        stack.push(c);
      } else if (isClose(c)) {
        Character peek = stack.peek();
        if (isBalanced(peek, c)) {
          stack.pop();
        }
      }
    }
    return stack.isEmpty();
  }

  /**
   * return true if is open bracket.
   *
   * @param c bracket
   */
  private boolean isOpen(char c) {
    return c == '{' || c == '(' || c == '[';
  }

  /**
   * return true if is close bracket.
   *
   * @param c brackets
   */
  private boolean isClose(char c) {
    return c == '}' || c == ')' || c == ']';
  }

  /**
   * compare two bracket if they balance return true.
   *
   * @param open that bracket we think is open .
   * @param close that bracket we think is open.
   */
  private boolean isBalanced(char open, char close) {
    switch (open) {
      case '{':
        return close == '}';
      case '[':
        return close == ']';
      case '(':
        return close == ')';
      default:
        return false;
    }
  }
}

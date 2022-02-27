package by.training.task_02_information_handling.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Parser {
  private static String input;
  private final static String delimiter = "\\d+|\\+|\\-|\\*|\\/|\\(|\\)";
  private final static Pattern pattern;

  static {
    pattern = Pattern.compile(delimiter);
  }

  private Parser() {
  }

  public static List<String> parserSixElements() {
    input = ValidInput.equalCountBrackets();
    Matcher matcher = pattern.matcher(input);
    List<String> array = new ArrayList();

    for(int i = 0; matcher.find(); ++i) {
      array.add(i, matcher.group());
    }

    return array;
  }

  public static List<String> parserSixElements(String input) {
    input = ValidInput.equalCountBrackets(input);
    Matcher matcher = pattern.matcher(input);
    List<String> array = new ArrayList();

    for(int i = 0; matcher.find(); ++i) {
      array.add(i, matcher.group());
    }

    return array;
  }
}

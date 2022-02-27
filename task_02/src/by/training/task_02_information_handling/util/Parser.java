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

  /**
   * Метод делит строку, переданную с консоли, на объекты String при наличии любого из разделителей (delimeter).
   * @return коллекцию Arraylist со всеми элементами.
   */
  public static List<String> parserSixElements() {
    input = ValidInput.equalCountBrackets();
    Matcher matcher = pattern.matcher(input);
    List<String> array = new ArrayList();

    for(int i = 0; matcher.find(); ++i) {
      array.add(i, matcher.group());
    }

    return array;
  }

  /**
   * Метод делит строку на объекты String при наличии любого из разделителей (delimeter).
   * @param input строка для обработки.
   * @return коллекцию Arraylist со всеми элементами.
   */
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

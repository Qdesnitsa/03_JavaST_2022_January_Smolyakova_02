package by.training.task_02_information_handling.util;

import by.training.task_02_information_handling.input.InputScanner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidInput {
  private static String input;

  private ValidInput() {
  }

  /**
   * Метод принимает строку, проверяет на наличие только целых чисел и шести символов "(", ")", "+",
   * "-", "*", "/".
   */
  public static String obtainValidElements() {
    input = InputScanner.obtainInput();
    String validInput = "[0-9\\/\\*\\+\\-\\(\\)]+";
    while (!input.matches(validInput)) {
      input = InputScanner.obtainInput();
    }
    return input;
  }

  /**
   * Метод принимает строку, проверяет на наличие недопустимых последовательностей чисел и
   * символов.
   */
  public static String obtainValidOrder() {
    input = obtainValidElements();
    //1. недопустимая последовательность операторов
    String validOrderOperators = "[\\+|\\-|\\*|\\/]{2,}";
    //2. недопустимая последовательность операторов и чисел со скобками
    String validOrderWithBrackets =
        "[\\(][\\)|\\+|\\-|\\*|\\/]|[\\)][\\(]|[\\d]]|[0-9][\\(]|[\\(][\\d+][\\)]|[\\+|\\-|\\*|\\/][\\)]";
    //3. недопустимое начало строки
    String validStartLine = "^[\\+|\\-|\\*|\\/\\)]";
    //4. недопустимый конец строки
    String validEndLine = "[\\+|\\-|\\*|\\/\\(]$";

    List<Pattern> patterns = new ArrayList<>();
    patterns.add(Pattern.compile(validOrderOperators));
    patterns.add(Pattern.compile(validOrderWithBrackets));
    patterns.add(Pattern.compile(validStartLine));
    patterns.add(Pattern.compile(validEndLine));

    Matcher matcher;
    for (Pattern pattern : patterns) {
      matcher = pattern.matcher(input);
      while (matcher.find()) {
        input = obtainValidElements();
        matcher = pattern.matcher(input);
      }
    }
    return input;
  }

  /**
   * Метод считает количество повторений целевого элемента в строке
   */
  public static int countBrackets(char targetElement, String input) {
    int count = 0;
    for (char elem : input.toCharArray()) {
      if (elem == targetElement) {
        count++;
      }
    }
    return count;
  }

  /**
   * Метод проверяет на равенство коичество ( и ) в строке.
   * Если равенство соблюдается - возвращает строку.
   */
  public static String equalCountBrackets() {
    input = obtainValidOrder();
    int count1 = countBrackets('(', input);
    int count2 = countBrackets(')', input);
    while (count1 != count2) {
      input = obtainValidOrder();
      count1 = countBrackets('(', input);
      count2 = countBrackets(')', input);
    }
    return input;
  }

}

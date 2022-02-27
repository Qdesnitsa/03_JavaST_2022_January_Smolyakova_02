package by.training.task_02_information_handling.util;

import static by.training.task_02_information_handling.util.PatternRegex.*;

import by.training.task_02_information_handling.input.InputData;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidInput {
  private static String input;

  private ValidInput() {
  }

  /**
   * Метод проверяет строку на соответствие целым числам и символам '(',')','+','-','*','/'
   * @return строку соответствующую условию
   */
  public static String obtainValidElements() {
    input = InputData.obtainInput();

    for( ;!input.matches(INVALID_INPUT); input = InputData.obtainInput()) {
    }

    return input;
  }

  public static String obtainValidElements(String input) {
    input = InputData.obtainInput(input);
    if (!input.matches(INVALID_INPUT)) {
      throw new RuntimeException("Argument contains characters other than numbers and '(',')','+','-','*','/'.");
    }
    return input;
  }

  /**
   * Метод проверяет строку на соответствие последовательности цифр и символов для расчёта выражения
   * @return строку соответствующую условию
   */
  public static String obtainValidOrder() {
    input = obtainValidElements();
    List<Pattern> patterns = obtainArrayListPattern();
    Matcher matcher;
    int i;
    for (i = 0; i < patterns.size(); i++) {
      matcher = patterns.get(i).matcher(input);
      while (matcher.find()) {
        input = obtainValidElements();
        matcher = patterns.get(i).matcher(input);
        i = (i == patterns.size() - 1) ? i = 0 : i;
      }
    }
    return input;
  }

  public static String obtainValidOrder(String input) {
    input = obtainValidElements(input);
    List<Pattern> patterns = obtainArrayListPattern();
    Matcher matcher;
    int i;
    for (i = 0; i < patterns.size(); i++) {
      matcher = patterns.get(i).matcher(input);
      if (matcher.find()) {
        throw new RuntimeException("Invalid consistency of characters.");
      }
    }
    return input;
  }

  /**
   * Метод считает количество передаваемого элемента в строке
   * @param targetElement целевой элемент для подсчета
   * @param input строка
   * @return количество повторений
   */
  public static int countBrackets(char targetElement, String input) {
    int count = 0;

    for(int i = 0; i < input.toCharArray().length; i++) {
      if (input.charAt(i) == targetElement) {
        ++count;
      }
    }

    return count;
  }

  /**
   * Метод проверяет на равенство количество повторений символов '(' и ')'
   * @return строку, если она соответствует условию
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

  public static String equalCountBrackets(String input) {
    input = obtainValidOrder(input);
    int count1 = countBrackets('(', input);
    int count2 = countBrackets(')', input);
    if (count1 != count2) {
      throw new RuntimeException("Unequal number of '(' and ')'.");
    }
    return input;
  }
}


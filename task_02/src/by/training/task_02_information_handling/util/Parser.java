package by.training.task_02_information_handling.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Parser {

  private Parser() {
  }

  public static List<String> parserSixElements() {
    String input = ValidInput.equalCountBrackets();
    String delimiter = "\\d+|\\+|\\-|\\*|\\/|\\(|\\)";
    Pattern pattern = Pattern.compile(delimiter);
    Matcher matcher = pattern.matcher(input);
    List<String> array = new ArrayList<>();
    for (int i = 0; matcher.find(); i++) {
      array.add(i, matcher.group());
    }
    return array;
  }

}

package by.training.task_02_information_handling.calculation;

import by.training.task_02_information_handling.util.Parser;
import by.training.task_02_information_handling.util.Priority;
import java.util.List;
import java.util.Stack;

public class CalculatorSuper extends CalculatorSimple{
  private final Stack<Double> numbers = new Stack();
  private final Stack<String> operators = new Stack();

  public double getResult(String input) {
    List<String> array;
    if (input != null)
    {
      array = Parser.parserSixElements(input);
    } else {
      array = Parser.parserSixElements();
    }

    for(int i = 0; i < array.size(); ++i) {
      String element = array.get(i);

      try {
        double number = Double.parseDouble(element);
        numbers.push(number);
      } catch (NumberFormatException e) {
        if (element.equals("(")) {
          operators.push(element);
        } else if (element.equals(")")) {
          while (!operators.peek().equals("("))
            calculate();
            operators.pop();
          } else {
          if (operators.empty()) {
            operators.push(element);
          } else {
            Integer priority = Priority.obtainPriorityInt(element);
            while(!operators.empty() && !(operators.peek()).equals("(") && !(operators.peek()).equals(")") && priority <= Priority.obtainPriorityInt(operators.peek())) {
              calculate();
            }
            operators.push(element);
          }
        }
      }
    }
    while(!operators.empty()) {
      calculate();
    }
    return numbers.pop();
  }

  public void calculate() {
    String operator = operators.pop();
    Double b = numbers.pop();
    Double a = numbers.pop();
    Double result = null;
    switch(operator) {
      case "+":
        result = sum(a, b);
        break;
      case "-":
        result = diff(a, b);
        break;
      case "*":
        result = multiplying(a, b);
        break;
      case "/":
        result = division(a, b);
    }
    numbers.push(result);
  }

}

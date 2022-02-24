package by.training.task_02_information_handling;

import by.training.task_02_information_handling.calculation.CalculatorSuper;
import by.training.task_02_information_handling.output.OutputConsole;

public class CalculatorMain {

  public static void main(String[] args) {
    CalculatorSuper calculator = new CalculatorSuper();
    double result = calculator.getResult();
    OutputConsole.printResultingMsg(result);
  }

}

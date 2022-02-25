package by.training.task_02_information_handling;

import by.training.task_02_information_handling.calculation.CalculatorSuper;
import by.training.task_02_information_handling.output.OutputConsole;

public class CalculatorMain {

  public static void main(String[] args) {
    OutputConsole.printResultingMsg(new CalculatorSuper().getResult());
  }

}

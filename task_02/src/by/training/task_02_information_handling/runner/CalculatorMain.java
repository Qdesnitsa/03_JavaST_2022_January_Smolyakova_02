package by.training.task_02_information_handling.runner;

import by.training.task_02_information_handling.calculation.CalculatorSuper;
import by.training.task_02_information_handling.output.OutputConsole;

public class CalculatorMain {
  public CalculatorMain() {
  }

  public static void main(String[] args) {
    double resultDataFromConsole = new CalculatorSuper().getResult(null);
    OutputConsole.printResultingMsg(resultDataFromConsole);
    double resultDataFromMethodArgument = new CalculatorSuper().getResult("1+19-((3-2)+15)/2");
    OutputConsole.printResultingMsg(resultDataFromMethodArgument);
  }
}

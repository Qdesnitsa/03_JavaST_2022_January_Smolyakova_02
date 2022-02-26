package by.training.task_02_information_handling;

import by.training.task_02_information_handling.calculation.CalculatorSuper;
import by.training.task_02_information_handling.output.OutputConsole;

public class CalculatorMain {

  public static void main(String[] args) {
    double dataFromConsole = new CalculatorSuper().getResult(null);
    OutputConsole.printResultingMsg(dataFromConsole);
    double dataFromMethodArgument = new CalculatorSuper().getResult("1+10-((3-2)+15)/2");
    OutputConsole.printResultingMsg(dataFromMethodArgument);
  }

}

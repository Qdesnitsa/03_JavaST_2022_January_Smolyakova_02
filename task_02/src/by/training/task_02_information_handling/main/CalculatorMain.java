package by.training.task_02_information_handling.main;

import by.training.task_02_information_handling.bin.Calculator;
import by.training.task_02_information_handling.output.OutputConsole;

public class CalculatorMain {

  public static void main(String[] args) {
    Calculator dataFromConsole = new Calculator();
    dataFromConsole.getResult();
    OutputConsole.printResultingMsg(dataFromConsole.toString());

    Calculator dataFromArgument = new Calculator("1+19-((3-2)+15)/2");
    dataFromArgument.getResult();
    OutputConsole.printResultingMsg(dataFromArgument.toString());

  }
}

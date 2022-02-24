package by.training.task_02_information_handling.output;

public final class OutputConsole {

  private OutputConsole() {
  }

  public static void printInstructions() {
    System.out.println("Enter expression using: integers,+,-,*,/,(,) without spaces. Quantity of '(' and ')' should be equal.");
  }

  public static void printResultingMsg(double result) {
    System.out.println("Answer = " + result);
  }

}

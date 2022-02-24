package by.training.task_02_information_handling.calculation;

import by.training.task_02_information_handling.api.ICalculator;

public class CalculatorSimple implements ICalculator {

  @Override
  public double sum(double a, double b) {
    return a + b;
  }

  @Override
  public double diff(double a, double b) {
    return a - b;
  }

  @Override
  public double multiplying(double a, double b) {
    return a * b;
  }

  @Override
  public double division(double a, double b) {
    if (b == 0) {
      throw new RuntimeException("Do not divide by zero");
    }
    return a / b;
  }
}

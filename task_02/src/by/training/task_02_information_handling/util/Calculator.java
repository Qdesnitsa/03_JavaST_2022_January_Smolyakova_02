package by.training.task_02_information_handling.util;

import by.training.task_02_information_handling.calculation.CalculatorSuper;

public class Calculator {
  private String expression;
  private double result;
  private int typeOfInput;

  public Calculator() {
    this.typeOfInput = 0;
  }

  public Calculator(String expression) {
    this.expression = expression;
    this.typeOfInput = 1;
  }

  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public double getResult() {
    new CalculatorSuper().calcResult(this);
    return result;
  }

  public void setResult(double result) {
    this.result = result;
  }

  public int getTypeOfInput() {
    return typeOfInput;
  }

  public void setTypeOfInput(int typeOfInput) {
    this.typeOfInput = typeOfInput;
  }

  @Override
  public String toString() {
    return expression +
        " = " + result;
  }
}

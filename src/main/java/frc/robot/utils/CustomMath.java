package frc.robot.utils;

public class CustomMath {
  // tells us if the input is positive or negative
  public int returnSign(double input) {
    if (input / Math.abs(input) == 1) {
      return 1;
    } else if (input / Math.abs(input) == -1) {
      return -1;
    } else {
      return 0;
    }
  }

  // making the second input have the same sign as the first input
  public double makeSign(double sign, double value) {
    if (value / sign > 0) {
      return value;
    } else if (value / sign < 0) {
      return -value;
    } else {
      return 0;
    }
  }

  // returns the input that has a greater magnitude
  public double returnGreaterMag(double value1, double value2) {
    if (Math.abs(value1) > Math.abs(value2)) {
      return value1;
    } else if (Math.abs(value1) < Math.abs(value2)) {
      return value2;
    } else if (Math.abs(value1) == Math.abs(value2)) {
      return value1;
    } else {
      return 0;
    }
  }

  // returns the input that has a lesser magnitude
  public double returnLesserMag(double value1, double value2) {
    if (Math.abs(value1) > Math.abs(value2)) {
      return value2;
    } else if (Math.abs(value1) < Math.abs(value2)) {
      return value1;
    } else if (Math.abs(value1) == Math.abs(value2)) {
      return value1;
    } else {
      return 0;
    }
  }
}

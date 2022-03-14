package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberMotors;
import frc.robot.subsystems.PID;

public class RunClimberArm extends CommandBase {

  private ClimberMotors climber;
  private PID pid;

  private double rotationValue;
  private double tolerance;
  private boolean done;
  private double pidSpeed;
  private double motorSpeed;
  private double maxSpeed;

  public RunClimberArm(
      ClimberMotors m_climber,
      PID m_pid,
      double amountOfRotation,
      double toleranceValue,
      double maxMotorSpeed) {
    climber = m_climber;
    pid = m_pid;
    rotationValue = amountOfRotation;
    tolerance = toleranceValue;
    maxSpeed = maxMotorSpeed;

    done = false;
  }

  @Override
  public void initialize() {

    climber.setRightClimberArmEncoder(0);
    // pid.climberArmReset();
    pid.climberArmSetSetPoint(rotationValue);
    pid.climberArmSetTolerance(tolerance);

    done = false;
  }

  @Override
  public void execute() {
    pidSpeed = pid.climberArmCalculate(climber.getRightClimberArmPosition());
    if (pidSpeed > 0) {
      motorSpeed = Math.min(pidSpeed, maxSpeed);
    } else {
      motorSpeed = Math.max(pidSpeed, maxSpeed * -1);
    }
    climber.setClimberArmMotorSpeed(motorSpeed);

    System.out.println(climber.getRightClimberArmPosition());
  }

  @Override
  public boolean isFinished() {
    if (pid.climberArmAtSetPoint()) {
      climber.setRightClimberArmEncoder(0);
      pid.climberArmReset();
      System.out.println("Finished PID thing");
      done = true;
    }
    return done;
  }
}

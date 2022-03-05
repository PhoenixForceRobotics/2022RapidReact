package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSystem;
import frc.robot.subsystems.PID;

public class RunIntakeRotator extends CommandBase {

  private PID pid;
  private IntakeSystem intakeSystem;

  private double rotationValue;
  private double tolerance;
  private boolean done;
  private double pidSpeed;
  private double motorSpeed;
  private double maxSpeed;

  public RunIntakeRotator(
      IntakeSystem m_intakeSystem,
      PID m_pid,
      double amountOfRotation,
      double toleranceValue,
      double maxMotorSpeed) {
    intakeSystem = m_intakeSystem;
    pid = m_pid;
    rotationValue = amountOfRotation;
    tolerance = toleranceValue;
    maxSpeed = maxMotorSpeed;

    done = false;
  }

  @Override
  public void initialize() {
    System.out.println("Button of Automated Intake thing got pressed");
    // climber.spoolCoast();
    intakeSystem.setRotatorEncoder(0);
    pid.intakeRotatorReset();
    pid.intakeRotatorSetSetPoint(rotationValue);
    pid.intakeRotatorSetTolerance(tolerance);

    done = false;
  }

  @Override
  public void execute() {
    pidSpeed = pid.intakeRotatorCalculate(intakeSystem.getRotatorEncoderPosition());
    motorSpeed = Math.min(Math.abs(pidSpeed), 0.1);
    if (pidSpeed > 0) {
      motorSpeed = Math.min(pidSpeed, maxSpeed);
    } else {
      motorSpeed = Math.max(pidSpeed, maxSpeed * -1);
    }
    intakeSystem.setRotatorMotorSpeed(motorSpeed);
    System.out.println(intakeSystem.getRotatorEncoderPosition());
  }

  @Override
  public boolean isFinished() {
    if (pid.intakeRotatorAtSetPoint()) {
      intakeSystem.setRotatorEncoder(0);
      pid.intakeRotatorReset();
      System.out.println("Finished PID thing");
      done = true;
    }
    return done;
  }
}

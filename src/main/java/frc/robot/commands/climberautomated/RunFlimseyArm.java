package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.PID;

public class RunFlimseyArm extends CommandBase {

  private Climber climber;
  private PID pid;

  private double rotationValue;
  private double tolerance;
  private boolean done;
  private double pidSpeed;
  private double motorSpeed;
  private double maxSpeed;

  public RunFlimseyArm(
      Climber m_climber,
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

    climber.setFlimseyArmEncoder(0);
    pid.printThing();
    pid.flimseyReset();
    pid.flimseySetSetPoint(rotationValue);
    pid.flimseySetTolerance(tolerance);

    done = false;
  }

  @Override
  public void execute() {
    pidSpeed = pid.flimseyCalculate(climber.getFlimseyArmPosition());
    if (pidSpeed > 0) {
      motorSpeed = Math.min(pidSpeed, maxSpeed);
    } else {
      motorSpeed = Math.max(pidSpeed, maxSpeed * -1);
    }
    climber.setFlimseyMotorSpeed(motorSpeed);

    System.out.println(climber.getFlimseyArmPosition());
  }

  @Override
  public boolean isFinished() {
    if (pid.flimseyAtSetPoint()) {
      climber.setFlimseyArmEncoder(0);
      pid.flimseyReset();
      System.out.println("Finished PID thing");
      done = true;
    }
    return done;
  }
}

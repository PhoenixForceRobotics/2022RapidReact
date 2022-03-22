package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shuttle;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;

public class RunStopIntakeMotors extends CommandBase {
  private Intake intakesystem;
  private Shuttle shuttle;
  private PFRController operator;

  public RunStopIntakeMotors(Intake intakesystem, Shuttle shuttle, OI oi) {
    this.intakesystem = intakesystem;
    this.shuttle = shuttle;
    this.operator = oi.operatorController;
    this.intakesystem.intakeMotorBrake();
  }

  @Override
  public void initialize() {

    // Checks if the shooter is not being pressed
    if (operator.getRightTriggerAxis() < 0.1) {
      shuttle.setshuttleMotor(0);
    }
    intakesystem.setIntakeMotor(0);
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

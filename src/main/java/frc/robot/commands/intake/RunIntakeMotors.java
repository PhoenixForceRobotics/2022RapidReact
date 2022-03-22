package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shuttle;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;

public class RunIntakeMotors extends CommandBase {
  private Intake intakesystem;
  private Shuttle shuttle;
  private PFRController operator;

  // add requirments for up 90

  public RunIntakeMotors(Intake intakesystem, Shuttle shuttle, OI oi) {
    this.intakesystem = intakesystem;
    this.shuttle = shuttle;
    this.operator = oi.operatorController;
    this.intakesystem.intakeMotorBrake();
  }

  @Override
  public void initialize() {
    // Checks if the button is still being pressed
    if (operator.getLeftTriggerAxis() > 0.1) {
      shuttle.setshuttleMotor(0.1);
      intakesystem.setIntakeMotor(0.1);
    }
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

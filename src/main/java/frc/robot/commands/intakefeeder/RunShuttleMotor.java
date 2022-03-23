package frc.robot.commands.intakefeeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shuttle;
import frc.robot.utils.Constants;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;

public class RunShuttleMotor extends CommandBase {
  private Shuttle shuttle;
  private PFRController operator;

  public RunShuttleMotor(Shuttle m_shuttle, OI oi) {
    operator = oi.operatorController;
    shuttle = m_shuttle;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {

    // Checks which button is pressed
    if (operator.getRightTriggerAxis() < 0.1 || operator.getLeftTriggerAxis() < 0.1) {
      shuttle.setShuttleMotor(Constants.FeederIntakeConstants.SHUTTLE_SPEED);
    } else {
      shuttle.setShuttleMotor(0);
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

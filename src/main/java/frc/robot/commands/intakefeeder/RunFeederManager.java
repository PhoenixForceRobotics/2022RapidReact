package frc.robot.commands.intakefeeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;
import frc.robot.utils.Constants;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;

public class RunFeederManager extends CommandBase {
  private Feeder feeder;
  private PFRController operator;

  public RunFeederManager(Feeder m_feeder, OI oi) {
    operator = oi.operatorController;
    feeder = m_feeder;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {

    // Checks which button is pressed
    // Feeds ball into
    if (operator.getRightY() > 0.1) {
      feeder.setTransporterTop(Constants.FeederIntakeConstants.TRANSPORTER_TOP_SPEED);
      feeder.setTransporterBottom(Constants.FeederIntakeConstants.TRANSPORTER_BOTTOM_SPEED);
      feeder.setOutake(-1 * Constants.FeederIntakeConstants.OUTAKE);
      // Shifts ball left
    } else if (operator.getLeftBumper() == true) {
      feeder.setTransporterTop(Constants.FeederIntakeConstants.TRANSPORTER_TOP_SPEED);
      feeder.setTransporterBottom(Constants.FeederIntakeConstants.TRANSPORTER_BOTTOM_SPEED);
      feeder.setOutake(Constants.FeederIntakeConstants.OUTAKE_SPEED);
      // Shifts ball right
    } else if (operator.getRightBumper() == true) {
      feeder.setTransporterTop(-1 * Constants.FeederIntakeConstants.TRANSPORTER_TOP_SPEED);
      feeder.setTransporterBottom(-1 * Constants.FeederIntakeConstants.TRANSPORTER_BOTTOM_SPEED);
      feeder.setOutake(-1 * Constants.FeederIntakeConstants.OUTAKE_SPEED);
    } else {
      feeder.setTransporterTop(0);
      feeder.setTransporterBottom(0);
      feeder.setOutake(0);
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

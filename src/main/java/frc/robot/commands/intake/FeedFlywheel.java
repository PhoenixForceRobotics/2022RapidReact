package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.utils.Constants.IntakeConstants;

public class FeedFlywheel extends CommandBase {
  private Intake intake;

  public FeedFlywheel(Intake intake) {
    this.intake = intake;
  }

  @Override
  public void initialize() {
    intake.setTransport(-1, -1);
    intake.setCollector(1); // Acts as a feeder
    intake.setBelt(IntakeConstants.BELT_SPEED); // TODO: Constants
  }

  @Override
  public void end(boolean interrupted) {
    intake.zeroAllMotors();
  }
}

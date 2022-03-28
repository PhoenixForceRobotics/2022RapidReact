package frc.robot.commands.intakefeeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;
import frc.robot.utils.Constants;

public class RunCollectorMotor extends CommandBase {
  private Collector shuttle;
  private boolean isReversed;

  public RunCollectorMotor(Collector collector, boolean isReversed) {
    this.shuttle = collector;
    this.isReversed = isReversed;
  }

  @Override
  public void initialize() {
    double reverser = isReversed ? -1 : 1;
    shuttle.setCollectorMotor(reverser * Constants.FeederIntakeConstants.SHUTTLE_SPEED);
  }

  @Override
  public void end(boolean interrupted) {
    shuttle.setCollectorMotor(0);
  }
}

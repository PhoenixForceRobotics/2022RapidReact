package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.utils.Constants.IntakeConstants;

public class JiggleBelt extends CommandBase {
  private Intake intake;
  private Timer timer;
  private double reverse;

  public JiggleBelt(Intake intake) {
    this.intake = intake;
    reverse = 1;
    timer = new Timer();
  }

  @Override
  public void initialize() {
    timer.start();
  }

  @Override
  public void execute() {
    if (timer.get() >= IntakeConstants.SWITCH_FREQUENCY) {
      reverse = reverse == 1 ? -1 : 1;
      timer.reset();
    }

    intake.setBelt(IntakeConstants.BELT_SPEED * reverse);
  }

  @Override
  public void end(boolean interrupted) {
    intake.setBelt(0);
  }
}

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class CollectorOut extends CommandBase {
  private Intake intake;
  private Timer timer;
  private double reverse;

  public CollectorOut(Intake intake) {
    this.intake = intake;
    reverse = 1;
    timer = new Timer();
    addRequirements(intake);
  }

  @Override
  public void initialize() {
    intake.collectorForward();
    intake.setCollector(0.5);

    // timer.start();
  }

  @Override
  public void execute() {
    // if (timer.get() >= IntakeConstants.SWITCH_FREQUENCY) {
    //   reverse = reverse == 1 ? -1 : 1;
    //   timer.reset();
    // }

    // intake.setBelt(IntakeConstants.BELT_SPEED * reverse); // TODO: set constant for this
  }

  @Override
  public void end(boolean interrupted) {
    intake.collectorReverse();
    intake.zeroAllMotors();
  }
}

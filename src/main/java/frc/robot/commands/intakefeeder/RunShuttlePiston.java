package frc.robot.commands.intakefeeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shuttle;

public class RunShuttlePiston extends CommandBase {
  private Shuttle shuttle;
  private boolean forward;

  public RunShuttlePiston(Shuttle m_shuttle, boolean m_forward) {
    shuttle = m_shuttle;
    forward = m_forward;
  }

  @Override
  public void initialize() {
    if (forward == true) {
      shuttle.setShuttleExtenderForward();
    }
    shuttle.setShuttleExtenderReverse();
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

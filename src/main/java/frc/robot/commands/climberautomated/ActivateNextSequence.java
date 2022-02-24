package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ActivateNextSequence extends CommandBase {

  private Climber climber;

  public ActivateNextSequence(Climber m_climber) {
    climber = m_climber;
  }

  @Override
  public void initialize() {
    climber.setActivateNextSequence(true);
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

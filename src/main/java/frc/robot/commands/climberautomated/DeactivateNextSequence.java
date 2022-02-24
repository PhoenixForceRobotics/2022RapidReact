package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class DeactivateNextSequence extends CommandBase {

  private Climber climber;

  public DeactivateNextSequence(Climber m_climber) {
    // Use requires() here to declare subsystem dependencies
    climber = m_climber;
  }

  @Override
  public void initialize() {
    climber.setActivateNextSequence(false);
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberMotors;

public class ActivateNextSequence extends CommandBase {

  private ClimberMotors climber;

  public ActivateNextSequence(ClimberMotors m_climber) {
    climber = m_climber;
  }

  @Override
  public void initialize() {
    climber.setActivateNextSequence(true);
  }

  @Override
  public void execute() {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

package frc.robot.commands.climbermanual;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ActivatePistons extends CommandBase {

  private Climber climber;

  public ActivatePistons(Climber m_climber) {
    climber = m_climber;
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    climber.toggle();
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

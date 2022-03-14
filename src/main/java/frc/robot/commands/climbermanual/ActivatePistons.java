package frc.robot.commands.climbermanual;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSolenoids;

public class ActivatePistons extends CommandBase {

  private ClimberSolenoids climber;

  public ActivatePistons(ClimberSolenoids m_climber) {
    climber = m_climber;
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    climber.toggle();
  }

  @Override
  public void execute() {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

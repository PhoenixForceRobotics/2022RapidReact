package frc.robot.commands.climbermanual;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class FlimseyStop extends CommandBase {
  private Climber climber;

  public FlimseyStop(Climber m_climber) {
    climber = m_climber;
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    climber.setFlimseyMotorSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

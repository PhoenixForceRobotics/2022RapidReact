package frc.robot.commands.climbermanual;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class FlimseyBackward extends CommandBase {
  private Climber climber;

  public FlimseyBackward(Climber m_climber) {
    climber = m_climber;
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    climber.setFlimseyMotorSpeed(-0.1);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

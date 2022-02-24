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
    boolean statusOfLevation = climber.getLevitateStatus();
    if (statusOfLevation == true) {
      climber.stopLevitate();
      climber.setLevitateStatus(false);
    } else {
      climber.Levitate();
      climber.setLevitateStatus(true);
    }
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return false;
  }
}

package frc.robot.commands.climbermanual;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class FlimseyForward extends CommandBase {
  private Climber climber;

  public FlimseyForward(Climber m_climber) {
    climber = m_climber;
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    climber.setFlimseyMotorSpeed(0.1);
    System.out.println("vroom");
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

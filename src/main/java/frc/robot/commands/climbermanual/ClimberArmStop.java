package frc.robot.commands.climbermanual;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberMotors;

public class ClimberArmStop extends CommandBase {
  private ClimberMotors climber;

  public ClimberArmStop(ClimberMotors m_climber) {
    climber = m_climber;
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    climber.setClimberArmMotorSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

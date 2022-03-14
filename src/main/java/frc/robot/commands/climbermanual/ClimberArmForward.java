package frc.robot.commands.climbermanual;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberMotors;

public class ClimberArmForward extends CommandBase {
  private ClimberMotors climber;

  public ClimberArmForward(ClimberMotors m_climber) {
    climber = m_climber;
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    climber.setClimberArmMotorSpeed(0.1);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

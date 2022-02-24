package frc.robot.commands.climbermanual;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSystem;

public class IntakeRotatorForward extends CommandBase {
  private IntakeSystem intake;

  public IntakeRotatorForward(IntakeSystem m_intake) {
    intake = m_intake;
  }

  @Override
  public void initialize() {
    intake.setRotatorMotorSpeed(0.1);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

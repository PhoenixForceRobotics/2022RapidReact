package frc.robot.commands.intakefeedertest;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shuttle;

public class RunJustShuttle extends CommandBase {
  private Shuttle shuttle;
  private double speed;

  public RunJustShuttle(Shuttle m_shuttle, double m_speed) {
    shuttle = m_shuttle;
    speed = m_speed;
  }

  @Override
  public void initialize() {
    shuttle.setShuttleMotor(speed);
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return false;
  }
}

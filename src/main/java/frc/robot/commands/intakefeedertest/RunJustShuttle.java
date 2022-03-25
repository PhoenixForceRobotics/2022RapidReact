package frc.robot.commands.intakefeedertest;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class RunJustShuttle extends CommandBase {
  private Collector shuttle;
  private double speed;

  public RunJustShuttle(Collector m_shuttle, double m_speed) {
    shuttle = m_shuttle;
    speed = m_speed;
  }

  @Override
  public void initialize() {
    shuttle.setCollectorMotor(speed);
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

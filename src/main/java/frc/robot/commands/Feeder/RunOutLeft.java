package frc.robot.commands.Feeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class RunOutLeft extends CommandBase {
  private Feeder feeder;
  private double speed;

  // add requirments for up 90

  public RunOutLeft(Feeder m_feeder, double m_speed) {
    feeder = m_feeder;
    speed = m_speed;
  }

  @Override
  public void initialize() {
    feeder.setTransporterTop(speed);
    feeder.setTransporterBottom(speed);
    feeder.setOutake(speed);
  }

  @Override
  public void execute() {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

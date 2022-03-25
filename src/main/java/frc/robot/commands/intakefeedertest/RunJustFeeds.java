package frc.robot.commands.intakefeedertest;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class RunJustFeeds extends CommandBase {
  private Feeder feeder;
  private double speed;

  public RunJustFeeds(Feeder m_feeder, double m_speed) {
    feeder = m_feeder;
    speed = m_speed;
  }

  @Override
  public void initialize() {
    System.out.println("Just feeds was called");
    feeder.setOutake(speed);
    feeder.setTransporterTop(speed);
    feeder.setTransporterBottom(speed);
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

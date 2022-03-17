package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Outake;
import frc.robot.utils.OI;

public class RunRobot extends CommandBase {
  public Feeder feeder;
  public Outake outake;
  public OI oi;

  public RunRobot(OI oi, Feeder feeder, Outake outake) {
    this.feeder = feeder;
    this.oi = oi;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    feeder.SetFeeder();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

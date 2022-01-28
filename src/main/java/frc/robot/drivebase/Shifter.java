package frc.robot.drivebase;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivebase;

public class Shifter extends CommandBase {
  private Drivebase drivebase;

  public Shifter(Drivebase m_drivebase) {
    drivebase = m_drivebase;
    addRequirements(m_drivebase);
  }

  @Override
  public void initialize() {
    drivebase.shift();
  }

  @Override
  public void execute() {
    Robot.addDriveBase();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}

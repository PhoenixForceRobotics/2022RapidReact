package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class DriveForward extends CommandBase {
  private Drivebase drivebase;
  private double distance;

  public DriveForward(Drivebase drivebase, double distance) {
    this.drivebase = drivebase;
    this.distance = distance;
    drivebase.resetEncoders();
  }

  @Override
  public void initialize() {
    drivebase.resetEncoders();

    System.out.println("Starting forward: " + distance);
    drivebase.set(0.2, 0.2);
    drivebase.resetEncoders();
  }

  @Override
  public void execute() {
    drivebase.set(0.2, 0.2);
    System.out.println("Encoder: " + drivebase.getLeftEncoder().getPosition());
  }

  @Override
  public boolean isFinished() {
    // TODO Auto-generated method stub
    return drivebase.getLeftEncoder().getPosition() > distance;
  }

  @Override
  public void end(boolean interrupted) {

    System.out.println("Done with Forward");
    drivebase.set(0, 0);
    drivebase.resetEncoders();
  }
}

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class TurnAround extends CommandBase {
  private Drivebase drivebase;
  private double startingAngle;

  public TurnAround(Drivebase drivebase) {
    this.drivebase = drivebase;
  }

  @Override
  public void initialize() {
    // TODO Auto-generated method stub
    startingAngle = drivebase.getHeading();
    drivebase.set(-0.3, 0.3);
  }

  @Override
  public void execute() {
    System.out.println(drivebase.getHeading());
    drivebase.set(-0.25, 0.25);
  }

  @Override
  public boolean isFinished() {
    return !(startingAngle - 180 < drivebase.getHeading()
        && drivebase.getHeading() < startingAngle + 180);
  }

  @Override
  public void end(boolean interrupted) {

    System.out.println("Done with turn");
    drivebase.tankDrive(0, 0);
  }
}

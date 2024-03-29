package frc.robot.commands.drivebase;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;

public class RunDrivebase extends CommandBase {
  private Drivebase drivebase;

  private PFRController driver;

  public RunDrivebase(Drivebase drivebase, OI oi) {

    this.drivebase = drivebase;
    driver = oi.driverController;
    addRequirements(drivebase);
  }

  @Override
  public void initialize() {
    System.out.println("Starting Drivebase!\n");
  }

  @Override
  public void execute() {
    drivebase.arcadeDrive(-driver.getLeftY(), driver.getRightX());
  }
}

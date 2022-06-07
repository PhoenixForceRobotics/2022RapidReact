package frc.robot.commands.drivebase;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;
import frc.robot.utils.Constants.DriveConstants;

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
    drivebase.arcadeDrive(Math.pow(-driver.getLeftY(), DriveConstants.STICK_POWER), Math.pow(driver.getRightX(), DriveConstants.STICK_POWER));
  }
}

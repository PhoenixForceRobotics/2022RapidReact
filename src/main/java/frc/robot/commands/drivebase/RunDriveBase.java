package frc.robot.commands.drivebase;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.utils.OI;
import frc.robot.utils.controllers.BobXboxController;

public class RunDrivebase extends CommandBase {
  private Drivebase drivebase;

  private BobXboxController driver;
  private boolean isSpinningOut;

  public RunDrivebase(Drivebase drivebase, OI oi) {

    this.drivebase = drivebase;
    driver = oi.driverController;
    addRequirements(drivebase);
  }

  @Override
  public void execute() {
    drivebase.set(driver.leftStick.getY(), driver.leftStick.getY());

    isSpinningOut =
        drivebase.getAccelerometerAcceleration().magnitude() + 5
            < drivebase.getPoseAcceleration().magnitude();
    // TODO: Add reasonable constant that allows for some slack?
    // TODO: put out visible error for the driver

  }
}

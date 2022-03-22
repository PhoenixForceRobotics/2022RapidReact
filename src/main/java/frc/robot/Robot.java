// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.drivebase.RunDrivebase;
import frc.robot.commands.feeder.RunOutake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Turret;
import frc.robot.utils.OI;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // Declare "Subsystems" here
  // public static Intake intake;
  // public static Drivebase drivebase;
  public static Turret turret;
  // public static Climber climber;

  // Declare "OI" here
  public static OI oi;

  // Declare "Commands" here
  // public static RunDrivebase runDrivebase;
  // public static RunOutake runOutake;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // feeder = new Feeder();

    // climb = new Climb();
    // pneumaticsControlModule = new PneumaticsControlModule(0);
    // compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    // powerDistribution = new PowerDistribution();

    // pneumaticsControlModule.clearAllStickyFaults();
    // powerDistribution.clearStickyFaults();
    // drivebase = new Drivebase();
    // flywheel = new Turret();
    // intake = new Intake();
    // climber = new Climber();
    turret = new Turret();
    oi = new OI();

    // runOutake = new RunOutake(feeder, oi);
    // runDrivebase = new RunDrivebase(drivebase, oi);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {}

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    CommandScheduler.getInstance().cancelAll();
    // runDrivebase.schedule();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}

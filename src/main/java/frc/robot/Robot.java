// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.FlywheelPID;
import frc.robot.commands.drivebase.RunDrivebase;
import frc.robot.commands.hood.FlywheelHoodSequence;
import frc.robot.commands.intake.intakeWheelMove;
import frc.robot.commands.turn.FlywheelTurnSequence;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.IntakeMotors;
import frc.robot.subsystems.IntakePistons;
import frc.robot.utils.FlywheelMath;
import frc.robot.utils.OI;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // Declare "Subsystems" here
  public static IntakePistons intakepistons;
  public static IntakeMotors intakemotors;
  public static Drivebase drivebase;
  public static Flywheel flywheel;
  public static Climber climber;

  // Declare "OI" here
  public static OI oi;

  // Declare "Commands" here
  public static FlywheelPID flywheelPID;
  public static FlywheelTurnSequence flywheelTurnSequence;
  public static FlywheelHoodSequence flywheelHoodSequence;
  public static RunDrivebase runDrivebase;
  public static intakeWheelMove intakewheelmove;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    drivebase = new Drivebase();
    flywheel = new Flywheel();
    intakepistons = new IntakePistons();
    intakemotors = new IntakeMotors();
    climber = new Climber();
    oi = new OI();

    runDrivebase = new RunDrivebase(drivebase, oi);
    flywheelPID = new FlywheelPID(flywheel, FlywheelMath.getVelocity());
    flywheelTurnSequence = new FlywheelTurnSequence(flywheel);
    flywheelHoodSequence = new FlywheelHoodSequence(flywheel);
    intakewheelmove = new intakeWheelMove(Robot.intakemotors, Robot.oi);
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
    runDrivebase.schedule();
    flywheelPID.schedule();
    flywheelTurnSequence.schedule();
    flywheelHoodSequence.schedule();
    intakewheelmove.schedule();
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

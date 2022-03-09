// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2097;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.team2097.commands.FlywheelHood;
import frc.team2097.commands.FlywheelTurn;
import frc.team2097.subsystems.Flywheel;
import frc.team2097.utility.OI;
import frc.team2097.utility.PID;
import frc.team2097.commands.FlywheelPID;
import frc.team2097.commands.FlywheelHoodReset;
import frc.team2097.utility.FlywheelMath;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  public static Flywheel flywheel;
  public static OI oi;

  public static PID pid;

  public static FlywheelPID flywheelPID;
  public static FlywheelTurn flywheelTurn;
  public static FlywheelHood flywheelHood;
  public static FlywheelHoodReset flywheelHoodReset;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    flywheel = new Flywheel();

    // Alex PID edition

    pid = new PID();
    flywheelPID = new FlywheelPID(flywheel, FlywheelMath.getVelocity());
    flywheelTurn = new FlywheelTurn(flywheel);
    flywheelHoodReset = new FlywheelHoodReset(flywheel);
    flywheelHood = new FlywheelHood(flywheel);

    oi = new OI();

  }

  public static void addFlywheelTurn() {
    flywheelTurn.schedule();
  }

  public static void addFlywheelPID() {
    flywheelPID.schedule();
  }

  public static void addFlywheelHood() {
    flywheelHood.schedule();
  }

  public static void addFlywheelHoodReset() {
    flywheelHoodReset.schedule();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and
   * test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  public static void clearScheduler() {
    CommandScheduler.getInstance().cancelAll();
  }

  public static void addDriveBase() {

  }

  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different
   * autonomous modes using the dashboard. The sendable chooser code works with
   * the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the
   * chooser code and
   * uncomment the getString line to get the auto name from the text box below the
   * Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure
   * below with additional strings. If using the SendableChooser make sure to add
   * them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    CommandScheduler.getInstance().registerSubsystem(flywheel);
    addFlywheelHood();
    addFlywheelHoodReset();
    addFlywheelTurn();
    addFlywheelPID();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }
}
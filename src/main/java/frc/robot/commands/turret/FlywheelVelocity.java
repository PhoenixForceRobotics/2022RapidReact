package frc.robot.commands.turret;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Turret;
import frc.robot.utils.OI;

public class FlywheelVelocity extends CommandBase {
  private Turret turret;

  private PIDController pid;
  private SimpleMotorFeedforward feedforward;
  private ShuffleboardTab tab;
  private NetworkTableEntry kp, ki, kd;

  public FlywheelVelocity(Turret turret, OI oi) {
    this.turret = turret;

    pid = new PIDController(0.005, 0, 0);

    tab = Shuffleboard.getTab("Velocity PID");
    kp = tab.add("P", 0.01).getEntry();
    ki = tab.add("I", 0).getEntry();
    kd = tab.add("D", 0).getEntry();
    feedforward = new SimpleMotorFeedforward(0.25796, 0.1, 0.02314);
  }

  @Override
  public void initialize() {
    pid.setSetpoint(5000); // TODO: Finalize units
  }

  @Override
  public void execute() {
    pid.setP(kp.getDouble(0));
    pid.setI(ki.getDouble(0));
    pid.setD(kd.getDouble(0));
    System.out.println("Running Flywheel");
    turret.setFlywheelPercent(
        // pid.calculate(turret.getFlywheelVelocity()
        // + feedforward.calculate(2500)));
        Robot.oi.driverController.getLeftTriggerAxis());
    // Currently just percentage from trigger
  }

  @Override
  public void end(boolean interrupted) {
    turret.setFlywheelPercent(0);
  }
}

package frc.robot.commands.turret;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.utils.Constants.TurretConstants;
import frc.robot.utils.NetworkTableManager;
import frc.robot.utils.OI;

public class SetHoodToTargetAngle extends CommandBase {
  NetworkTableManager networkTableManager;

  private Turret turret;
  private OI oi;

  private PIDController pid;

  public SetHoodToTargetAngle(Turret turret, OI oi) {
    this.turret = turret;
    this.oi = oi;

    pid = new PIDController(0.03, 0, 0);
    pid.setTolerance(0.1, 0.1);
  }

  @Override
  public void initialize() {
    pid.setSetpoint(85);
  }

  @Override
  public void execute() {
    // TODO: Ask Emily whether this accounts for the turret angle
    // Not Yet  :,) - Emily

    turret.setHood(MathUtil.clamp(pid.calculate(turret.getHoodPosition()), -0.1, 0.1));
    System.out.println("Perror: " + pid.getPositionError() + ", At Setpoint: " + pid.atSetpoint());

    // Check for changes in hood angle
    double povAngle = oi.operatorController.getPOV();

    if (povAngle == 0) {
      pid.setSetpoint(TurretConstants.FLYWHEEL_LOW);
    } else if (povAngle == 180) {
      pid.setSetpoint(TurretConstants.FLYWHEEL_HIGH);
    } else if (povAngle == 270) {
      pid.setSetpoint(85);
    } else if (povAngle == 90) {
      pid.setSetpoint(65);
    }
  }
}

package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.utils.Constants.TurretConstants;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;

public class TurretManualTurn extends CommandBase {
  private Turret turret;
  private PFRController operator;

  public TurretManualTurn(Turret turret, OI oi) {
    this.turret = turret;
    this.operator = oi.operatorController;
    addRequirements(turret);
  }

  @Override
  public void execute() {
    turret.setRotation(
        Math.pow(operator.getLeftX(), TurretConstants.STICK_POWER) * TurretConstants.ROTATE_SPEED);
  }

  @Override
  public void end(boolean interrupted) {
    turret.setRotation(0);
  }
}

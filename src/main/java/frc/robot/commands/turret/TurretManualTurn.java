package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.utils.Constants.TurretConstants;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;

public class TurretManualTurn extends CommandBase {
  private Turret flywheel;
  private PFRController operator;

  public TurretManualTurn(Turret flywheel, OI oi) {
    this.flywheel = flywheel;
    this.operator = oi.operatorController;
  }

  @Override
  public void execute() {
    flywheel.setRotation(
        Math.pow(operator.getLeftX(), TurretConstants.STICK_POWER) * TurretConstants.ROTATE_SPEED);
  }
}

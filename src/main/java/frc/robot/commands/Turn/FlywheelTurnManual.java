package frc.robot.commands.Turn;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
import frc.robot.utility.Constants;
import frc.robot.utility.OI;

public class FlywheelTurnManual extends CommandBase {
    private Flywheel flywheel;
    private OI oi;
    public FlywheelTurnManual(Flywheel flywheel, OI oi) {
        this.flywheel = flywheel;
        this.oi = oi;
    } 
   
    @Override
    public void initialize() {
    }
   
    @Override
    public void execute() {
        if (oi.operatorController.getLeftStickButton()) {
            flywheel.resetFWRotateEncoder();
        }
        flywheel.setFlywheelRotate(oi.operatorController.getLeftX() * Constants.MotorSpeeds.Flywheel.ROTATE_SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

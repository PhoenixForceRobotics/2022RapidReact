package frc.team2097.commands.Turn;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2097.subsystems.Flywheel;
import frc.team2097.utility.Constants;
import frc.team2097.utility.OI;

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
        if (oi.operatorController.xButton().get()) {
            flywheel.resetFWRotateEncoder();
        }
        flywheel.setFlywheelRotate(oi.operatorController.getLeftX() * Constants.MotorSpeeds.Flywheel.ROTATE_SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

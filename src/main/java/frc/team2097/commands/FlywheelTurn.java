package frc.team2097.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2097.utility.Constants;
import frc.team2097.utility.NetworkTableManager;
import frc.team2097.subsystems.Flywheel;


public class FlywheelTurn extends CommandBase {
    
    private Flywheel flywheel;
    private double buffer;
    private double xCoordinate;
    private int reverse;
    private boolean turnAround;

    private double threeFourths;


    

    public FlywheelTurn(Flywheel flywheel) {
        this.flywheel = flywheel;
        buffer = Constants.SubsystemMath.FlywheelMath.ROTATE_BUFFER;
        reverse = 1;
        turnAround = false;
        threeFourths = 120;

        
    }

    @Override
    public void initialize() {
        flywheel.resetFWRotateEncoder();
        xCoordinate = NetworkTableManager.getACSXCoordinate();
    }

    @Override
    public void execute() {
        xCoordinate = NetworkTableManager.getACSXCoordinate();
        if(xCoordinate == 5){
            flywheel.setFlywheelRotate(Constants.MotorSpeeds.Flywheel.ROTATE_SPEED * reverse);
        } else if(xCoordinate >= buffer && xCoordinate <= -1 * buffer) {
            flywheel.setFlywheelRotate(Constants.MotorSpeeds.Flywheel.ROTATE_SPEED * xCoordinate * .75 * reverse);
        } else {
            flywheel.setFlywheelRotate(0);
        }

        if(turnAround) {
            if(flywheel.getFWRotateEncoderPosition() <= -threeFourths) {
                reverse = 1;
                turnAround = false;
            }
        } else {
            if(flywheel.getFWRotateEncoderPosition() >= threeFourths) {
                reverse = -1;
                turnAround = true;
            }
        }


   }

    @Override
    public boolean isFinished() {
        return false;
    }
}

package frc.team2097.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
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

    private double maxRotate;
<<<<<<< HEAD
=======

    private NetworkTable table;
    private NetworkTableEntry ACSX;
>>>>>>> e9a641dd1a8f69b2bb9b63d0759dc1f386fd5587

    public FlywheelTurn(Flywheel flywheel) {
        this.flywheel = flywheel;
        buffer = Constants.SubsystemMath.FlywheelMath.ROTATE_BUFFER;
        turnAround = false;
<<<<<<< HEAD
        maxRotate = 2.0 / 3 * 65;
=======
        reverse = 1;

        table = NetworkTableInstance.getDefault().getTable("PiVisionData");
        ACSX = table.getEntry("ACSX");
>>>>>>> e9a641dd1a8f69b2bb9b63d0759dc1f386fd5587

    }

    @Override
    public void initialize() {
        maxRotate = (2.0 / 3) * 65 / 2;
        flywheel.resetFWRotateEncoder();

    }

    @Override
    public void execute() {
        xCoordinate = ACSX.getDouble(5);
        if (xCoordinate == 5) {
            flywheel.setFlywheelRotate(Constants.MotorSpeeds.Flywheel.ROTATE_SPEED * reverse);
        } else if (xCoordinate >= buffer || xCoordinate <= -1 * buffer) {
            flywheel.setFlywheelRotate(Constants.MotorSpeeds.Flywheel.ROTATE_SPEED * xCoordinate * .75 * reverse);
        } else {
            flywheel.setFlywheelRotate(0);
        }

        System.out.println("rotations:" + flywheel.getFWRotateEncoderPosition());
        System.out.println("x-coordinate:" + xCoordinate);

        if (turnAround) {
            if (flywheel.getFWRotateEncoderPosition() <= -maxRotate) {
                reverse = 1;
                turnAround = false;
            }
        } else {
            if (flywheel.getFWRotateEncoderPosition() > maxRotate) {
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

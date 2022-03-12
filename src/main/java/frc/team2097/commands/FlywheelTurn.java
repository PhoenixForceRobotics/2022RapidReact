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

    private NetworkTable table;
    private NetworkTableEntry ACSX;

    public FlywheelTurn(Flywheel flywheel) {
        this.flywheel = flywheel;
        buffer = Constants.SubsystemMath.FlywheelMath.ROTATE_BUFFER;
        turnAround = false;
        reverse = 1;

        table = NetworkTableInstance.getDefault().getTable("PiVisionData");
        ACSX = table.getEntry("ACSX");

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

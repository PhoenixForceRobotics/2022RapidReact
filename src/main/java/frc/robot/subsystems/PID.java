package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.util.Map;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class PID extends SubsystemBase {

    PIDController spoolPID;
    PIDController flimseyPID;

    double spoolKp = 0.5;
    double spoolKi = 0;
    double spoolKd = 0;

    double flimseyKp = 0.5;
    double flimseyKi = 0;
    double flimseyKd = 0;




    private ShuffleboardTab tab = Shuffleboard.getTab("Climber PID");

    private NetworkTableEntry spoolKpEntry = tab.add("spoolKp", spoolKp)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 1)) // specify widget properties here
            .getEntry();

    private NetworkTableEntry spoolKiEntry = tab.add("spoolKi", spoolKi)
            .getEntry();
    private NetworkTableEntry spoolKdEntry = tab.add("spoolKd", spoolKd)
            .getEntry();

    private NetworkTableEntry flimseyKpEntry = tab.add("flimseyKp", flimseyKp)
            .getEntry();
    private NetworkTableEntry flimseyKiEntry = tab.add("flimseyKi", flimseyKi)
            .getEntry();
    private NetworkTableEntry flimseyKdEntry = tab.add("flimseyKd", flimseyKd)
            .getEntry();

    public PID() {
        // change values, need to test to find the right values.
        flimseyPID = new PIDController(flimseyKp, flimseyKi, flimseyKd);
        spoolPID = new PIDController(spoolKp, spoolKi, spoolKd);
    }

    public double flimseyCalculate(double measurement) {
        flimseyKp = flimseyKpEntry.getDouble(1.0);
        flimseyKi = flimseyKiEntry.getDouble(1.0);
        flimseyKd = flimseyKdEntry.getDouble(1.0);

        flimseyPID.setP(flimseyKp);
        flimseyPID.setI(flimseyKi);
        flimseyPID.setD(flimseyKd);

        return flimseyPID.calculate(measurement);
    }

    public boolean flimseyAtSetPoint() {
        return flimseyPID.atSetpoint();
    }

    public void flimseySetSetPoint(double setPoint) {
        flimseyPID.setSetpoint(setPoint);
    }

    public void flimseySetTolerance(double tolerance) {
        flimseyPID.setTolerance(tolerance);
    }

    public void flimseyReset() {
        flimseyPID.reset();
    }

    public double spoolCalculate(double measurement) {
        spoolKp = spoolKpEntry.getDouble(1.0);
        spoolKi = spoolKiEntry.getDouble(1.0);
        spoolKd = spoolKdEntry.getDouble(1.0);

        spoolPID.setP(spoolKp);
        spoolPID.setI(spoolKi);
        spoolPID.setD(spoolKd);
        return spoolPID.calculate(measurement);
    }

    public boolean spoolAtSetPoint() {
        return spoolPID.atSetpoint();
    }

    public void spoolSetSetPoint(double setPoint) {
        spoolPID.setSetpoint(setPoint);
    }

    public void spoolSetTolerance(double tolerance) {
        spoolPID.setTolerance(tolerance);
    }

    public void spoolReset() {
        spoolPID.reset();
    }

}

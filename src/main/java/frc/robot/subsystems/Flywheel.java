package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.utility.Motor;

public class Flywheel extends SubsystemBase{

    public Motor flywheelRotate; // Neo
    public Motor flywheelLeft, flywheelRight; // Falcons
    public Motor flywheelHood; // Neo 550

    public Flywheel() {
        flywheelRotate = new Motor(Constants.MotorMap.Flywheel.ROTATE, MotorType.kBrushless, Constants.MotorMap.Flywheel.ROTATE_REVERSED, 40);
    }
}
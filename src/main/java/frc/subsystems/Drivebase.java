package frc.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.utils.SparkMotorGroup;

public class Drivebase extends SubsystemBase {
    
    private SparkMotorGroup left;
    private SparkMotorGroup right;    
    private DifferentialDrive differentialDrive;

    public Drivebase()
    {
        left = new SparkMotorGroup(
            true, 
            new CANSparkMax(2, MotorType.kBrushless), 
            new CANSparkMax(14, MotorType.kBrushless)
        );
        right = new SparkMotorGroup(
            false, 
            new CANSparkMax(4, MotorType.kBrushless),
            new CANSparkMax(15, MotorType.kBrushless)
        );
    }

    public void set(double leftPercentage, double rightPercentage)
    {
        left.set(leftPercentage);
        right.set(rightPercentage);
    }

    public SparkMotorGroup getLeft() {
        return left;
    }

    public SparkMotorGroup getRight() {
        return right;
    }

    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }
}

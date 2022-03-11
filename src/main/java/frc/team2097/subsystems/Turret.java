package frc.team2097.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase{
    public CANSparkMax rotation;

    public Turret()
    {
        rotation = new CANSparkMax(8, MotorType.kBrushless);
    }

    public void rotate(double speed)
    {
        rotation.set(speed);
    }
}

package frc.robot.utils;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class Motor extends CANSparkMax {
    public Motor(int port, CANSparkMaxLowLevel.MotorType theMotorType, boolean reversed, int currentLimit) {
        super(port, theMotorType);
        setInverted(reversed);
        setSmartCurrentLimit(currentLimit);
    }
}
package frc.robot.utils;

import com.revrobotics.CANSparkMax;

public class Motor extends CANSparkMax {
  public Motor(int port, MotorType theMotorType, boolean reversed) {
    super(port, theMotorType);
    setInverted(reversed);
  }
}

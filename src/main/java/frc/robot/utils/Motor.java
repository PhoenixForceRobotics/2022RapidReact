package frc.robot.utils;

import com.revrobotics.CANSparkMax;

public class Motor extends CANSparkMax {
  public Motor(int port, boolean reversed) {
    super(port, MotorType.kBrushless);
    setInverted(reversed);
  }
}

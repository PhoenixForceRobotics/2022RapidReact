package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.utils.Motor;
import frc.robot.utils.OI;

public class Outake {
  public Motor outakeL;
  public Motor outakeR;
  public OI oi;

  public Outake(OI oi) {
    outakeR = new Motor(4, MotorType.kBrushless, true, 40);
    outakeL = new Motor(2, MotorType.kBrushless, true, 40);
    this.oi = oi;
  }

  public void SetRightOutake() {
    if (oi.driverController.rightBumper.get() == true) {
      outakeR.set(1);
    } else {
    }
  }

  public void SetLeftOutake() {
    if (oi.driverController.rightBumper.get() == true) {
      outakeL.set(1);
    } else {
    }
  }
}

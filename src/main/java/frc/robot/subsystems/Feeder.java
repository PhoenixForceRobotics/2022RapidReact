package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Motor;
import frc.robot.utils.OI;

public class Feeder extends SubsystemBase {

  public Motor belt_motor1;
  public Motor outakeL;
  public Motor toShoot;
  public OI oi;

  public Feeder(OI oi) {
    belt_motor1 = new Motor(4, MotorType.kBrushless, true, 40);
    outakeL = new Motor(2, MotorType.kBrushless, true, 40);
    toShoot = new Motor(3, MotorType.kBrushless, true, 40);
    this.oi = oi;
  }

  public void RunFeeder(double beltSpeed) {
    belt_motor1.set(beltSpeed);
    outakeL.set(beltSpeed);
    toShoot.set(beltSpeed);
  }

  public void SetFeeder() {
    if (oi.driverController.triggers.getRight() > 0) {
      RunFeeder(oi.driverController.triggers.getRight());
    } else {
    }
  }
}

package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Motor;
import frc.robot.utils.OI;

public class Feeder extends SubsystemBase {

  public Motor beltMotor;
  public Motor outakeL;
  public Motor toShoot;
  public OI oi;

  public Feeder(OI oi) {
    beltMotor = new Motor(5, MotorType.kBrushless, true, 40);
    outakeL = new Motor(4, MotorType.kBrushless, true, 40);
    toShoot = new Motor(3, MotorType.kBrushless, true, 40);
    this.oi = oi;
  }

  public void runFeeder(double beltSpeed) {
    beltMotor.set(beltSpeed);
    outakeL.set(beltSpeed);
    toShoot.set(beltSpeed);
  }
}

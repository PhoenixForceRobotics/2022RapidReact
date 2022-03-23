package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.Motor;

public class Feeder extends SubsystemBase {

  private Motor transporterBottom;
  private Motor transporterTop;
  private Motor outake;

  public Feeder() {
    transporterTop =
        new Motor(Constants.FeederIntakeConstants.TRANSPORTER_TOP, MotorType.kBrushless, true, 40);
    transporterBottom =
        new Motor(
            Constants.FeederIntakeConstants.TRANSPORTER_BOTTOM, MotorType.kBrushless, false, 40);
    outake = new Motor(Constants.FeederIntakeConstants.OUTAKE, MotorType.kBrushless, true, 40);
  }

  // Make forward move it left towards the shooter side, will change reversed to
  // reflect that in the future.
  public void setTransporterTop(double speed) {
    transporterTop.set(speed);
  }

  public void setTransporterBottom(double speed) {
    transporterBottom.set(speed);
  }

  public void setOutake(double speed) {
    outake.set(speed);
  }
}

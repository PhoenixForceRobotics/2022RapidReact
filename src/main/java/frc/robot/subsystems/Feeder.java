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
        new Motor(Constants.FeederIntakeConstants.TRANSPORTER_TOP, true);
    transporterBottom =
        new Motor(
            Constants.FeederIntakeConstants.TRANSPORTER_BOTTOM, false);
    outake = new Motor(Constants.FeederIntakeConstants.OUTTAKE, true);
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

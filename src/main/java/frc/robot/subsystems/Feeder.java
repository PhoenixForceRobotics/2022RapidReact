package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.Motor;

public class Feeder extends SubsystemBase {

  public Motor transporterBottom;
  public Motor transporterTop;
  public Motor outake;


  public Feeder() {
    transporterTop = new Motor(Constants.FeederConstants.TRANSPORTER_TOP, MotorType.kBrushless, true, 40);
    transporterBottom = new Motor(Constants.FeederConstants.TRANSPORTER_BOTTOM, MotorType.kBrushless, true, 40);
    outake = new Motor(Constants.FeederConstants.OUTAKE, MotorType.kBrushless, true, 40);
  }

  // Make forward move it left towards the shooter side, will change reversed to
  // reflect that in the future.
  public void setTransporterTop(double speed) {
    transporterTop.set(speed * Constants.FeederConstants.RATIO_TRANSPORTER_TOP);
  }

  public void setTransporterBottom(double speed) {
    transporterBottom.set(speed * Constants.FeederConstants.RATIO_TRANSPORTER_BOTTOM);
  }

  public void setOutake(double speed) {
    outake.set(speed * Constants.FeederConstants.RATIO_OUTAKE);
  }
}

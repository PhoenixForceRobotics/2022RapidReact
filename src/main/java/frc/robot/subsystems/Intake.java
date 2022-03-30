package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants.IntakeConstants;
import frc.robot.utils.Motor;

public class Intake extends SubsystemBase {

  private Motor collector, belt, transportLeft, transportRight;

  private DoubleSolenoid collectorPiston;

  public Intake() {
    collector = new Motor(IntakeConstants.COLLECTOR_PORT, IntakeConstants.COLLECTOR_REVERSED);
    belt = new Motor(IntakeConstants.BELT_PORT, IntakeConstants.BELT_REVERSED);
    transportLeft =
        new Motor(IntakeConstants.TRANSPORT_LEFT_PORT, IntakeConstants.TRANSPORT_LEFT_REVERSED);
    transportRight =
        new Motor(IntakeConstants.TRANSPORT_RIGHT_PORT, IntakeConstants.TRANSPORT_RIGHT_REVERSED);

    collectorPiston =
        new DoubleSolenoid(
            PneumaticsModuleType.CTREPCM,
            IntakeConstants.COLLECTOR_PISTON_FORWARD_PORT,
            IntakeConstants.COLLECTOR_PISTON_REVERSED_PORT);
  }

  public void setCollector(double speed) {
    collector.set(speed);
  }

  public void setBelt(double speed) {
    belt.set(speed);
  }

  public void setTransport(double left, double right) {
    transportLeft.set(left);
    transportRight.set(right);
  }

  public void setTransportLeft(double speed) {
    transportLeft.set(speed);
  }

  public void setTransportRight(double speed) {
    transportRight.set(speed);
  }

  public void zeroAllMotors() {
    collector.set(0);
    belt.set(0);
    transportLeft.set(0);
    transportRight.set(0);
  }

  public void togglePiston() {
    collectorPiston.set(collectorPiston.get() == Value.kForward ? Value.kReverse : Value.kForward);
  }

  public void collectorForward() {
    collectorPiston.set(Value.kForward);
  }

  public void collectorReverse() {
    collectorPiston.set(Value.kReverse);
  }
}

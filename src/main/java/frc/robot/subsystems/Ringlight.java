package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Ringlight extends SubsystemBase {
  private Relay LED;

  public Ringlight(int port) {
    LED = new Relay(port, Direction.kReverse);
    turnOff();
  }

  public void turnOn() {
    LED.set(Value.kOn);
  }

  public void turnOff() {
    LED.set(Value.kOff);
  }

  public void toggle() {
    if (isOn()) {
      turnOff();
    } else {
      turnOn();
    }
  }

  public boolean isOn() {
    return LED.get() == Value.kOn;
  }
}

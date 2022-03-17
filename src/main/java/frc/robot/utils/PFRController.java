package frc.robot.utils;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class PFRController extends XboxController {

  public PFRController(int port) {
    super(port);
  }

  public JoystickButton aButton() {
    return new JoystickButton(this, Button.kA.value);
  }

  public JoystickButton bButton() {
    return new JoystickButton(this, Button.kB.value);
  }

  public JoystickButton yButton() {
    return new JoystickButton(this, Button.kY.value);
  }

  public JoystickButton xButton() {
    return new JoystickButton(this, Button.kX.value);
  }

  public JoystickButton lBumper() {
    return new JoystickButton(this, Button.kLeftBumper.value);
  }

  public JoystickButton rBumper() {
    return new JoystickButton(this, Button.kRightBumper.value);
  }

  public JoystickButton lJoystickButton() {
    return new JoystickButton(this, Button.kLeftStick.value);
  }

  public JoystickButton rJoystickButton() {
    return new JoystickButton(this, Button.kLeftStick.value);
  }
}

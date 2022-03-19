package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakePistons extends SubsystemBase {

  // variable decleration

  private static DoubleSolenoid intakearm;

  public IntakePistons() {
    intakearm = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5);
  }

  // piston1 functions

  public void setintakearmForward() {
    intakearm.set(Value.kForward);
  }

  public void setintakearmReverse() {
    intakearm.set(Value.kReverse);
  }

  public boolean pissonntoggle = true;
}

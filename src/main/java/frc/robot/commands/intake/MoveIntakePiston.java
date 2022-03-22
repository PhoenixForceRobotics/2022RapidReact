package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class MoveIntakePiston extends CommandBase {
  private Intake intakesystem;

  // add requirments for up 90

  public MoveIntakePiston(Intake intakesystem) {
    this.intakesystem = intakesystem;
  }

  @Override
  public void initialize() {
    if (intakesystem.getIntakePistonPosition() == Value.kForward) {
      intakesystem.setIntakePistonReverse();
    } else if (intakesystem.getIntakePistonPosition() == Value.kReverse) {
      intakesystem.setIntakePistonForward();
    } else {
      System.out.println("This should not have happened check intake piston code");
    }
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

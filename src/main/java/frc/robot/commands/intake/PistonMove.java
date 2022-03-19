package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakePistons;

public class PistonMove extends CommandBase {
  private IntakePistons intakepistons;

  // add requirments for up 90

  public PistonMove(IntakePistons intakepistons) {
    addRequirements(intakepistons);
    this.intakepistons = intakepistons;
  }

  // Begin up 90 command

  @Override
  public void initialize() {
    if (!intakepistons.pissonntoggle) {
      intakepistons.setintakearmForward();
      intakepistons.pissonntoggle = true;
    } else {
      intakepistons.setintakearmReverse();
      intakepistons.pissonntoggle = false;
    }
  }

  // Exicute up 90 (this will loop until command is over)

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

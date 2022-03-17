package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intakesystem;

public class pistoneMove extends CommandBase {
  private Intakesystem intakesystem;

  // add requirments for up 90

  public pistoneMove(Intakesystem intakesystem) {
    addRequirements(intakesystem);
    this.intakesystem = intakesystem;
  }

  // Begin up 90 command

  @Override
  public void initialize() {
    if (!intakesystem.pissonntoggle) {
      intakesystem.setPiston1Forward();
      intakesystem.setPiston2Forward();
      intakesystem.pissonntoggle = true;
    } else {
      intakesystem.setPiston1Reverse();
      intakesystem.setPiston2Reverse();
      intakesystem.pissonntoggle = false;
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

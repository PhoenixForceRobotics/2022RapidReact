package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intakesystem;

public class pistoneMove extends CommandBase {
  private Intakesystem drivebase;

  // add requirments for up 90

  public pistoneMove(Intakesystem drivebase) {
    addRequirements(drivebase);
    this.drivebase = drivebase;
  }

  // Begin up 90 command

  @Override
  public void initialize() {
    if (drivebase.pissonntoggle == false) {
      drivebase.setPiston1Forward();
      drivebase.setPiston2Forward();
      drivebase.pissonntoggle = true;
    } else {
      drivebase.setPiston1Reverse();
      drivebase.setPiston2Reverse();
      drivebase.pissonntoggle = false;
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

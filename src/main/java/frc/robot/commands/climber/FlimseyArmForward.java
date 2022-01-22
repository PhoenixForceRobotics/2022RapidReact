package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class FlimseyArmForward extends CommandBase {

  private Climber climber;

  public FlimseyArmForward() {
    // Use requires() here to declare subsystem dependencies
    this.climber = Robot.climber;
  }

  @Override
  public void initialize() {
    climber.setFlimseyArm(0.1);
  }

  @Override
  public void execute() {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
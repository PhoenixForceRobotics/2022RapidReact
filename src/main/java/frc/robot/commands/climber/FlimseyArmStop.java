package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class FlimseyArmStop extends CommandBase {

  private Climber climber;

  public FlimseyArmStop() {
    // Use requires() here to declare subsystem dependencies
    this.climber = Robot.climber;
  }

  @Override
  public void initialize() {
    climber.setFlimseyArm(0);
  }

  @Override
  public void execute() {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
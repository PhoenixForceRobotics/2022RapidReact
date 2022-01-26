package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class ActivatePistons extends CommandBase {

  private Climber climber;

  public ActivatePistons() {
    // Use requires() here to declare subsystem dependencies
    this.climber = Robot.climber;
  }

  @Override
  public void initialize() {
    boolean statusOfLevation = climber.getLevitateStatus();
    if (statusOfLevation == true){
      climber.stopLevitate();
    }
    else{
      climber.Levitate();
    }
  }

  @Override
  public void execute() {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
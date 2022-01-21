package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class spoolsBackward extends CommandBase{

    private Climber climber;

    public spoolsBackward() {
        // Use requires() here to declare subsystem dependencies
        this.climber = Robot.climber;
      }


    @Override
    public void initialize() {
        climber.setSpools(-0.1);
  }

  @Override
  public void execute() {
      
  }

    @Override
  public boolean isFinished() {
    return false;
  }
}

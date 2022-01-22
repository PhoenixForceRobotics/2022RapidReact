package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class ActivatePistonBreak extends CommandBase{
  // if this ^^^^^^^^^^^^^^^^^^ has a error resave the file, it is a VS code isssue

    private Climber climber;

    public ActivatePistonBreak() {
        // Use requires() here to declare subsystem dependencies
        this.climber = Robot.climber;
      }


    @Override
    public void initialize() {
        climber.activatePistonBreak();
    }

  @Override
  public void execute() {
      
  }

    @Override
  public boolean isFinished() {
    return false;
  }
}
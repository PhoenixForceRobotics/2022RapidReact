package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class deactivatePistonBreak extends CommandBase{

    private Climber climber;

    public deactivatePistonBreak() {
        // Use requires() here to declare subsystem dependencies
        this.climber = Robot.climber;
      }


    @Override
    public void initialize() {
        climber.deactivatePistonBreak();
  }

  @Override
  public void execute() {
      
  }

    @Override
  public boolean isFinished() {
    return false;
  }
}
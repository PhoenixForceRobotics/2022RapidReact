package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;

public class ClimberSequence extends SequentialCommandGroup {
  public ClimberSequence() {
    System.out.println("");
    System.out.println("Climber Sequence has been called");
    addCommands(
        new RunPistonExtend(Robot.climber, 1.0),
        new RunButtonNextSequence(Robot.climber),
        new RunPistonDetract(Robot.climber, 1.0));
  }
}

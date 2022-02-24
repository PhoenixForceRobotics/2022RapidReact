package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;

public class ClimberSequence extends SequentialCommandGroup {
  public ClimberSequence() {
    addCommands(
        new RunPistonExtend(Robot.climber),
        // Person moves robot into position
        new RunButtonNextSequence(Robot.climber),
        new RunFlimseyArm(Robot.climber, Robot.pid, 0.5, 0.005, 0.1),
        new RunPistonDetract(Robot.climber),
        new Delay(Robot.climber, 2),
        new RunIntakeRotator(Robot.intakeSystem, Robot.pid, 0.25, 0.005, 0.1),
        new Delay(Robot.climber, 1),
        new RunPistonExtend(Robot.climber),
        new Delay(Robot.climber, 0.2),
        new RunPistonDetract(Robot.climber));
  }
}

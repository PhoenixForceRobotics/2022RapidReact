package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;

public class ClimberSequence extends SequentialCommandGroup {
  public ClimberSequence() {
    addCommands(
        new RunPistonExtend(),
        // Person moves robot into position
        new RunButtonNextSequence(),
        new RunFlimseyArm(Robot.climber, Robot.pid, 0.5, 0.005, 0.1),
        new RunPistonDetract(),
        new Delay(2),
        new RunIntakeRotator(Robot.intakeSystem, Robot.pid, 0.25, 0.005, 0.1),
        new Delay(1),
        new RunPistonExtend(),
        new Delay(0.2),
        new RunPistonDetract());
  }
}

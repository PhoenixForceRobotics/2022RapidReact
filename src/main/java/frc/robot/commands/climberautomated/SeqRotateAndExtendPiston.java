package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Robot;

public class SeqRotateAndExtendPiston extends ParallelCommandGroup {
  public SeqRotateAndExtendPiston() {
    addCommands(
        new RunClimberArm(Robot.climberMotors, Robot.pid, 0.2222 * 12, 0.05, 0.1),
        new SeqPistonDuringRotate());
  }
}

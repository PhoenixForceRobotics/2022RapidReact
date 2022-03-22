package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class SeqIntake extends SequentialCommandGroup {
  public SeqIntake(Intake intake) {
    addCommands(
        new RunShuttlePistonToIntake(Robot.shuttle, 0.2),
        new RunIntakeMotors(Robot.intake, Robot.shuttle, Robot.oi));
  }
}

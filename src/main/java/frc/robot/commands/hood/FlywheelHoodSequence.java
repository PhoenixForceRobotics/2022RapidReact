package frc.robot.commands.hood;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Flywheel;

public class FlywheelHoodSequence extends SequentialCommandGroup {
  public FlywheelHoodSequence(Flywheel flywheel) {
    addCommands(new FlywheelHoodReset(flywheel), new FlywheelHood(flywheel));
  }
}

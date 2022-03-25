package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Turret;

public class HoodSequence extends SequentialCommandGroup {
  public HoodSequence(Turret flywheel) {
    addCommands(new ResetHood(flywheel), new SetHoodToTargetAngle(flywheel));
  }
}

package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Turret;

public class HoodSequence extends SequentialCommandGroup {
  public HoodSequence(Turret turret) {
    addCommands(
        new ResetHoodStart(turret),
        new WaitCommand(.2),
        new ResetHood(turret),
        new HoodAngle(turret));
  }
}

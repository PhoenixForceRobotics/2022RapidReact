package frc.robot.commands.turn;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Flywheel;

public class FlywheelTurnSequence extends SequentialCommandGroup {
  public FlywheelTurnSequence(Flywheel flywheel) {
    addCommands(new FlywheelTurnReset(flywheel), new FlywheelTurn(flywheel));
  }
}

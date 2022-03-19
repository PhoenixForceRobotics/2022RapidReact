package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Climber;

public class ClimbDown extends InstantCommand {
  Climber climber;

  public ClimbDown(Climber climber) {
    this.climber = climber;
    addRequirements(climber);
  }

  @Override
  public void initialize() {
    climber.climberDown();
  }
}

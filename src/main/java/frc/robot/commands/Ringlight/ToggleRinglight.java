package frc.robot.commands.Ringlight;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Ringlight;

public class ToggleRinglight extends InstantCommand {
  private Ringlight ringlight;

  public ToggleRinglight(Ringlight ringlight) {
    this.ringlight = ringlight;
    addRequirements(ringlight);
  }

  @Override
  public void initialize() {
    ringlight.toggle();
  }
}

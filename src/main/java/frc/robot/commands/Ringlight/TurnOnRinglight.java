package frc.robot.commands.Ringlight;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Ringlight;

public class TurnOnRinglight extends InstantCommand {
  private Ringlight ringlight;

  public TurnOnRinglight(Ringlight ringlight) {
    this.ringlight = ringlight;
    addRequirements(ringlight);
  }

  @Override
  public void initialize() {
    ringlight.turnOn();
  }
}

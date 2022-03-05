package frc.robot.commands.Ringlight;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Ringlight;

public class TurnOffRinglight extends InstantCommand {
  private Ringlight ringlight;

  public TurnOffRinglight(Ringlight ringlight) {
    this.ringlight = ringlight;
    addRequirements(ringlight);
  }

  @Override
  public void initialize() {
    ringlight.turnOff();
  }
}

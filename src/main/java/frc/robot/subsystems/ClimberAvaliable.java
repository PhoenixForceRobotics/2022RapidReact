package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Created because this can be called while climber is activated,
// so this was created in order to not mess it up.
public class ClimberAvaliable extends SubsystemBase {

  boolean ClimberSeqAvailable = true;

  public ClimberAvaliable() {}

  public void setClimberSeqAvaliable(boolean value) {
    ClimberSeqAvailable = value;
  }

  public boolean getClimberSeqAvailable() {
    return ClimberSeqAvailable;
  }
}

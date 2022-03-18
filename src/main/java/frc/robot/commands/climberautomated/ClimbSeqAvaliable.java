package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberAvaliable;

public class ClimbSeqAvaliable extends CommandBase {

  private ClimberAvaliable climberAvaliable;
  private boolean seqAvaliable;

  public ClimbSeqAvaliable(ClimberAvaliable m_climberAvaliable) {
    climberAvaliable = m_climberAvaliable;
  }

  @Override
  public void initialize() {
    seqAvaliable = climberAvaliable.getClimberSeqAvailable();
    if (seqAvaliable == true) {
      new SeqClimberMain();
      climberAvaliable.setClimberSeqAvaliable(false);
    }
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

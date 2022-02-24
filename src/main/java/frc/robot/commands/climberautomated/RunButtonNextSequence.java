package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class RunButtonNextSequence extends CommandBase {

  private Climber climber;
  private boolean done;

  public RunButtonNextSequence(Climber m_climber) {
    this.climber = m_climber;
  }

  @Override
  public void initialize() {
    done = false;
  }

  @Override
  public void execute() {
    if (climber.activateNextSequence()) {
      done = true;
    }
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}

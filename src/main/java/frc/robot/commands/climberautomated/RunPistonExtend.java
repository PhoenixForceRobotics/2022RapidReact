package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class RunPistonExtend extends CommandBase {

  private Climber climber;
  private boolean done;

  public RunPistonExtend(Climber m_climber) {
    climber = m_climber;
  }

  @Override
  public void initialize() {
    climber.Levitate();
    climber.resetTimer();
    climber.startTimer();
    done = false;
  }

  @Override
  public void execute() {
    if (climber.timeElapsed(1)) {
      done = true;
      climber.stopTimer();
    }
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}

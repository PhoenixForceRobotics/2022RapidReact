package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSolenoids;

public class RunDelay extends CommandBase {

  private ClimberSolenoids climber;
  private double delay;
  private boolean done;

  public RunDelay(ClimberSolenoids m_climber, double delayTime) {
    climber = m_climber;
    delay = delayTime;
  }

  @Override
  public void initialize() {
    climber.resetTimer();
    climber.startTimer();
    done = false;
  }

  @Override
  public void execute() {
  }

  @Override
  public boolean isFinished() {
    if (climber.timeElapsed(delay)) {
      climber.stopTimer();
      done = true;
    }
    return done;
  }
}

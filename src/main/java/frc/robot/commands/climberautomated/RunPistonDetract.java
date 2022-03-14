package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSolenoids;

public class RunPistonDetract extends CommandBase {

  private ClimberSolenoids climber;
  private boolean done;
  private double time;

  public RunPistonDetract(ClimberSolenoids m_climber, double m_time) {
    climber = m_climber;
    time = m_time;

  }

  @Override
  public void initialize() {
    climber.stopLevitate();
    climber.resetTimer();
    climber.startTimer();
    done = false;
  }

  @Override
  public void execute() {

  }

  @Override
  public boolean isFinished() {
    if (climber.timeElapsed(time)) {
      done = true;
      climber.stopTimer();
    }

    return done;
  }
}

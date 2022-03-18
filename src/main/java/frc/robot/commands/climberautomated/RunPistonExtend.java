package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class RunPistonExtend extends CommandBase {

  private Climber climber;
  private boolean done;
  private double time;

  public RunPistonExtend(Climber m_climber, Double m_time) {
    climber = m_climber;
    time = m_time;
  }

  @Override
  public void initialize() {
    System.out.println("RunPistonExtend has been called");
    climber.pistonForward();
    climber.resetTimer();
    climber.startTimer();
    done = false;
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    if (climber.timeElapsed(time)) {
      done = true;
      climber.stopTimer();
    }

    return done;
  }
}

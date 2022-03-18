package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class RunPistonDetract extends CommandBase {

  private Climber climber;
  private boolean done;
  private double time;

  public RunPistonDetract(Climber m_climber, double m_time) {
    climber = m_climber;
    time = m_time;
  }

  @Override
  public void initialize() {
    System.out.println("RunPistonDetract has been called");
    climber.pistonReverse();
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
      System.out.println("You have been extended");
    }

    return done;
  }
}

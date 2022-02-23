package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class Delay extends CommandBase {

  private Climber climber;
  private double delay;
  private boolean done;

  public Delay(double delayTime) {
    this.climber = Robot.climber;
    delay = delayTime;
  }

  @Override
  public void initialize() {
    climber.resetTimer();
    climber.startTimer();
    done = false;
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    if (climber.timeElapsed(delay)) {
      climber.stopTimer();
      done = true;
    }
    return done;
  }
}

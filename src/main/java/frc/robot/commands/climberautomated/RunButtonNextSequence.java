package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberMotors;

public class RunButtonNextSequence extends CommandBase {

  private ClimberMotors climber;
  private boolean done;

  public RunButtonNextSequence(ClimberMotors m_climber) {
    this.climber = m_climber;
  }

  @Override
  public void initialize() {
    done = false;
  }

  @Override
  public void execute() {
    if (climber.getActivateNextSequence()) {
      done = true;
    }
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}

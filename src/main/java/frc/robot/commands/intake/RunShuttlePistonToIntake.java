package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shuttle;

public class RunShuttlePistonToIntake extends CommandBase {
  private Intake intakesystem;
  private Shuttle shuttle;
  private boolean done;
  private double delay;

  public RunShuttlePistonToIntake(Shuttle shuttle, double delay) {
    this.shuttle = shuttle;
    this.intakesystem.intakeMotorBrake();
    this.delay = delay;
  }

  @Override
  public void initialize() {
    if (shuttle.getShuttleExtenderPosition() == Value.kForward) {
      done = true;
    } else {
      done = false;
      shuttle.setShuttleExtenderForward();

      shuttle.resetTimer();
      shuttle.startTimer();
    }
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    if (shuttle.getTimer() == delay) {
      done = true;
      shuttle.stopTimer();
    }

    return done;
  }
}

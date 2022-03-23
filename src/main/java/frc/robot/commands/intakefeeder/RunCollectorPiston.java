package frc.robot.commands.intakefeeder;

import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.InstantCommand;


public class RunCollectorPiston extends InstantCommand {
  private Collector shuttle;
  private Value direction;
  

  public RunCollectorPiston(Collector shuttle, Value direction) {
    this.shuttle = shuttle;
    this.direction = direction;
  }

  @Override
  public void initialize() {
    if (direction == Value.kForward) {
      shuttle.setShuttleExtenderForward();
    } else {
      shuttle.setShuttleExtenderReverse();
    }
  }
}

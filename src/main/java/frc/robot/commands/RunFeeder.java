package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class RunFeeder extends CommandBase {
  private Feeder feeder;
  private boolean on;
  private XboxController operatorController;

  // add requirments for up 90

  public RunFeeder(Feeder feeder, boolean on) {
    addRequirements(feeder);
    this.feeder = feeder;
    this.on = on;
  }

  @Override
  public void initialize() {
    System.out.println("Feeder initilizer");
  }

  // Exicute up 90 (this will loop until command is over)

  @Override
  public void execute() {
    System.out.println("Feeder execute");
    if (this.on) {
      feeder.runFeeder(0.5);
    } else {
      feeder.runFeeder(0);
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

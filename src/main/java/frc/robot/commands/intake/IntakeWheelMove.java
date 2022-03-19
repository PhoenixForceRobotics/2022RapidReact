package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeMotors;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;

public class IntakeWheelMove extends CommandBase {
  private IntakeMotors intakemotors;
  private PFRController operator;

  // add requirments for up 90

  public IntakeWheelMove(IntakeMotors intakemotors, OI oi) {
    addRequirements(intakemotors);
    this.intakemotors = intakemotors;
    intakemotors.collectormotor1Brake();
    intakemotors.collectormotor2Brake();
    operator = oi.operatorController;
  }

  @Override
  public void initialize() {
    System.out.println("Wheelmotor initilized");
  }

  @Override
  public void execute() {
    System.out.println("Wheelmotor initilized");
    if (operator.getLeftY() > 0.1) {
      intakemotors.setcollectormotor1Speed(0.1);
      intakemotors.setcollectormotor2Speed(0.1);
    } else {
      intakemotors.setcollectormotor1Speed(0);
      intakemotors.setcollectormotor2Speed(0);
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

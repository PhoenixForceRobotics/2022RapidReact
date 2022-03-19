package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeMotors;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;

public class intakeWheelMove extends CommandBase {
  private IntakeMotors intakemotors;
  private PFRController operator;

  // add requirments for up 90

  public intakeWheelMove(IntakeMotors intakemotors, OI oi) {
    addRequirements(intakemotors);
    this.intakemotors = intakemotors;
    intakemotors.WheelMotorBrake();
    operator = oi.operatorController;
  }

  // Begin up 90 command

  @Override
  public void initialize() {
    System.out.println("Wheelmotor initilized");
  }

  // Exicute up 90 (this will loop until command is over)

  @Override
  public void execute() {
    System.out.println("Wheelmotor initilized");
    if (operator.getLeftY() > 0.1) {
      intakemotors.setWheelmotorSpeed(0.1);
      intakemotors.setRotatormotor2Speed(0.1);
    } else {
      intakemotors.setRotatormotor2Speed(0);
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intakesystem;

public class intakeWheelMove extends CommandBase {
  private Intakesystem intakesystem;
  private XboxController driverController;

  // add requirments for up 90

  public intakeWheelMove(Intakesystem intakesystem) {
    addRequirements(intakesystem);
    this.intakesystem = intakesystem;
    intakesystem.WheelMotorBrake();
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
    if ((driverController.getRightTriggerAxis() > 0)
        || (driverController.getLeftTriggerAxis() > 0)) {
      if (driverController.getRightTriggerAxis() > driverController.getLeftTriggerAxis()) {
        intakesystem.setWheelmotorSpeed(driverController.getRightTriggerAxis());
        intakesystem.setRotatormotor2Speed(driverController.getRightTriggerAxis());
      } else {
        intakesystem.setWheelmotorSpeed(driverController.getLeftTriggerAxis());
        intakesystem.setRotatormotor2Speed(driverController.getLeftTriggerAxis());
      }
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

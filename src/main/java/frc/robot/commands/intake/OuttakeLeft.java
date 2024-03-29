package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.utils.Constants.IntakeConstants;

public class OuttakeLeft extends CommandBase {
  private Intake intake;

  public OuttakeLeft(Intake intake) {
    this.intake = intake;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
    intake.setTransport(
        IntakeConstants.TRANSPORT_OUTTAKE_SPEED, IntakeConstants.TRANSPORT_OUTTAKE_SPEED);
    intake.setBelt(-IntakeConstants.BELT_SPEED); // TODO: Constants
  }

  @Override
  public void end(boolean interrupted) {
    intake.zeroAllMotors();
  }
}

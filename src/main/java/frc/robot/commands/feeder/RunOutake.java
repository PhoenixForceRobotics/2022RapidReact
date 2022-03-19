package frc.robot.commands.feeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;
import frc.robot.utils.OI;
import frc.robot.utils.PFRController;

public class RunOutake extends CommandBase {
  private Feeder feeder;
  private PFRController operator;

  // add requirments for up 90

  public RunOutake(Feeder m_feeder, OI oi) {
    operator = oi.operatorController;
    feeder = m_feeder;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    if(operator.getLeftY() > 0.1){
      feeder.setTransporterTop(0.1);
      feeder.setTransporterBottom(0.1);
      feeder.setOutake(-0.1);
    } else if(operator.getLeftBumper() == true){
      feeder.setTransporterTop(0.1);
      feeder.setTransporterBottom(0.1);
      feeder.setOutake(0.1);
    } else if(operator.getRightBumper() == true){
      feeder.setTransporterTop(-0.1);
      feeder.setTransporterBottom(-0.1);
      feeder.setOutake(-0.1);
    } else {
      feeder.setTransporterTop(0);
      feeder.setTransporterBottom(0);
      feeder.setOutake(0);
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}


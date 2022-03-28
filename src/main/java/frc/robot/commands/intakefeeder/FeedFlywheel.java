package frc.robot.commands.intakefeeder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Feeder;
import frc.robot.utils.Constants;

public class FeedFlywheel extends CommandBase {
    private Feeder feeder;
    private Collector collector;

    public FeedFlywheel(Feeder feeder, Collector collector)
    {
        this.feeder = feeder;
        this.collector = collector;
    }

    @Override
    public void initialize() {
        feeder.setTransporterTop(Constants.FeederIntakeConstants.TRANSPORTER_TOP_SPEED);
        feeder.setTransporterBottom(Constants.FeederIntakeConstants.TRANSPORTER_BOTTOM_SPEED);
        feeder.setOutake(-1);
        collector.setCollectorMotor(0.5);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
    
}

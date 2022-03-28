package frc.robot.commands.intakefeeder;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class CollectorIn extends CommandBase{
    public Collector collector;

    public CollectorIn(Collector collector)
    {
        this.collector = collector;
    }

    @Override
    public void initialize() {
        collector.setPiston(Value.kForward);
        collector.setCollectorMotor(0.5);
    }

    @Override
    public boolean isFinished() {
        return true;
    }


}

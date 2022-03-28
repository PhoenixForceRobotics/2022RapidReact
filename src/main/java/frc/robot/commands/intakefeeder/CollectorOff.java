package frc.robot.commands.intakefeeder;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class CollectorOff extends CommandBase {
    private Collector collector;

    public CollectorOff(Collector collector)
    {
        this.collector = collector;
    }
    @Override
    public void initialize() {
        collector.setPiston(Value.kReverse);
        collector.setCollectorMotor(0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

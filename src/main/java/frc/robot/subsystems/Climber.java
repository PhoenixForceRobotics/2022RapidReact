package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants.ClimbConstants;

public class Climber extends SubsystemBase{
    public DoubleSolenoid solenoid;

    public Climber()
    {
        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, ClimbConstants.FORWARD_CHANNEL, ClimbConstants.REVERSE_CHANNEL);
        solenoid.set(Value.kReverse);

    }

    public void climberUp()
    {
        solenoid.set(Value.kForward);
    }

    public void climberDown()
    {
        solenoid.set(Value.kReverse);
    }
}

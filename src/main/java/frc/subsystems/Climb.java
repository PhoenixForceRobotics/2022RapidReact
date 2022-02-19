package frc.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase{
    private DoubleSolenoid doubleSolenoid; 

    public Climb()
    {
        doubleSolenoid = new DoubleSolenoid(
            PneumaticsModuleType.CTREPCM,
            0,
            1);
    }
    public void toggle()
    {
        doubleSolenoid.toggle();
    }

    public void forward()
    {
        doubleSolenoid.set(Value.kForward);
    }

    public void reverse()
    {
        doubleSolenoid.set(Value.kReverse);
    }

    public void off()
    {
        doubleSolenoid.set(Value.kOff);
    }
}

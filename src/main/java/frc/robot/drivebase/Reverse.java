package frc.robot.drivebase;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivebase;

public class Reverse extends CommandBase{
    private Drivebase drivebase;

    public Reverse(Drivebase m_drivebase)
    {
        drivebase = m_drivebase;
        addRequirements(m_drivebase);
    }

    public void initialize()
    {
        drivebase.reverser();
    }

    public void execute()
    {
       Robot.addDriveBase();
    }

    public boolean isFinished()
    {
        return true;
    }
}

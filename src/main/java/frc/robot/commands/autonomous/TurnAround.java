package frc.robot.commands.autonomous;
  
import javax.print.attribute.standard.MediaSize.ISO;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.utils.Constants.DriveConstants;

public class TurnAround extends CommandBase{
    private Drivebase drivebase;
    private double startingAngle;
    
    public TurnAround(Drivebase drivebase)
    {
        this.drivebase = drivebase;
    } 

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        startingAngle = drivebase.getHeading();
        drivebase.set(-0.5, 0.5);
    }

    @Override
    public void execute() {
        System.out.println(drivebase.getHeading());
    }

    @Override
    public boolean isFinished() {
        return !(startingAngle - 180 < drivebase.getHeading() && drivebase.getHeading() < startingAngle + 180); 
    }

    @Override
    public void end(boolean interrupted) {
        drivebase.tankDrive(0, 0);
    }
}

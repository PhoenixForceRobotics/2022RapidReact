package frc.robot.commands.drivebase;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Intakesystem;

public class RunDriveBase extends CommandBase {
    public Intakesystem drivebase;
	public double speed, reversespeed;//, belt1Encoder;
	private OI oi;

	public RunDriveBase(Intakesystem drivebase, OI oi)
	{
		addRequirements(drivebase);
		this.oi = oi;
		this.drivebase = drivebase;
		//belt1Encoder = drivebase.getBelt1Encoder();
		
	}

	@Override
	public void initialize()
	{
		drivebase.setRotator2Encoder(0);
		drivebase.rotatorMotorBrake();
		drivebase.rotatorMotor2Brake();
	}

	@Override
	public void execute()
	{
		if (oi.driverController.triggers.getLeft() > 0.0){
			drivebase.setRotatormotor2Speed((oi.driverController.triggers.getLeft()/10));
		}
		if (oi.driverController.triggers.getRight() * -1 < 0.0){
			drivebase.setRotatormotor2Speed((oi.driverController.triggers.getLeft()/10));
		}
		
		

	}

	@Override
	public boolean isFinished()
	{
		return false;
	}
}
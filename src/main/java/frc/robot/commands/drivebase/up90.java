package frc.robot.commands.drivebase;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Intakesystem;
import java.lang.Math;
import frc.robot.subsystems.PID;

public class up90 extends CommandBase {
	private OI oi;
	private PID pid;
    private boolean done = false;
	private double pidSpeed;
	private double motorSpeed;
	private double maxSpeed = 0.1;
	private Intakesystem drivebase;
	

	//add requirments for up 90

	public up90(Intakesystem drivebase, PID pid)
	{
		addRequirements(drivebase);
		this.drivebase = drivebase;
		this.pid = pid;
		drivebase.rotatorMotorBrake();
        done = false;
	}

	//Begin up 90 command; set pid point, set tolorance, reset encoder and pid

	@Override
	public void initialize()
	{
		pid.print();
		drivebase.setRotatorEncoder(0);
		drivebase.setRotator2Encoder(0);
		done = false;
		pid.setpidpoint(3);
		pid.setTolerance(0.01);
		pid.pidreset();
	}

	//Exicute up 90 (this will loop until command is over)
	@Override
	public void execute()
	{
		//calculate pid speed using canencoder postition
		pidSpeed = (pid.pidcalculate(drivebase.getRotatorEncoderPosition()));
		//set speed to the smaller of pid speed and maxspeed
		motorSpeed = Math.min(maxSpeed, Math.abs(pidSpeed));
		//set motor speed
		drivebase.setRotatormotorSpeed(motorSpeed);
		drivebase.setRotatormotor2Speed(motorSpeed);

        }
	//Finish up 90 (this will loop until command is over)
	@Override
	public boolean isFinished()
	{
	//if the pid is at setpoint and velocity is less than 100, set speed to 0 and return done = true
	if (pid.atsetpoint() && 100 > Math.abs(drivebase.getRotatorVelocity())){
		done = true;	
		pid.pidreset();
		drivebase.setRotatormotorSpeed(0);
		drivebase.setRotatorEncoder(0);
		drivebase.setRotatormotor2Speed(0);
		drivebase.setRotator2Encoder(0);
	} 
		return done;
    }

}
package frc.robot.commands.drivebase;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Intakesystem;
import java.lang.Math;

public class beltmove extends CommandBase {
    private Intakesystem drivebase;
	private OI oi;
    private boolean done = false;
	private int x;

	//add requirments for up 90

	public beltmove(Intakesystem drivebase)
	{
		addRequirements(drivebase);
		this.drivebase = drivebase;
		drivebase.BeltmotorBrake();
		drivebase.Beltmotor2Brake();
        done = false;
	}

	//Begin up 90 command

	@Override
	public void initialize()
	{
		drivebase.setBeltEncoder(0);
		drivebase.setBelt2Encoder(0);
		System.out.println("beltmove initilized");
		drivebase.setBeltmotor2Speed(-.05);
		drivebase.setBeltmotorSpeed(-.05);
		done = false;
	}

	//Exicute up 90 (this will loop until command is over)

	@Override
	public void execute()
	{
		System.out.println("up90 exicuted");
		drivebase.setBeltmotor2Speed(-.05);
		drivebase.setBeltmotorSpeed(-.05);
		if (drivebase.getRotatorEncoderPosition() <= -1){
			done = true;
			drivebase.setRotatormotorSpeed(0);
			drivebase.setRotatormotor2Speed(0);
			System.out.println("up90 finished");
		}
        }

	@Override
	public boolean isFinished()
	{
		return done;
    }

}
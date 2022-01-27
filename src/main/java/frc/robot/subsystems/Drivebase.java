package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Constants;
import frc.robot.util.Motor;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMax.IdleMode;


public class Drivebase extends SubsystemBase {
	public Motor left_motor1, left_motor2, left_motor3;
	public Motor right_motor1, right_motor2, right_motor3;

	double Multiplier = 1;
	private int Reverser = 1;

	public Drivebase() {
		// The parameters for a motor are (portNumber, MotorType, reversedOrNotBooleam, voltageInput)
		// MotorType for our robot is kBrushless, and the voltage input is 40)

		left_motor1 = new Motor(Constants.MotorMap.Drivebase.LEFT_1, MotorType.kBrushless, Constants.MotorMap.Drivebase.LEFT1_REVERSED, 40);
		left_motor2 = new Motor(Constants.MotorMap.Drivebase.LEFT_2, MotorType.kBrushless, Constants.MotorMap.Drivebase.LEFT2_REVERSED, 40);
		left_motor3 = new Motor(Constants.MotorMap.Drivebase.LEFT_3, MotorType.kBrushless, Constants.MotorMap.Drivebase.LEFT3_REVERSED, 40);
		right_motor1 = new Motor(Constants.MotorMap.Drivebase.RIGHT_1, MotorType.kBrushless, Constants.MotorMap.Drivebase.RIGHT1_REVERSED, 40);
		right_motor2 = new Motor(Constants.MotorMap.Drivebase.RIGHT_2, MotorType.kBrushless, Constants.MotorMap.Drivebase.RIGHT2_REVERSED, 40);
		right_motor3 = new Motor(Constants.MotorMap.Drivebase.RIGHT_3, MotorType.kBrushless, Constants.MotorMap.Drivebase.RIGHT3_REVERSED, 40);

		motor_coast();
	}

	public void left_motorSpeed(double speed){
		left_motor1.set(speed);
		left_motor2.set(speed);
		left_motor3.set(speed);
	}
	public void right_motorSpeed(double speed){
		right_motor1.set(speed);
		right_motor2.set(speed);
		right_motor3.set(speed);
	}

	public void motor_coast(){
		left_motor1.setIdleMode(IdleMode.kCoast);
		left_motor2.setIdleMode(IdleMode.kCoast);
		left_motor3.setIdleMode(IdleMode.kCoast);
		right_motor1.setIdleMode(IdleMode.kCoast);
		right_motor2.setIdleMode(IdleMode.kCoast);
		right_motor3.setIdleMode(IdleMode.kCoast);
	}

	public void motor_break(){
		left_motor1.setIdleMode(IdleMode.kBrake);
		left_motor2.setIdleMode(IdleMode.kBrake);
		left_motor3.setIdleMode(IdleMode.kBrake);
		right_motor1.setIdleMode(IdleMode.kBrake);
		right_motor2.setIdleMode(IdleMode.kBrake);
		right_motor3.setIdleMode(IdleMode.kBrake);
	}

	public void reverser()
	{
		if (Reverser == 1)
		{
			Reverser = -1;
		} else {
			Reverser = 1;
		}
	}

	public void shift()	{
		if(Multiplier==1)
		{
			Multiplier = .5;
		} else {
			Multiplier = 1;
		}
	}

	public double getMultiplier()
	{
		return Multiplier;
	}

	public int getReverser()
	{
		return Reverser;
	}

}

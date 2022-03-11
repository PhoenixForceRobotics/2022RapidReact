package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;


public class Intakesystem extends SubsystemBase {

	//variable decleration

	public static Motor rotatormotor1, rotatormotor2, beltmotor2, beltmotor1, wheelmotor;
	private double Multiplier = 1;
	private int Reverser = 1;
	private static RelativeEncoder rotatormotor1Encoder, rotatormotor2Encoder, beltmotor1Encoder, beltmotor2Encoder, wheelmotorEncoder;

	
	public Intakesystem() {

		//motor setting

		rotatormotor1 = new Motor(4, MotorType.kBrushless, true, 40);
		rotatormotor2 = new Motor(5, MotorType.kBrushless, true, 40);
		wheelmotor = new Motor(6, MotorType.kBrushless, true, 40);
		beltmotor1 = new Motor(7, MotorType.kBrushless, true, 40);
		beltmotor2 = new Motor(8, MotorType.kBrushless, true, 40);
		
		//motor encoder setting

		rotatormotor1Encoder = rotatormotor1.getEncoder();
		rotatormotor2Encoder = rotatormotor2.getEncoder();
		wheelmotorEncoder = wheelmotor.getEncoder();
		beltmotor1Encoder = beltmotor1.getEncoder();
		beltmotor2Encoder = beltmotor2.getEncoder();
	}

	//declaring motor setter/getters

	//rotator motor setter/getters

	public void setRotatorEncoder(double value){
		rotatormotor1Encoder.setPosition(value);
	}
	public double getRotatorEncoderPosition(){
		return rotatormotor1Encoder.getPosition();
	}
	public void setRotatormotorSpeed(double speed){
		rotatormotor1.set(speed);
	}
	public void rotatorMotorCoast(){
		rotatormotor1.setIdleMode(IdleMode.kCoast);
	}
	public void rotatorMotorBrake(){
		rotatormotor1.setIdleMode(IdleMode.kBrake);
	}
	public double getRotatorVelocity(){
		return rotatormotor1Encoder.getVelocity();
	}

	//rotator motor 2 setter/getters

	public void setRotator2Encoder(double value){
		rotatormotor2Encoder.setPosition(value);
	}
	public double getRotator2EncoderPosition(){
		return rotatormotor2Encoder.getPosition();
	}
	public void setRotatormotor2Speed(double speed){
		rotatormotor2.set(speed);
	}
	public void rotatorMotor2Coast(){
		rotatormotor2.setIdleMode(IdleMode.kCoast);
	}
	public void rotatorMotor2Brake(){
		rotatormotor2.setIdleMode(IdleMode.kBrake);
	}
	public double getRotator2Velocity(){
		return rotatormotor2Encoder.getVelocity();
	}

	//wheel motor setter/getters

	public void setWheelEncoder(double value){
		wheelmotorEncoder.setPosition(value);
	}
	public double getWheelEncoderPosition(){
		return wheelmotorEncoder.getPosition();
	}
	public void setWheelmotorSpeed(double speed){
		wheelmotor.set(speed);
	}
	public void WheelMotorCoast(){
		wheelmotor.setIdleMode(IdleMode.kCoast);
	}
	public void WheelMotorBrake(){
		wheelmotor.setIdleMode(IdleMode.kBrake);
	}
	public double getWheelVelocity(){
		return wheelmotorEncoder.getVelocity();
	}

	//belt motor setter/getters

	public void setBeltEncoder(double value){
		beltmotor1Encoder.setPosition(value);
	}
	public double getBeltEncoderPosition(){
		return beltmotor1Encoder.getPosition();
	}
	public void setBeltmotorSpeed(double speed){
		beltmotor1.set(speed);
	}
	public void BeltmotorCoast(){
		beltmotor1.setIdleMode(IdleMode.kCoast);
	}
	public void BeltmotorBrake(){
		beltmotor2.setIdleMode(IdleMode.kBrake);
	}
	public double getbeltVelocity(){
		return beltmotor1Encoder.getVelocity();
	}

	//belt motor 2 setter/getters

	public void setBelt2Encoder(double value){
		beltmotor2Encoder.setPosition(value);
	}
	public double getBelt2EncoderPosition(){
		return beltmotor2Encoder.getPosition();
	}
	public void setBeltmotor2Speed(double speed){
		beltmotor2.set(speed);
	}
	public void BeltMotor2Coast(){
		beltmotor2.setIdleMode(IdleMode.kCoast);
	}
	public void Beltmotor2Brake(){
		beltmotor2.setIdleMode(IdleMode.kBrake);
	}
	public double getbelt2Velocity(){
		return beltmotor2Encoder.getVelocity();
	}
}
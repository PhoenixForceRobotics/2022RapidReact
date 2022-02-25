package frc.utils;

import java.util.ArrayList;
import java.util.Collections;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.SparkMaxRelativeEncoder.Type;

public class SparkMotorGroup extends MotorControllerGroup {

    private CANSparkMax leader;
    private CANSparkMax[] followers;
    private RelativeEncoder encoder;

    public SparkMotorGroup(boolean isInverted, CANSparkMax leader, CANSparkMax... followers) {
        super(leader, followers);
        this.leader = leader;
        this.followers = followers;

        ArrayList<CANSparkMax> motorArrayList = new ArrayList<CANSparkMax>();
        
        motorArrayList.add(leader);
        Collections.addAll(motorArrayList, followers);

        // Set settings for followers
        for(CANSparkMax motor : this.followers) {
            motor.follow(leader);
        }
        
        this.leader.setInverted(isInverted);
        encoder = this.leader.getEncoder(Type.kHallSensor, 42);
    }
    
    @Override
    public void set(double percentage) {
        leader.set(percentage);
    }

    public void setVoltage(double voltage)
    {
        leader.setVoltage(voltage);
    }

    @Override
    public void stopMotor() {
        leader.stopMotor();
    }

    public void setPID(PIDValues pidValues, double minOutput, double maxOutput)
    {
        SparkMaxPIDController pidController = leader.getPIDController();
        pidController.setP(pidValues.getP());
        pidController.setI(pidValues.getI());
        pidController.setD(pidValues.getD());
        pidController.setFF(pidValues.getFF());
        pidController.setOutputRange(minOutput, maxOutput);
    }
    
    public void setPosition(double position)
    {
        encoder.setPosition(position);
    }

    public void setRotationSetpoint(double rotations) 
    {
        encoder.setPosition(rotations);
    }

    public void setDistanceConversion(double factor)
    {
        encoder.setPositionConversionFactor(factor);
    }
    
    public void setVelocityConversion(double factor)
    {
        encoder.setVelocityConversionFactor(factor);
    }

    public double getPosition()
    {
        return encoder.getPosition();
    }
    
    public double getVelocity()
    {
        return encoder.getVelocity();
    }

    public CANSparkMax getLeader() {
        return leader;
    }

    public RelativeEncoder getEncoder() {
        return encoder;
    }
}

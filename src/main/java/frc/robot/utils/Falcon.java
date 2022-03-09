package frc.robot.utils;

import com.ctre.phoenix.motorcontrol.ControlMode;
/*
    Created this class in order to clarify the code
*/
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class Falcon extends TalonFX {
    
    public Falcon(int portID, boolean isInverted)
    {
        super(portID);
        setInverted(isInverted);
    }

    
    public void PIDconfig(FalconConfigFields falconConfigFields) {

        // Resets to remove any errors
        configFactoryDefault();

        // Setting it to the minimum allows for more precision
        configNeutralDeadband(0.001);

        // Set the max ouputs
        configPeakOutputForward(falconConfigFields.getMaxOutput());
        configPeakOutputReverse(falconConfigFields.getMaxOutput()); //TODO: Figure out if the timeout should be utilized
    
        //Assigns the PID values to each slot
        int index = 0;
        for(PIDValues falconPID : falconConfigFields.getFalconPIDs())
        {
            config_kP(index, falconPID.getD());
            config_kI(index, falconPID.getI());
            config_kD(index, falconPID.getD());
            config_kF(index, falconPID.getFF());

            index++;
            if(index >= 3) { return; }
        }
    }

    public void setPercentage(double percentage)
    {
        set(ControlMode.PercentOutput, percentage);
    }

    public void setCurrent(double current)
    {
        set(ControlMode.Current, current);
    }

    public void setVelocity(double velocity)
    {
        set(ControlMode.Velocity, velocity);
    }

    public void setPosition(double position)
    {
        set(ControlMode.Position, position);
    }


    

    


}

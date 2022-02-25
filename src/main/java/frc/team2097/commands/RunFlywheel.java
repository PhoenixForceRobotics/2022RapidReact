package frc.team2097.commands;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2097.utils.OI;

public class RunFlywheel extends CommandBase {
    private TalonFX left;
    private TalonFX right;
    private OI oi;
    
    public RunFlywheel(TalonFX left, TalonFX right, OI oi)
    {
        this.left = left;
        this.right = right;
        this.oi = oi;
    }
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        double output = oi.driverController.getLeftTriggerAxis();
        left.set(TalonFXControlMode.PercentOutput, output);
        right.set(TalonFXControlMode.PercentOutput, -output);
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }
}
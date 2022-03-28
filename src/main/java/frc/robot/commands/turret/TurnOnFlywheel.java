package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class TurnOnFlywheel extends CommandBase {
    private Turret turret;

    public TurnOnFlywheel(Turret turret)
    {
        this.turret = turret;
    }
    
    @Override
    public void initialize() {
        turret.setFlywheelPercent(0.75);
    }

    @Override
    public boolean isFinished() {
        return true;
    }


}

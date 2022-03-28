package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class RotateToCenter extends CommandBase {
    private Turret turret;

    public RotateToCenter(Turret turret)
    {
        this.turret = turret;
    }

    @Override
    public void initialize() {
        turret.setRotation(-0.1);
    }

    @Override
    public boolean isFinished() {
        return turret.getTurretRotations() < 1;
    }

    @Override
    public void end(boolean interrupted) {
        turret.setRotation(0);
    }
}

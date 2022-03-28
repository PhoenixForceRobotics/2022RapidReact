package frc.robot.commands.intakefeeder;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class JiggleBelt extends CommandBase {
    private Feeder feeder;
    private Timer timer;
    private double reverse;
    public JiggleBelt(Feeder feeder)
    {
        this.feeder = feeder;
        reverse = 1;
        timer = new Timer();
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        if(timer.get() >= 0.25)
        {
            reverse = reverse == 1 ? -1 : 1;
            timer.reset();
        }

        feeder.setTransporterBottom(0.3 * reverse);
    }

    @Override
    public void end(boolean interrupted) {
        feeder.setTransporterBottom(0);
    }


    
}

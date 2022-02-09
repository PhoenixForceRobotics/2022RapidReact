package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.MotorMap.Climber;
import frc.robot.Robot;

public class ClimberSequence extends SequentialCommandGroup
{
    public ClimberSequence(){
        addCommands(
            new RunPistonExtend(),
            new RunButtonNextSequence(),
            new RunPistonDetract(),
            new RunButtonNextSequence(),
            new RunFlimseyArm(Robot.climber, Robot.pid, 0.6, 0.005),
            new RunSpools(3, 0.005),
            new RunPistonExtend()
            );
    }
}
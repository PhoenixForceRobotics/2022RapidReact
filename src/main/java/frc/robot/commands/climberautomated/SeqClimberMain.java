package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;

public class SeqClimberMain extends SequentialCommandGroup {
  public SeqClimberMain() {
    addCommands(
        new RunPistonExtend(Robot.climberSolenoids, 1),
        // Person moves robot into position
        new RunButtonNextSequence(Robot.climberMotors),
        new RunPistonDetract(Robot.climberSolenoids, 1.5),

        // Moves arm to 6 bar
        new RunClimberArm(Robot.climberMotors, Robot.pid, 0.03 * 12, 0.01, 0.1),
        new Delay(Robot.climberSolenoids, 0.5),

        // Moves hooks off bar and rotate it 90 degrees, is a parallel command group
        new SeqRotateAndExtendPiston(),

        // Extends then rotates the hook onto 10 bar
        new RunPistonExtend(Robot.climberSolenoids, 1.5),
        new RunClimberArm(Robot.climberMotors, Robot.pid, 0.1944 * 12, 0.01, 0.1),
        new Delay(Robot.climberSolenoids, 1),

        // Releases arm from 6 bar
        new RunClimberArm(Robot.climberMotors, Robot.pid, 0 * 12, 0.005, 0.1),

        // wait until swing stops to start next sequence
        new RunButtonNextSequence(Robot.climberMotors),

        // Repeat previous steps except for on the 10 not 6 bar.
        new RunPistonDetract(Robot.climberSolenoids, 1.5),

        // Moves arm to 10 bar
        new RunClimberArm(Robot.climberMotors, Robot.pid, 0.03 * 12, 0.01, 0.1),
        new Delay(Robot.climberSolenoids, 0.5),

        // Moves hooks off bar and rotate it 90 degrees, is a parallel command group
        new SeqRotateAndExtendPiston(),

        // Extends then rotates the hook onto bar
        new RunPistonExtend(Robot.climberSolenoids, 1.5),
        new RunClimberArm(Robot.climberMotors, Robot.pid, 0.1944 * 12, 0.01, 0.1),
        new Delay(Robot.climberSolenoids, 1),

        // Releases arm from 10 bar
        new RunClimberArm(Robot.climberMotors, Robot.pid, 0 * 12, 0.01, 0.1),
        new RunPistonDetract(Robot.climberSolenoids, 1.5));
  }
}

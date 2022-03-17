package frc.robot.commands.autonomous;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import frc.robot.subsystems.Drivebase;
import frc.robot.utils.Constants.AutoConstants;
import frc.robot.utils.Constants.DriveConstants;
import java.util.List;

public class RamseteTemplate extends RamseteCommand {

  RamseteCommand ramseteCommand;
  Drivebase drivebase;

  public RamseteTemplate(Drivebase drivebase) {
    super(
        TrajectoryGenerator.generateTrajectory(
            // Start at the origin facing the +X direction
            new Pose2d(0, 0, new Rotation2d(0)),
            // Pass through these two interior waypoints, making an 's' curve path
            List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
            // End 3 meters straight ahead of where we started, facing forward
            new Pose2d(3, 0, new Rotation2d(0)),
            // Pass config
            AutoConstants.TRAJECTORY_CONFIG),
        drivebase::getPose,
        AutoConstants.RAMSETE_CONTROLLER,
        DriveConstants.FEED_FORWARD,
        DriveConstants.DRIVE_KINEMATICS,
        drivebase::getWheelSpeeds,
        DriveConstants.LEFT_PID,
        DriveConstants.RIGHT_PID,
        // RamseteCommand passes volts to the callback
        drivebase::setVoltage,
        drivebase);
    this.drivebase = drivebase;
  }
}

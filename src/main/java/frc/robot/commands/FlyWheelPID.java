// package frc.robot.commands;

// import com.revrobotics.RelativeEncoder;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
// import frc.robot.subsystems.Flywheel;

// public class FlyWheelPID extends CommandBase{
//     private double P, D;
//     private double previous_error, setVelocity, error, derivative;
//     private Flywheel flywheel;
//     private double PIDSpeed;

//     public FlyWheelPID(Flywheel flywheel, double setVelocity) {
//         this.flywheel = flywheel;
//         P = Constants.SubsystemMath.FlywheelMath.FLYWHEEL_P;
//         D = Constants.SubsystemMath.FlywheelMath.FLYWHEEL_D;
//         previous_error = 0;
//         error = 0;
//         derivative = 0;
//         PIDSpeed = 0;
//         this.setVelocity = setVelocity;
//     }

//     public void PID() {
//         System.out.println(flywheel.getFWLeftEncoderVel());
//         System.out.println("error:" + error);
//         error = setVelocity - flywheel.getFWLeftEncoderVel();
//         derivative = (error - this.previous_error) / .02;
//         PIDSpeed += (P*error + D*derivative) / 5800;
//         this.previous_error = error;
//     }

//     @Override
//     public void initialize() {
//         flywheel.resetFWLeftEncoder();
//     }

//     @Override
//     public void execute() {
//         PID();
//         flywheel.setFlywheel(PIDSpeed);
//     }

//     @Override
//     public boolean isFinished() {
//         return false;
//     }
// }

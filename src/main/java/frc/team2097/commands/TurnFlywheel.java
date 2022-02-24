// package frc.robot.commands;

// import com.revrobotics.RelativeEncoder;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants;
// import frc.robot.subsystems.Flywheel;

// import edu.wpi.first.wpilibj2.command.CommandBase;

// public class TurnFlywheel extends CommandBase {
//     private double P, D;
//     private double previous_error, setVelocity, error, derivative;
//     private Flywheel flywheel;
//     private double PIDSpeed;
//     private boolean done;

//     public TurnFlywheel(Flywheel flywheel, double setVelocity) {
//         this.flywheel = flywheel;
//   //      P = Constants.SubsystemMath.FlywheelMath.FLYWHEEL_P;
//   //      D = Constants.SubsystemMath.FlywheelMath.FLYWHEEL_D;
//   //      previous_error = 0;
//    //     error = 0;
//    //     derivative = 0;
//    //     PIDSpeed = 0;
//    //     this.setVelocity = setVelocity;
//     }
// // 
//     // public boolean PID() {
//     //     error = setVelocity - flywheel.getFWLeftEncoderVel();
//     //     derivative = (error - this.previous_error) / .02;
//     //     PIDSpeed = P*error + D*derivative;
//     //     return (error <= .5 && error >= .5);
//     // }

//     @Override
//     public void initialize() 
//         done = false;
//     //    flywheel.resetFWEncoder(flywheel.fwLeftEncoder);
//     }

//     @Override
//     public void execute() {
//         done = false;
//         flywheel.setFlywheel(.5);
//     }

//     @Override
//     public boolean isFinished() {
//         return true;
//     }
// }

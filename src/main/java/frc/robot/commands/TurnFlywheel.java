package frc.robot.commands;
import java.lang.Math;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
import frc.robot.Robot;

public class TurnFlywheel extends CommandBase {

    private Flywheel flywheel;
    //just for now until we have values from Vision Processing.
    int smallTurnThing = 0;
    int xValue = 0;
    int yValue = 0;
    int midHeight = 10;
    RelativeEncoder encoder; 
    double shooterAngle = 90;
    double groundDistance;
    double currentDistance;

    private boolean done;

    public TurnFlywheel(){
        this.flywheel = Robot.flywheel;
    }

    @Override
    public void initialize() {
        Math.toRadians(shooterAngle);
        groundDistance = (midHeight / Math.sin(shooterAngle));
        currentDistance = groundDistance;
        done = false;
    }

    @Override 
    public void execute() {
        groundDistance = (midHeight / Math.sin(shooterAngle));
            if (groundDistance > currentDistance){
                done = true;
            }
            if(smallTurnThing < 1){ 
                //turns robot a little
                
                flywheel.setFlywheelRotate(0.1);
                encoder = flywheel.getFWRotateEncoder();

                if (encoder.getPosition() >= 5){
                flywheel.setFlywheelRotate(0);
                flywheel.resetDBEncoder(encoder);
                smallTurnThing ++;
                }
            
            }
            smallTurnThing --;
            currentDistance = groundDistance;
        
    
    }
    @Override
    public boolean isFinished(){
        return done;
    }
} 
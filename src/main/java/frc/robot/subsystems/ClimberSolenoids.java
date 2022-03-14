package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Constants;

public class ClimberSolenoids extends SubsystemBase {

    // boolean levitateStatus;
    // boolean pistonBreakStatus;

    // boolean activateNextSequence = false;

    DoubleSolenoid pistonRaiserLeft;
    DoubleSolenoid pistonRaiserRight;
    DoubleSolenoid pistonGearBreak;

    DoubleSolenoid.Value isPiston;

    Timer delay;

    // Encoder
    RelativeEncoder rightClimbingArmEncoder;

    public ClimberSolenoids() {

        // Solenoids
        pistonRaiserLeft = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
                Constants.PneumaticsMap.Climber.SOLENOID1Forward,
                Constants.PneumaticsMap.Climber.SOLENOID1Backward);
        pistonRaiserRight = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
                Constants.PneumaticsMap.Climber.SOLENOID2Forward,
                Constants.PneumaticsMap.Climber.SOLENOID2Backward);

        delay = new Timer();
    }

    // Solenoid commands
    public void Levitate() {
        pistonRaiserLeft.set(Value.kForward);
        pistonRaiserRight.set(Value.kForward);
    }

    public void stopLevitate() {
        pistonRaiserLeft.set(Value.kReverse);
        pistonRaiserRight.set(Value.kReverse);
    }

    public void toggle() {
        isPiston = pistonRaiserLeft.get();
        System.out.println("I pressed:" + isPiston);

        if (isPiston == Value.kForward) {
            pistonRaiserLeft.set(Value.kReverse);
        } else {
            pistonRaiserLeft.set(Value.kForward);
        }
    }

    // Delay Commands
    public void startTimer() {
        delay.start();
    }

    public void stopTimer() {
        delay.stop();
    }

    public void resetTimer() {
        delay.reset();
    }

    public boolean timeElapsed(double seconds) {
        return delay.hasElapsed(seconds);
    }

    // // Activate next sequence
    // public boolean getActivateNextSequence() {
    // return levitateStatus;
    // }

    // public void setActivateNextSequence(boolean value) {
    // levitateStatus = value;
    // }
}

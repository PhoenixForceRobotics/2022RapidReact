package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.utility.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel;


public class Climber extends SubsystemBase{

    public Solenoid pistonRaiserLeft;
    public Solenoid pistonRaiserRight;
    public Solenoid pistonGearBreak;

    public Motor flimsyArm;
    //nicknamed Francis
    public Motor spoolLeft;
    //nicknamed Jose
    public Motor spoolRight;
    //nicknamed Alberta

    public Climber(){
        //pistons
        Solenoid pistonRaiserLeft = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.PneumaticsMap.Climber.SOLENOID1);
        Solenoid pistonRaiserRight = new Solenoid(PneumaticsModuleType.CTREPCM ,Constants.PneumaticsMap.Climber.SOLENOID2);
        Solenoid pistonGearBreak = new Solenoid(PneumaticsModuleType.CTREPCM ,Constants.PneumaticsMap.Climber.SOLENOID3);

        //Motors, motor class is not set up.
        flimsyArm = new Motor(Constants.MotorMap.Climber.FLIMSEYARM, MotorType.kBrushed, Constants.MotorMap.Climber.FlIMSEYARM_REVERSED, 30);
        spoolLeft = new Motor(Constants.MotorMap.Climber.SPOOLLEFT, MotorType.kBrushed, Constants.MotorMap.Climber.SPOOLLEFT_REVERSED, 30);
        spoolRight = new Motor(Constants.MotorMap.Climber.SPOOLRIGHT, MotorType.kBrushed, Constants.MotorMap.Climber.SPOOLRIGHT_REVERSED, 30);
    }

    public void levitate(){
        pistonRaiserLeft.set(true);
        pistonRaiserRight.set(true);
    }

    public void stopLevitate(){
        pistonRaiserLeft.set(false);
        pistonRaiserRight.set(false);
    }

    public void activatePistonBreak(){
        pistonGearBreak.set(true);
    }

    public void deactivatePistonBreak(){
        pistonGearBreak.set(false);
    }

    public void setFlimseyArm(double value)
    {
        flimsyArm.set(value);
    }

    public void setSpools(double value)
    {
        spoolRight.set(value);
        spoolLeft.set(value);
    }

    public void turnOffSpools(double value)
    {
        spoolRight.set(0);
        spoolLeft.set(0);
    }

    public void turnOffFlimseyArm(double value)
    {
        flimsyArm.set(0);
    }
}
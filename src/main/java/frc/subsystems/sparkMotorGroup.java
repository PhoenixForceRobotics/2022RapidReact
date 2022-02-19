package frc.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class sparkMotorGroup extends MotorControllerGroup {

    CANSparkMax leader;
    CANSparkMax[] followers;

    public sparkMotorGroup(CANSparkMax leader, CANSparkMax[] followers) {
        super(leader, followers);
        this.leader = leader;
        this.followers = followers;
        //TODO Auto-generated constructor stub
    }
    
}

package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP feederMotor = new VictorSP(RobotMap.ballFeeder);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void runForward(){
    	feederMotor.setSpeed(1);
    }
    
    public void runBackward(){
    	feederMotor.setSpeed(-1);
    }
    
    public void stop(){
    	feederMotor.setSpeed(0);
    }
}


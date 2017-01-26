package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon feederMotor = new Talon(RobotMap.Feeder);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void runForward(){
    	feederMotor.setSpeed(0.4);
    }
    
    public void runBackward(){
    	feederMotor.setSpeed(-0.4);
    }
    
    public void stop(){
    	feederMotor.setSpeed(0);
    }
}


package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
	VictorSP feederMotor;
	
	public Feeder(){
    	feederMotor = new VictorSP(RobotMap.ballFeeder);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void runForward(){
    	feederMotor.set(-1);
    }
    
    public void runBackward(){
    	feederMotor.set(1);
    }
    
    public void stop(){
    	feederMotor.set(0);
    }
}


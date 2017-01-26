package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearPouch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	// SENSORS FOR THE TWO BANNERS AND A IF WE HAVE A GEAR SENSOR.
	DigitalInput leftBanner;
	DigitalInput rightBanner;
	DigitalInput hasGearButton;
	
	public GearPouch(){
		leftBanner = new DigitalInput(RobotMap.LEFT_BANNER_PIN);
    	rightBanner = new DigitalInput(RobotMap.RIGHT_BANNER_PIN);
    	hasGearButton = new DigitalInput(RobotMap.HAS_GEAR_BUTTON_PIN);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public int isAligned(){
    	if(leftBanner.get() && rightBanner.get()){
    		return 1;
    	}
    	if(leftBanner.get() && !rightBanner.get()){
    		return -1;
    	}
    	if(rightBanner.get() && !leftBanner.get()){
    		return -2;
    	}
    	return 0;
    }
    
    public boolean hasGear(){
    	return hasGearButton.get();
    }
}


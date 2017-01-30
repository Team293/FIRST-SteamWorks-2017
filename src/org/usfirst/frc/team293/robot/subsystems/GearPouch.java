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
    	hasGearButton = new DigitalInput(RobotMap.limitGear);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean hasGear(){
    	return hasGearButton.get();
    }
}


package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearPouch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DigitalInput hasGearButton;
	Servo gearServo1;
	Servo gearServo2;
	int minAngle = 50;
	int maxAngle = 140;

	
	public GearPouch(){
    	hasGearButton = new DigitalInput(RobotMap.limitGear);
    	gearServo1 = new Servo(RobotMap.flapServo[0]);
    	gearServo2 = new Servo(RobotMap.flapServo[1]);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean hasGear(){
    	return hasGearButton.get();
    }
    
    public void closeFlap() {
    	gearServo1.setAngle(minAngle);
    	gearServo2.setAngle(-minAngle);
    }
    public void openFlap() {
    	gearServo1.setAngle(maxAngle);
    	gearServo2.setAngle(-maxAngle);
    }
    public void disableFLap() {
    	gearServo1.setDisabled();
    	gearServo2.setDisabled();
    }
    
}


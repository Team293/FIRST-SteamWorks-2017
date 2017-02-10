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
	//DigitalInput hasGearButton;	//removed for now
	Servo gearServo1;
	Servo gearServo2;
	final int MIN_ANGLE = 50;
	final int MAX_ANGLE = 140;

	
	public GearPouch(){
    	//hasGearButton = new DigitalInput(RobotMap.limitGear);	//removed for now
    	gearServo1 = new Servo(RobotMap.flapServo[0]);
    	gearServo2 = new Servo(RobotMap.flapServo[1]);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //public boolean hasGear(){		//removed for now
    //	return hasGearButton.get();
    //}
    
    public void closeFlap() {
    	gearServo1.setAngle(MIN_ANGLE);
    	gearServo2.setAngle(-MIN_ANGLE);
    }
    public void openFlap() {
    	gearServo1.setAngle(MAX_ANGLE);
    	gearServo2.setAngle(-MAX_ANGLE);
    }
    public void disableFlap() {
    	gearServo1.setDisabled();
    	gearServo2.setDisabled();
    }
    
}


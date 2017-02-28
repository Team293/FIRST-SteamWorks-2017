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
	DigitalInput hasGearButton;	//removed for now
	Servo gearServo1;
	Servo gearServo2;

	
	public GearPouch(){
    	hasGearButton = new DigitalInput(RobotMap.limitGear);	//removed for now
    	gearServo1 = new Servo(RobotMap.flapServo[0]);
    	gearServo2 = new Servo(RobotMap.flapServo[1]);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean hasGear(){		//removed for now
    	return hasGearButton.get();
    }
    
    public void upFlap() {
    	gearServo1.set(.2);
    	gearServo2.set(.8);
    }
    public void downFlap() {
    	gearServo1.set(.48);
    	gearServo2.set(.47);
    }
    public void disableFlap() {
    	gearServo1.setDisabled();
    	gearServo2.setDisabled();
    }
    
}


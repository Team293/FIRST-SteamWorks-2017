package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.OI;
import org.usfirst.frc.team293.robot.Robot;
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
	public DigitalInput hasGear;	//removed for now
	Servo gearServo1;
	Servo gearServo2;

	
	public GearPouch(){
    	hasGear = new DigitalInput(RobotMap.limitGear);	//removed for now
    	gearServo1 = new Servo(RobotMap.flapServo[0]);
    	gearServo2 = new Servo(RobotMap.flapServo[1]);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    
    public void upFlap() {
    	gearServo1.set(.25);
    	gearServo2.set(.75);
    	OI.LEDFlaps.on();
    }
    public void downFlap() {
    	gearServo1.set(.58);
    	gearServo2.set(.38);
    	OI.LEDFlaps.off();
    }
    public void disableFlap() {
    //	gearServo1.setDisabled();
    //	gearServo2.setDisabled();
    }
    
}


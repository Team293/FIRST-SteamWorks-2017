package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.OI;
import edu.wpi.first.wpilibj.command.Subsystem;


public class LEDButton extends Subsystem {

	//}		//Allows for the Launchpad LED buttons to light up
	private int port;
	private boolean status;
	private long time;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public LEDButton(int i){
    	super();
    	this.status=false;
    	this.port = i;
    	this.time= System.currentTimeMillis();
    }
    
    public void on(){
    	this.status=true;
    	OI.launchpad.setOutput(this.port, this.status);
    	this.time = System.currentTimeMillis();
    }
    public void off(){
    	this.status=false;
    	OI.launchpad.setOutput(this.port, this.status);
    	this.time = System.currentTimeMillis();
    }
    public void flash(int wait){
    	if((System.currentTimeMillis()-this.time)>wait){
    		this.status = !this.status;
    		OI.launchpad.setOutput(this.port, this.status);
    		this.time = System.currentTimeMillis();
    	}
    }
    public boolean getStatus(){
    	return this.status;
    }
}
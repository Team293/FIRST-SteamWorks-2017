package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoGearWait extends Command {
	boolean done;
	Timer timer;
    public AutoGearWait() {
    	timer=new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.stop();
    	done=false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(!Robot.gearPouch.hasGear.get()){
    		done=true;
    		timer.start();
    	}    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get()>.25;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

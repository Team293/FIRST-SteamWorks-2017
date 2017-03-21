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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	done=Robot.gearPouch.hasGear.get();
    	if(timer.get()>5&&timer.get()<5.5&&Robot.gearPouch.hasGear.get()){
    		Robot.driveTrain.tankdrive(-.5, -.5);
    	}
    	if(timer.get()>5.5&&timer.get()<6.25&&Robot.gearPouch.hasGear.get()){
    		Robot.driveTrain.tankdrive(.5, .5);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

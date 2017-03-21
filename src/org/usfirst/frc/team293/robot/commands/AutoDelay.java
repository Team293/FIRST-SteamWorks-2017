package org.usfirst.frc.team293.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDelay extends Command {
	double times;
    public AutoDelay(double d) {
    	times=d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(times);  // set x second timeout
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

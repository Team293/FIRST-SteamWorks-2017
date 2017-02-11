package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveReverse extends Command {
	boolean blah;
    public DriveReverse() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.driveTrain);
    	blah=false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.print("blah");
    	//Robot.driveTrain.reverseDrive();  //switches directions  	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.reverseDrive(); 
    	blah=true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return blah;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

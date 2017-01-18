package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurnGyro extends Command {
	double angle;
	double speed;
	double rate;
	boolean status;
    public DriveTurnGyro(double speed, double angle, double rate) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain); 	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	status=Robot.driveTrain.gyroTurn(speed, angle, rate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return status;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.tankdrive(0, 0);
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

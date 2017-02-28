package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.OI;
import org.usfirst.frc.team293.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimberUp extends Command {

    public ClimberUp() {
    	requires(Robot.Climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Climber.start();
    	Robot.lEDs.sendData(Robot.lEDs.climbing);
    	SmartDashboard.putBoolean("Climbing?", true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Climber.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.Climber.stop();
    }
}

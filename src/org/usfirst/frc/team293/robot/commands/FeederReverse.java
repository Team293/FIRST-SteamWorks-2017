package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FeederReverse extends Command {
	
	public FeederReverse() {
		requires(Robot.feeder);
	}
	protected void initialize(){
		Robot.lEDs.sendData(Robot.lEDs.whenFeeding);
		SmartDashboard.putBoolean("Feeder Moving?", true);
	}
	
	protected void execute(){
		Robot.feeder.runBackward();
	}
	
	protected boolean isFinished() {
		return true;
	}
	
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }

}

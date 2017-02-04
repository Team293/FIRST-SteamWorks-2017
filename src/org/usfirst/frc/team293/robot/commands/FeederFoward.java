package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FeederFoward extends Command {
	
	public FeederFoward() {
		// TODO Auto-generated constructor stub
		requires(Robot.Feeder);
	}
	protected void initialize(){
		Robot.Feeder.runForward();
		Robot.LEDs.sendData(Robot.LEDs.orangeSolid);
	}
	
	protected void execute(){
		
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
    protected void end() {
    	
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }

}

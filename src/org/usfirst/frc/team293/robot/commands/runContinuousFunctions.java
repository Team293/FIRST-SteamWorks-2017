package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;
import org.usfirst.frc.team293.robot.subsystems.LEDs;
import org.usfirst.frc.team293.robot.subsystems.ContinuousFunctions;

import edu.wpi.first.wpilibj.command.Command;

public class runContinuousFunctions extends Command {

	public runContinuousFunctions(){
		requires(Robot.ContinuousFunctions);
	}
	
	protected void execute(){
//		Robot.ContinuousFunctions.hasGear = Robot.GearPouch.hasGear();	
	}
	
	public void sendLEDCode(){
//		if(Robot.ContinuousFunctions.hasGear){
	//		Robot.LEDs.sendData(Robot.LEDs.yellowSolid);
	//	}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

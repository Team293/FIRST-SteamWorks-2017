package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;
import org.usfirst.frc.team293.robot.subsystems.continuousFunctions;

import edu.wpi.first.wpilibj.command.Command;

public class runContinuousFunctions extends Command {

	public runContinuousFunctions(){
		requires(Robot.ContinuousFunctions);
	}
	
	protected void execute(){
		Robot.ContinuousFunctions.hasGear = Robot.GearPouch.hasGear();
		System.out.println(Robot.ContinuousFunctions.hasGear);
		Robot.ContinuousFunctions.isAligned = Robot.GearPouch.isAligned();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

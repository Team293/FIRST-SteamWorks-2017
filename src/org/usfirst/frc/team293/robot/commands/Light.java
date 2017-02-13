package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class Light extends Command {
	int light;
	public Light(){
		requires(OI.LEDThree);
	}
	public void initialize(){
		OI.LEDThree.on();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
}

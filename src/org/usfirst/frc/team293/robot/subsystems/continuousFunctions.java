package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.commands.runContinuousFunctions;

import edu.wpi.first.wpilibj.command.Subsystem;

public class continuousFunctions extends Subsystem {
	public boolean hasGear = false;
	public int isAligned = 0;
	
	public continuousFunctions(){
		
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new runContinuousFunctions());
	}
}

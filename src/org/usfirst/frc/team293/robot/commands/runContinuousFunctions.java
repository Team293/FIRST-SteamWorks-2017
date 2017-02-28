package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;
import org.usfirst.frc.team293.robot.subsystems.LEDs;
import org.usfirst.frc.team293.robot.subsystems.ContinuousFunctions;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class runContinuousFunctions extends Command {

	public runContinuousFunctions(){
		requires(Robot.ContinuousFunctions);
	}
	   protected void initialize() {
	    	Robot.ContinuousFunctions.pdp.clearStickyFaults();
	    }
	protected void execute(){
		Robot.ContinuousFunctions.currentMonitor();
		Robot.ContinuousFunctions.sensorLog();
		SmartDashboard.putBoolean("Has Gear", Robot.gearPouch.hasGear());
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

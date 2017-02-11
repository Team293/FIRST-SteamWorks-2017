package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.Robot;
import org.usfirst.frc.team293.robot.RobotMap;
import org.usfirst.frc.team293.robot.commands.runContinuousFunctions;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class ContinuousFunctions extends Subsystem {
	public boolean hasGear = false;
	public int isAligned = 0;
    //public Trigger trigger;
	
	public PowerDistributionPanel pdp;
	
	public ContinuousFunctions(){
		pdp= new PowerDistributionPanel();
		//pdp.clearStickyFaults();
	//	trigger.equals(true);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new runContinuousFunctions());
	}
	
	public void currentMonitor(){
		
		SmartDashboard.putBoolean("Drive Direction", Robot.driveTrain.forward);
		
		SmartDashboard.putNumber("Total Current", pdp.getTotalCurrent());
		SmartDashboard.putNumber("DriveTrain Current", pdp.getCurrent(RobotMap.pdpLeftDrive[0])+pdp.getCurrent(RobotMap.pdpLeftDrive[1])+pdp.getCurrent(RobotMap.pdpLeftDrive[2])+pdp.getCurrent(RobotMap.pdpRightDrive[0])+pdp.getCurrent(RobotMap.pdpRightDrive[1])+pdp.getCurrent(RobotMap.pdpRightDrive[2]));
		SmartDashboard.putNumber("Shooter Current", pdp.getCurrent(RobotMap.pdpShooter));
		SmartDashboard.putNumber("Climber Current", pdp.getCurrent(RobotMap.pdpClimber));
		
		if (pdp.getCurrent(RobotMap.pdpShooterTrigger)>10||pdp.getCurrent(RobotMap.pdpClimber)>35||pdp.getCurrent(RobotMap.pdpBallFeeder)>10){
			SmartDashboard.putBoolean("Power Warning", true);	//OH BOY A MOTOR IS BURNING!
		}
		else{
			SmartDashboard.putBoolean("Power Warning", false);	
		}
	}


}

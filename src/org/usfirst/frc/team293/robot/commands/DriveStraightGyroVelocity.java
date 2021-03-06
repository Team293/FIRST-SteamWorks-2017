package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class DriveStraightGyroVelocity extends Command {
	double distance=0;
	double speed=0;
	double slowDownDistance=10;
	double slowDownMultiplier=1;
	double speedUpMultipler=1;
	boolean finalCommand=false;
	Timer timer;
    public DriveStraightGyroVelocity(double speeds,double distances,boolean lastCommands) {
    	requires(Robot.driveTrain);
    	distance=distances;
    	speed=speeds;
    	finalCommand=lastCommands;
    	timer=new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetGyro();
    	Robot.driveTrain.resetEnc();
    	timer.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double encoder = Robot.driveTrain.readEnc()[0];
    	SmartDashboard.putNumber("AutoStraightEncoder", encoder);
    	double distanceToGo=(distance-encoder);
    	
    	if(1<timer.get()){
    		Robot.driveTrain.velocityStraight(speed*timer.get());
    	}
    	
    	if(distanceToGo>slowDownDistance&&1>timer.get()){
    		Robot.driveTrain.velocityStraight(speed);
    	}
    	
    	if(distanceToGo<slowDownDistance&&1>timer.get()){    	
    		slowDownMultiplier= (distanceToGo)/slowDownDistance;
    		Robot.driveTrain.velocityStraight(speed*slowDownMultiplier);
    	}
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {		//Finish this thing if its the last command and we went the distance, or if we are close up against the wall and the current spiked
        return ((distance<=Robot.driveTrain.readEnc()[0] && !finalCommand));
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.driveTrain.velocityStraight(0);
    }
 
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class runFeeder extends Command {
	private int direction = 0;
	
	public runFeeder(int direction) {
		// TODO Auto-generated constructor stub
		this.direction = direction;
		requires(Robot.Feeder);
	}
	
	protected void execute(){
		switch(direction){
		case -1:
			Robot.Feeder.runBackward();
			break;
		case 0:
			Robot.Feeder.stop();
			break;
		case 1:
			Robot.Feeder.runForward();
			break;
		default:
			Robot.Feeder.stop();
			break;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}

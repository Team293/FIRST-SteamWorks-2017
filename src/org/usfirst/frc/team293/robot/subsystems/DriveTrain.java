package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private SpeedController leftMotor, rightMotor;
	private RobotDrive drive;
	private Encoder leftEncoder, rightEncoder;
	
	public DriveTrain(){	//make drivetrain stuff
		leftMotor = new VictorSP(RobotMap.leftDrive);
		rightMotor = new VictorSP(RobotMap.rightDrive);
		drive = new RobotDrive(leftMotor, rightMotor);	
		leftEncoder= new Encoder(0,1);
		rightEncoder= new Encoder(2,3);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    
    public void tankdrive(double left, double right){
		drive.tankDrive(left, right);
	}
    
    public void driveStraight(double speed){
    	
    }
	public void resetEnc(){
		leftEncoder.reset();
		rightEncoder.reset();
	}

}


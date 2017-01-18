package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private SpeedController leftMotor, rightMotor;
	private Joystick leftStick, rightStick;
	private Gyro gyro;
	private RobotDrive drive;
	private Encoder leftEncoder, rightEncoder;
	double finalPower=.5;
	double pValue=-1.75;
	double dValue=-0;
	double offsetGyro;
	double previousError=0;
	double error;
	double setpoint=0;
	double derivative;
	
	public DriveTrain(){	//make drivetrain stuff
		leftMotor = new VictorSP(RobotMap.leftDrive);
		rightMotor = new VictorSP(RobotMap.rightDrive);
		drive = new RobotDrive(leftMotor, rightMotor);	
		leftEncoder= new Encoder(0,1);
		rightEncoder= new Encoder(2,3);

    	gyro=new ADXRS450_Gyro();
        drive.tankDrive(.5,.5);

        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
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


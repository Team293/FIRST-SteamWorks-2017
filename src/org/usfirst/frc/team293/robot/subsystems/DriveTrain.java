package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;
import org.usfirst.frc.team293.robot.commands.DefaultTankDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends Subsystem {
	private SpeedController leftMotor, rightMotor;

	private Gyro gyro;
	private RobotDrive drive;
	private Encoder leftEncoder, rightEncoder;
	
	double finalPower=.5;
	double pValue=-1.75;
	double dValue=-0;
	double previousError=0;
	double error;
	double setpoint=0;
	double derivative;
	double angle;
	double offsetGyro;
	
	public boolean turning=false;
	
	public DriveTrain(){	//make drivetrain stuff
		leftMotor = new VictorSP(RobotMap.leftDrive);
		rightMotor = new VictorSP(RobotMap.rightDrive);
		drive = new RobotDrive(leftMotor, rightMotor);	
		
		leftEncoder= new Encoder(0,1);
		rightEncoder= new Encoder(2,3);

    	gyro=new ADXRS450_Gyro();

	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DefaultTankDrive());
    }  
    
    public void tankdrive(double left, double right){
		drive.tankDrive(left, right);
	}
    
    public void resetGyro(){
    	offsetGyro=gyro.getAngle();
    }
    
    public void gyroStraight(double speed){
    	angle=gyro.getAngle()-offsetGyro;
    	error=(angle-setpoint);
        
        finalPower=speed+(error*pValue);
        drive.tankDrive(speed,finalPower);
       // SmartDashboard.putNumber("gyroGetRate", gyro.getRate());
        SmartDashboard.putNumber("GyroAngle", angle);
        SmartDashboard.putNumber("offsetGyro", offsetGyro);    	
    }

    public boolean gyroTurn(double speed, double angle, double rate){
    	
    	angle=gyro.getAngle()-offsetGyro;
    	setpoint+=rate;
    	error=(angle-setpoint);
        
        finalPower=speed+(error*pValue);
        drive.tankDrive(speed,finalPower);
        if (Math.abs(setpoint)>=Math.abs(angle)){
        	turning=true;
        }
        
        return turning;
    }
    
	public void resetEnc(){
		leftEncoder.reset();
		rightEncoder.reset();
	}

}


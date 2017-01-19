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
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
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
		
		leftEncoder= new Encoder(RobotMap.leftEncoder[0],RobotMap.rightEncoder[1],true, EncodingType.k4X);	//creates encoder with fast sampling and true or false for direction
		rightEncoder= new Encoder(RobotMap.rightEncoder[0],RobotMap.leftEncoder[1],false, EncodingType.k4X);
		
		leftEncoder.setDistancePerPulse(150);//the amount of ticks to ft...still have to find this from P
    	gyro=new ADXRS450_Gyro();		//`	
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
    
    public boolean gyroTurnInPlace(double angle, double rate){
    	angle=gyro.getAngle()-offsetGyro; ///Gets the angle and subtracts initial angle
    	setpoint+=rate;  //adds the rate into the setpoint to gradually change it
    	error=(angle-setpoint); //finds how far you are off from the setpoint
        
        finalPower=(error*pValue);
        drive.tankDrive(-finalPower,finalPower);
        if (Math.abs(setpoint)>=Math.abs(angle)){
        	turning=true;
        }
        
        return turning;
    }
    
	public void resetEnc(){
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public double[] readEnc(){
		double leftDistance= leftEncoder.getDistance();
		double rightDistance=rightEncoder.getDistance();
		double[] encoders= {(leftDistance+rightDistance)/2,leftDistance, rightDistance};
		return encoders;
	}

}


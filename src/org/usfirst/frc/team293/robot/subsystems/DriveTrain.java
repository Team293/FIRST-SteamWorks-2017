package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.Robot;
import org.usfirst.frc.team293.robot.RobotMap;
import org.usfirst.frc.team293.robot.commands.DefaultTankDrive;

import com.ctre.PigeonImu;
import com.ctre.PigeonImu.PigeonState;

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
	private SpeedController leftMotorOne, leftMotorTwo, leftMotorThree, rightMotorOne, rightMotorTwo, rightMotorThree;

	private PigeonImu imu;
	private RobotDrive drive;
	private Encoder leftEncoder, rightEncoder;
	public boolean reverseDirection=false;
	
	double finalPower=.5;
	double pValue=-1.75;
	double dValue=-0;
	double previousError=0;
	double error;
	double setpoint=0;
	double derivative;
	double angle;
	double offsetGyro;
	public boolean forward = true;
	
	public boolean imuStatus;
	public boolean direction=false;
	
	public boolean turning=false;
	
	public DriveTrain(){	//make drivetrain stuff
		leftMotorOne = new VictorSP(RobotMap.leftDrive[0]);
		leftMotorTwo= new VictorSP(RobotMap.leftDrive[1]);
		rightMotorOne= new VictorSP(RobotMap.rightDrive[0]);
		rightMotorTwo= new VictorSP(RobotMap.rightDrive[1]);
		
		imu=new PigeonImu(RobotMap.imu);
    	imu.EnableTemperatureCompensation(true);
    	
		drive = new RobotDrive(leftMotorOne, leftMotorTwo, rightMotorOne, rightMotorTwo);	
		
		leftEncoder= new Encoder(RobotMap.leftEncoder[0],RobotMap.rightEncoder[1],true, EncodingType.k4X);	//creates encoder with fast sampling and true or false for direction
		rightEncoder= new Encoder(RobotMap.rightEncoder[0],RobotMap.leftEncoder[1],false, EncodingType.k4X);
		
		leftEncoder.setDistancePerPulse(150);//the amount of ticks to ft...still have to find this from P
	}
 
    public void initDefaultCommand() {       
        setDefaultCommand(new DefaultTankDrive());	// Set the default command for a subsystem here.
    }  
    
    
    public void tankdrive(double left, double right){
      	if (forward==false){
    		drive.tankDrive(-right, -left);
    	}
      	else{
    		drive.tankDrive(left, right);  
    	}
  
	}
    
    public void reverseDrive(){								//Switch Direction we're going
    	
    	SmartDashboard.putNumber("Reverse Drive", 1000);
    	if (forward == true) {
    		forward = false;
    		Robot.LEDs.sendData(Robot.LEDs.purpleSolid);
    	} else {
    		forward = true;
    		Robot.LEDs.sendData(Robot.LEDs.whiteSolid);
    	}
    }
   
//////////////////////////////Gyro Stuff-->>>///////////////////////////////////////////////
    public void resetGyro(){
    	imu.SetFusedHeading(0.0);
    }
    
    public void gyroStraight(double speed){
    	PigeonImu.FusionStatus fusionStatus = new PigeonImu.FusionStatus();
    	imuStatus = (imu.GetState() != PigeonState.NoComm);
    	
     	angle=imu.GetFusedHeading(fusionStatus);
     	
    	error=(angle-setpoint);
        
        finalPower=speed+(error*pValue);
        drive.tankDrive(speed,finalPower);
       // SmartDashboard.putNumber("gyroGetRate", gyro.getRate());
        SmartDashboard.putNumber("GyroAngle", angle);
        SmartDashboard.putNumber("offsetGyro", offsetGyro);    	
    }

    public boolean gyroTurn(double speed, double angle, double rate){
    	PigeonImu.FusionStatus fusionStatus = new PigeonImu.FusionStatus();
    	angle=imu.GetFusedHeading(fusionStatus);
    	
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
    	PigeonImu.FusionStatus fusionStatus = new PigeonImu.FusionStatus();
    	angle=imu.GetFusedHeading(fusionStatus); ///Gets the angle
    	setpoint+=rate;  //adds the rate into the setpoint to gradually change it
    	error=(angle-setpoint); //finds how far you are off from the setpoint
        
        finalPower=(error*pValue);
        drive.tankDrive(-finalPower,finalPower);
        if (Math.abs(setpoint)>=Math.abs(angle)){
        	turning=true;
        }
        
        return turning;
    }
  //////////// ^Gyro Stuff  Encoder stuff--->>>  
    
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


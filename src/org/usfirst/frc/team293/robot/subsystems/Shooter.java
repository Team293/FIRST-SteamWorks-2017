package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;
import org.usfirst.frc.team293.robot.commands.ShooterLowGoal;

import com.ctre.CANTalon;
import com.ctre.CanTalonJNI;
import com.ctre.CANTalon.TalonControlMode;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Shooter extends Subsystem {
	CANTalon shooter;
	Victor shooterTrigger;
	public Shooter(){
		shooter =new CANTalon(RobotMap.shooter);
		shooterTrigger= new Victor(RobotMap.shooterTrigger);
		
		shooter.changeControlMode(TalonControlMode.PercentVbus);
		shooter.setFeedbackDevice(FeedbackDevice.EncFalling);
		shooter.reverseOutput(false);
		shooter.reverseSensor(false);
		shooter.configEncoderCodesPerRev(256);
		//shooterwheel.getMotionProfileTopLevelBufferCount();
		shooter.setPID(22,0.00001, 1); // Set the PID constants (p, i, d)
		shooter.setF(.6);// what we think it should be
	}
	
    public void initDefaultCommand() {
    }
    
    public void ShootHigh(){
    	shooter.enableControl(); // Enable PID control on the talon
    	shooter.set(-1);
    	shooterTrigger.set(-1);
    }
    
    public void ShootLow(){
    	//shooter.enableControl(); // Enable PID control on the talon
    	shooterTrigger.set(-0.5);
    	shooter.set(-0.5);
    }
    
    public void Stop(){
    	shooterTrigger.set(0);
    	shooter.set(0.0);
    	//shooter.disableControl(); // Enable PID control on the talon
    }
    
}


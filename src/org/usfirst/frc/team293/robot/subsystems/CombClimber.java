package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CombClimber extends Subsystem {
	
	CANTalon climber;
	
	public CombClimber(){
		climber =new CANTalon(RobotMap.climber);		
		climber.changeControlMode(TalonControlMode.PercentVbus);
		climber.enableBrakeMode(true);
		climber.EnableCurrentLimit(true);
		climber.setCurrentLimit(38);
	}
	
    public void initDefaultCommand() {
    }
    
    public void start(){
    	climber.set(1);   	
    }
    
    public void reverse(){
    	climber.set(-1);
    }
    
    public void stop(){
    	climber.set(0); 	
    }
}


package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyro;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyro;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StraightTurnRightGear_GyroEncoder extends CommandGroup {
    
    public  StraightTurnRightGear_GyroEncoder() {
    	addSequential(new DriveStraightGyro(10,.5));//distance and speed
    	addSequential(new DriveTurnGyroInPlace(45,3));	//angle, rate
    }
}

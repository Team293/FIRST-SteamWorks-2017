//home-tested

package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyroEncoder;
import org.usfirst.frc.team293.robot.commands.DriveStraightGyroVelocity;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearTurnRight_GyroEncoder extends CommandGroup {
    
    public  GearTurnRight_GyroEncoder() {
    	addSequential(new DriveStraightGyroVelocity(.4,102,false));//distance and speed
    	addSequential(new DriveTurnGyroInPlace(-60,-.6));	//angle, rate
    	addSequential(new DriveStraightGyroVelocity(.4,15,true));//distance and speed
    }
}

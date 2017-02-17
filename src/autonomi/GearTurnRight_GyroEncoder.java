//home-tested

package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyroEncoder;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearTurnRight_GyroEncoder extends CommandGroup {
    
    public  GearTurnRight_GyroEncoder() {
    	addSequential(new DriveStraightGyroEncoder(120,.5));//distance and speed
    	addSequential(new DriveTurnGyroInPlace(-60,-.6));	//angle, rate
    }
}

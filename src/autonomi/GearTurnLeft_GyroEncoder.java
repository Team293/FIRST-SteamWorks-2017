//home-tested

package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyro;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearTurnLeft_GyroEncoder extends CommandGroup {
    
    public  GearTurnLeft_GyroEncoder() {
    	addSequential(new DriveStraightGyro(120,.5));//distance and speed //subtract length of robot??
    	addSequential(new DriveTurnGyroInPlace(60,.6));	//angle, rate
    }
}

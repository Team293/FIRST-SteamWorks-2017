//home-tested

package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyro;
import org.usfirst.frc.team293.robot.commands.DriveStraightGyroVelocity;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearTurnLeft_GyroEncoder extends CommandGroup {
    
    public  GearTurnLeft_GyroEncoder() {
        addSequential(new DriveStraightGyroVelocity(.4,97,false));
    	addSequential(new DriveTurnGyroInPlace(58,.6));	//angle, rate
    	 addSequential(new DriveStraightGyroVelocity(.4,20 ,true));
    }
}

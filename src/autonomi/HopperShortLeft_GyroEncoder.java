package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyro;
import org.usfirst.frc.team293.robot.commands.DriveStraightGyroEncoder;
import org.usfirst.frc.team293.robot.commands.DriveStraightGyroVelocity;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;
import org.usfirst.frc.team293.robot.commands.GearFlapDown;
import org.usfirst.frc.team293.robot.commands.ShooterHighGoal;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HopperShortLeft_GyroEncoder extends CommandGroup {
    /*Basically, this autonomous program should consist of the StraightGear_GyroEncoder program as well as being able to turn and
	approach the goal. This should be possible if our team mates don't do the same thing.*/
    public  HopperShortLeft_GyroEncoder() {
    	addParallel(new GearFlapDown());
        addSequential(new DriveStraightGyroVelocity(.4,75,false));	//should be good
    	addSequential(new DriveTurnGyroInPlace(90, 3));
        addSequential(new DriveStraightGyroVelocity(.4,28,false));	//should be good    
    }
}

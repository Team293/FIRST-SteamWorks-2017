package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyro;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;
import org.usfirst.frc.team293.robot.commands.ShooterHighGoal;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StraightTurnLeftGearApproachGoal_GyroEncoder extends CommandGroup {
    /*Basically, this autonomous program should consist of the StraightGear_GyroEncoder program as well as being able to turn and
	approach the goal. This should be possible if our teammates don't do the same thing.*/
    public  StraightTurnLeftGearApproachGoal_GyroEncoder() {
    	addSequential(new StraightTurnLeftGear_GyroEncoder());
    	addSequential(new DriveStraightGyro(10,-.5));  //distance and speed DIMENSIONS TBD
    	addSequential(new DriveTurnGyroInPlace(15,3));	//angle, rate DIMENSIONS TBD
    	addSequential(new DriveStraightGyro(2,-.5));  //distance and speed DIMENSIONS TBD
    	addSequential(new DriveTurnGyroInPlace(-10,3));	//angle, rate DIMENSIONS TBD
    	addSequential(new DriveStraightGyro(5, -.5));	//DIMENSIONS TBD
    	addSequential(new ShooterHighGoal());
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

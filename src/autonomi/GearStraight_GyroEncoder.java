package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyroEncoder;
import org.usfirst.frc.team293.robot.commands.DriveStraightGyroVelocity;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearStraight_GyroEncoder extends CommandGroup {
    //So this distance is 9.5 ft...but the robot is 36 inches so that makes the distance the front needs to go 6.5 ft
    public  GearStraight_GyroEncoder() {
    	//addSequential(new DriveStraightGyroEncoder(88,.5));	//real is 88 //actual 78
        addSequential(new DriveStraightGyroVelocity(.4,88,true));
    	//addSequential(new )
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

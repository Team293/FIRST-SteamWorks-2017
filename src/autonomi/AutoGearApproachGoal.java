package autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearApproachGoal extends CommandGroup {
    /*Basically, this autonomous program should consist of the StraightGear_GyroEncoder program as well as being able to turn and
	approach the goal. This should be possible if our teammates don't do the same thing.*/
    public  AutoGearApproachGoal() {
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

package autonomi;

import org.usfirst.frc.team293.robot.commands.AutoDelay;
import org.usfirst.frc.team293.robot.commands.AutoGearWait;
import org.usfirst.frc.team293.robot.commands.DriveStraightGyroEncoder;
import org.usfirst.frc.team293.robot.commands.DriveStraightGyroVelocity;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;
import org.usfirst.frc.team293.robot.commands.GearFlapDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearLeftHopperRight_GyroEncoder extends CommandGroup {
    
    public  GearLeftHopperRight_GyroEncoder() {
    	addSequential(new GearTurnLeft_GyroEncoder());
    	addSequential(new AutoGearWait());
    	addSequential(new AutoDelay(1));
    	addSequential(new DriveStraightGyroVelocity(.5,10,false));
    	addSequential(new DriveTurnGyroInPlace(-58,-.6));	//angle, rate
    	addSequential(new DriveStraightGyroVelocity(.8,300,false));
    	addSequential(new DriveTurnGyroInPlace(-90,-2.5));	//angle, rate
    	addParallel(new GearFlapDown());
    	addSequential(new DriveStraightGyroVelocity(.7,50,false));	//50 TBD BUT EVERYTHING ELSE SHOULD BE GOOD
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

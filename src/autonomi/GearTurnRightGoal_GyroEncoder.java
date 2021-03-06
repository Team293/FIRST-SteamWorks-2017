package autonomi;

import org.usfirst.frc.team293.robot.commands.AutoDelay;
import org.usfirst.frc.team293.robot.commands.AutoGearWait;
import org.usfirst.frc.team293.robot.commands.DriveStraightGyro;
import org.usfirst.frc.team293.robot.commands.DriveStraightGyroVelocity;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;
import org.usfirst.frc.team293.robot.commands.FeederFoward;
import org.usfirst.frc.team293.robot.commands.ShooterHighGoal;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearTurnRightGoal_GyroEncoder extends CommandGroup {
    /*Basically, this autonomous program should consist of the StraightGear_GyroEncoder program as well as being able to turn and
	approach the goal. This should be possible if our teammates don't do the same thing.*/
    public  GearTurnRightGoal_GyroEncoder() {
    	addSequential(new GearTurnRight_GyroEncoder());
    	addSequential(new AutoDelay(5));
    	addSequential(new DriveStraightGyroVelocity(-.5,10,false)); 
    	addSequential(new DriveTurnGyroInPlace(15,.5));	
    	addSequential(new DriveStraightGyroVelocity(-.5,120,false));
    	addParallel(new FeederFoward());
    	addSequential(new ShooterHighGoal());
    	//addSequential(new GearTurnRight_GyroEncoder());
    	//addSequential(new DriveStraightGyroVelocity(-.5,-12,false));  //distance and speed DIMENSIONS TBD
    	//addSequential(new DriveTurnGyroInPlace(19.5,.5));	//angle, rate DIMENSIONS TBD
    	//addSequential(new DriveStraightGyroVelocity(-5,-140,false));
    	//addSequential(new ShooterHighGoal());
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

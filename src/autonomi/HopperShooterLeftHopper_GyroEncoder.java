package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyroEncoder;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyro;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;
import org.usfirst.frc.team293.robot.commands.ShooterHighGoal;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HopperShooterLeftHopper_GyroEncoder extends CommandGroup {
    
    public  HopperShooterLeftHopper_GyroEncoder() {
    	addSequential(new DriveStraightGyroEncoder(90, 0.5)); //inches
    	addSequential(new DriveTurnGyroInPlace(-90, 45)); //DIMENSIONS TBD
    	addSequential(new DriveStraightGyroEncoder(36, 0.5)); //inches
    	addSequential(new DriveTurnGyro(-0.5, 120, 2)); //DIMENSIONS TBD
    	addSequential(new DriveStraightGyroEncoder(36, 0.5)); //inches TBD
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

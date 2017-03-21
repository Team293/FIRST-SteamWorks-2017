package autonomi;

import org.usfirst.frc.team293.robot.commands.AutoDelay;
import org.usfirst.frc.team293.robot.commands.DriveStraightGyroVelocity;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;
import org.usfirst.frc.team293.robot.commands.FeederFoward;
import org.usfirst.frc.team293.robot.commands.GearFlapUp;
import org.usfirst.frc.team293.robot.commands.ShooterHighGoal;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HopperShooterRightHopper_GyroEncoder extends CommandGroup {

    public HopperShooterRightHopper_GyroEncoder() {
       	addSequential(new HopperShortRight_Encoder());
       	addParallel(new FeederFoward());
    	addSequential(new AutoDelay(2.5));
        addSequential(new DriveStraightGyroVelocity(-.4,-12,false));	//should be good         
        addSequential(new DriveTurnGyroInPlace(90, 3));
        addSequential(new DriveStraightGyroVelocity(.4,10,false));
        addSequential(new DriveStraightGyroVelocity(-.4,-70,false));	//should be good 
    	addSequential(new DriveTurnGyroInPlace(45, 2.5));
    	addParallel(new GearFlapUp());
    	addParallel(new ShooterHighGoal());
    	addParallel(new FeederFoward());
    	addSequential(new DriveStraightGyroVelocity(-.4,-5,false));
    }
}

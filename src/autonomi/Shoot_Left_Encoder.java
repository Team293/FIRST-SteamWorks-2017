package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyroVelocity;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyroInPlace;
import org.usfirst.frc.team293.robot.commands.ShooterHighGoal;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Shoot_Left_Encoder extends CommandGroup {

    public Shoot_Left_Encoder() {
    	addSequential(new DriveStraightGyroVelocity(.4,60,false));
    	addSequential(new DriveTurnGyroInPlace(-45,-.6));	//angle, rate
    	addSequential(new DriveStraightGyroVelocity(-.4,71,false));
    	addSequential(new ShooterHighGoal());
    }
}
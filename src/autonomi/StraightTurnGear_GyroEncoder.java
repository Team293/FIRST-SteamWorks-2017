package autonomi;

import org.usfirst.frc.team293.robot.commands.DriveStraightGyro;
import org.usfirst.frc.team293.robot.commands.DriveTurnGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StraightTurnGear_GyroEncoder extends CommandGroup {
    
    public  StraightTurnGear_GyroEncoder() {
    	addSequential(new DriveStraightGyro(1,.5));
    	addSequential(new DriveTurnGyro(.5,90,1));
    }
}

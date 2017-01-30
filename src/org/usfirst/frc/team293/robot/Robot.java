
package org.usfirst.frc.team293.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team293.robot.subsystems.Camera;
import org.usfirst.frc.team293.robot.subsystems.DriveTrain;
import org.usfirst.frc.team293.robot.subsystems.ContinuousFunctions;
import org.usfirst.frc.team293.robot.subsystems.GearPouch;
import org.usfirst.frc.team293.robot.subsystems.Feeder;
import org.usfirst.frc.team293.robot.subsystems.LEDs;
import org.usfirst.frc.team293.robot.subsystems.Shooter;

import autonomi.StraightTurnRightGear_GyroEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static OI oi;
	public static Camera Camera;
	public static ContinuousFunctions ContinuousFunctions;
	public static GearPouch GearPouch;
	public static Feeder Feeder;
	public static LEDs LEDs;
	public static Shooter Shooter;
    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
		oi = new OI();
		Camera = new Camera();
		ContinuousFunctions = new ContinuousFunctions();
		GearPouch = new GearPouch();
		Feeder = new Feeder();
		LEDs = new LEDs();
		Shooter= new Shooter();
		
		
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new StraightTurnRightGear_GyroEncoder());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
    }
    
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
       
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {		//Auto Mode
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();	//Gets out of Auto
    }

    public void teleopPeriodic() {		//Operator Control
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}

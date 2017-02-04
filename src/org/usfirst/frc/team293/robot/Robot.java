
package org.usfirst.frc.team293.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team293.robot.subsystems.Camera;
import org.usfirst.frc.team293.robot.subsystems.CombClimber;
import org.usfirst.frc.team293.robot.subsystems.DriveTrain;
import org.usfirst.frc.team293.robot.subsystems.ContinuousFunctions;
import org.usfirst.frc.team293.robot.subsystems.GearPouch;
import org.usfirst.frc.team293.robot.subsystems.Feeder;
import org.usfirst.frc.team293.robot.subsystems.LEDs;
import org.usfirst.frc.team293.robot.subsystems.Shooter;
import org.usfirst.frc.team293.robot.subsystems.ContinuousFunctions;

import autonomi.ForwardDrive;
import autonomi.GearLeftHopperRight_GyroEncoder;
import autonomi.GearStraight_GyroEncoder;
import autonomi.GearTurnLeft_GyroEncoder;
import autonomi.GearTurnRightGoal_GyroEncoder;
import autonomi.GearTurnRight_GyroEncoder;
import autonomi.HopperShooterLeftHopper_GyroEncoder;
import autonomi.Stand;
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
	public static Camera Camera=new Camera();
	public static CombClimber Climber=new CombClimber();
	public static ContinuousFunctions ContinuousFunctions=new ContinuousFunctions();
	public static GearPouch gearPouch=new GearPouch();
	public static Feeder Feeder=new Feeder();
	public static LEDs LEDs=new LEDs();
	public static Shooter Shooter=new Shooter();	
    Command autonomousCommand;
    SendableChooser chooser;
    
    public static DriverStation.Alliance color;
  

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Stand Still", new Stand());
        chooser.addObject("Foward Drive", new ForwardDrive());
        chooser.addObject("Gear (turn left), Right Hopper", new GearLeftHopperRight_GyroEncoder());
        chooser.addObject("Center Gear", new GearStraight_GyroEncoder());
        chooser.addObject("Gear (turn left)", new GearTurnLeft_GyroEncoder());
        chooser.addObject("Gear (turn right)", new GearTurnRight_GyroEncoder());
        chooser.addObject("Gear (turn right), goal", new GearTurnRightGoal_GyroEncoder());
        chooser.addObject("Hopper left, Shoot", new HopperShooterLeftHopper_GyroEncoder());
        
        
        
      //  chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode Chooser", chooser);
        
   
    }
    
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


    public void autonomousInit() {
    	color = DriverStation.getInstance().getAlliance();

    	autonomousCommand = (Command) chooser.getSelected();
    	autonomousCommand.start();
    	if(color == DriverStation.Alliance.Blue){
        	LEDs.sendData(LEDs.blueChasing);
        } else{
           LEDs.sendData(LEDs.redChasing);
        }
        
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

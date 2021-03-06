
package org.usfirst.frc.team293.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
import autonomi.GearRightHopperLeft_GyroEncoder;
import autonomi.GearStraight_GyroEncoder;
import autonomi.GearTurnLeftGoal_GyroEncoder;
import autonomi.GearTurnLeft_GyroEncoder;
import autonomi.GearTurnRightGoal_GyroEncoder;
import autonomi.GearTurnRight_GyroEncoder;
import autonomi.HopperLongLeft_GyroEncoder;
import autonomi.HopperLongRight_Encoder;
import autonomi.HopperShooterLeftHopper_GyroEncoder;
import autonomi.HopperShooterRightHopper_GyroEncoder;
import autonomi.HopperShortLeft_GyroEncoder;
import autonomi.HopperShortRight_Encoder;
import autonomi.Shoot_Left_Encoder;
import autonomi.Shoot_Right_Encoder;
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

	
	public static DriveTrain driveTrain;
	public static CombClimber Climber;
	public static ContinuousFunctions ContinuousFunctions;
	public static GearPouch gearPouch;
	public static Feeder feeder;
	public static LEDs lEDs;
	public static Shooter shooter;	
    Command autonomousCommand;
    SendableChooser<Command> chooser;	//any reason why it was typeless?
    
    public static DriverStation.Alliance color;
    public static OI oi;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	shooter=new Shooter();
    	gearPouch=new GearPouch();
    	feeder = new Feeder();
    	driveTrain = new DriveTrain();
    	Climber=new CombClimber();
    	lEDs=new LEDs();
    	ContinuousFunctions=new ContinuousFunctions();
    	oi =new OI();
    	
        chooser = new SendableChooser<Command>();
        chooser.addDefault("1 Stand Still", new Stand());
        chooser.addObject("1 Foward Drive", new ForwardDrive());
        
        chooser.addObject("2 Center Gear *Sensors", new GearStraight_GyroEncoder());
        chooser.addObject("2 Gear (turn left)  *Sensors", new GearTurnLeft_GyroEncoder());
        chooser.addObject("2 Gear (turn right) *Sensors", new GearTurnRight_GyroEncoder());
		
        chooser.addObject("3 Shoot Right *Sensors",new Shoot_Right_Encoder());
        chooser.addObject("3 Shoot Left *Sensors",new Shoot_Left_Encoder());
		
        chooser.addObject("4 Left Long Hopper *Sensors", new HopperLongLeft_GyroEncoder());
        chooser.addObject("4 Right Long Hopper *Sensors", new HopperLongRight_Encoder());
        chooser.addObject("4 Right Short Hopper *Sensors", new HopperShortRight_Encoder());
        chooser.addObject("4 Left Short Hopper *Sensors", new HopperShortLeft_GyroEncoder());
        ////////Untested Below//////////////////////////
        chooser.addObject("5 Gear (turn right), left goal *Sensors", new GearTurnRightGoal_GyroEncoder());
		chooser.addObject("5 Gear (turn left), right goal *Sensors", new GearTurnLeftGoal_GyroEncoder());
		
        chooser.addObject("6 Gear (turn left), Right Far Hopper *Sensors", new GearLeftHopperRight_GyroEncoder());
		chooser.addObject("6 Gear (turn right), Left Far Hopper *Sensors", new GearRightHopperLeft_GyroEncoder());
		
        chooser.addObject("7 Hopper left, Shoot *Sensors", new HopperShooterLeftHopper_GyroEncoder());
        chooser.addObject("7 Hopper right, Shoot *Sensors", new HopperShooterRightHopper_GyroEncoder());
		
        SmartDashboard.putData("Auto mode Chooser", chooser);   
        
        
        
   }
    
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


    public void autonomousInit() {
    	color = DriverStation.getInstance().getAlliance();
    	Robot.gearPouch.upFlap();
    	autonomousCommand = (Command) chooser.getSelected();
    	autonomousCommand.start();
    	if(color == DriverStation.Alliance.Blue){
        	lEDs.sendData(lEDs.blueChasing);
        } else{
           lEDs.sendData(lEDs.redChasing);
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
    
    public void autonomousDisabled(){
    	Robot.shooter.Stop();
    	Robot.feeder.stop();
    }
    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();	//Gets out of Auto
    	Robot.gearPouch.upFlap();
    }

    public void teleopPeriodic() {		//Operator Control
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}

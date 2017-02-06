package org.usfirst.frc.team293.robot;

import org.usfirst.frc.team293.robot.commands.FeederFoward;
import org.usfirst.frc.team293.robot.commands.FeederStop;
import org.usfirst.frc.team293.robot.commands.GearFlapDown;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	///////////instantiate joysticks
	 public static Joystick leftStick = new Joystick(0);
	 public static Joystick rightStick=new Joystick(1);
	 public static Joystick launchpad=new Joystick(2);
	 public static Joystick launchpad2=new Joystick(3);
	 
	public OI() {
		JoystickButton padOne=new JoystickButton(launchpad,1);		//These are numbered top down, left to right
		JoystickButton padTwo=new JoystickButton(launchpad,6);
		JoystickButton padThree=new JoystickButton(launchpad,8);
		JoystickButton padFour=new JoystickButton(launchpad,10);
		JoystickButton padFive=new JoystickButton(launchpad,11);
		JoystickButton padSix=new JoystickButton(launchpad,2);
		JoystickButton padSeven=new JoystickButton(launchpad,3);
		JoystickButton padEight=new JoystickButton(launchpad,5);
		JoystickButton padNine=new JoystickButton(launchpad,4);
		
		JoystickButton twoWaySwitch=new JoystickButton(launchpad,11);
		
		twoWaySwitch.whileHeld(new FeederFoward());
		twoWaySwitch.whenReleased(new FeederStop());
		//padThree.whenPressed(new Sh);
		
				
	}
}


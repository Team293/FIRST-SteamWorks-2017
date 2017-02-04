package org.usfirst.frc.team293.robot;

import org.usfirst.frc.team293.robot.commands.GearFlapClose;

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
	private Joystick joy = new Joystick(0);

	public OI() {

		// Create some buttons
		JoystickButton d_up = new JoystickButton(joy, 5);
		JoystickButton d_right = new JoystickButton(joy, 6);
		JoystickButton d_down = new JoystickButton(joy, 7);
		JoystickButton d_left = new JoystickButton(joy, 8);
		JoystickButton l2 = new JoystickButton(joy, 9);
		JoystickButton r2 = new JoystickButton(joy, 10);
		JoystickButton l1 = new JoystickButton(joy, 11);
		JoystickButton r1 = new JoystickButton(joy, 12);
		
		d_up.whenPressed(new GearFlapClose());
	}

	public Joystick getJoystick() {
		return joy;
	}
}


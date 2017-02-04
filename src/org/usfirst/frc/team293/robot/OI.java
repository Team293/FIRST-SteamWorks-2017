package org.usfirst.frc.team293.robot;

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
	private Joystick joy = new Joystick(0);

	public OI() {
	}

	public Joystick getJoystick() {
		return joy;
	}
}


package org.usfirst.frc.team293.robot;

import org.usfirst.frc.team293.robot.commands.ClimberDown;
import org.usfirst.frc.team293.robot.commands.ClimberOff;
import org.usfirst.frc.team293.robot.commands.ClimberUp;
import org.usfirst.frc.team293.robot.commands.FeederFoward;
import org.usfirst.frc.team293.robot.commands.FeederStop;
import org.usfirst.frc.team293.robot.commands.GearFlapDown;
import org.usfirst.frc.team293.robot.commands.GearFlapUp;
import org.usfirst.frc.team293.robot.commands.Light;
import org.usfirst.frc.team293.robot.commands.ShooterHighGoal;
import org.usfirst.frc.team293.robot.commands.ShooterLowGoal;
import org.usfirst.frc.team293.robot.commands.ShooterStop;
import org.usfirst.frc.team293.robot.commands.TankDriveReverse;
import org.usfirst.frc.team293.robot.subsystems.LEDButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*Button Manual
+-------------------+   
|  Button 1:        |    
|                   |   
|                   |    
|                   |    
|                   |  
|                   |   
|                   |     
|                   |    
|                   |   
+-------------------+  

+-------------------+
|  Button 2:        |
|                   |
|                   |
|                   |
|                   |
|                   |
|                   |
|                   |
|                   |
+-------------------+

+-------------------+
|  Button 3:        |
|                   |
| Activates the     |
| shooter to shoot  |
|  high goals       |
|                   |
|                   |
|                   |
|                   |
+-------------------+

+-------------------+
|  Button 4:        |
|                   |
|                   |
|                   |
|                   |
|                   |
|                   |
|                   |
|                   |
+-------------------+

+-------------------+       +-------------------+
|  Button 5:        |       |  Button 7:        |
|                   |       |                   |
|                   |       |                   |
|                   |       |                   |
|                   |       |                   |
|                   |       |                   |
|                   |       |                   |
|                   |       |                   |
|                   |       |                   |
+-------------------+       +-------------------+

+-------------------+       +-------------------+       +-------------------+        +-------------------+
|  Button 6:        |       |  Button 8:        |       |  Button 9:        |        |  Switch:          |
|                   |       |                   |       |                   |        |                   |
|                   |       |                   |       |                   |        |  Starts and stops |
|Flips up gear flaps|       |  Flips down gear  |       |  Starts and stops |        |      feeder       |
|                   |       |      flaps        |       |   the winch       |        |                   |
|                   |       |                   |       |    (to climb)     |        |                   |
|                   |       |                   |       |                   |        |                   |
|                   |       |                   |       |                   |        |                   |
|                   |       |                   |       |                   |        |                   |
+-------------------+       +-------------------+       +-------------------+        +-------------------+

The no visuals version:
 * 1:
 * 2: 
 * 3: Starts shooting high
 * 4: 
 * 5: 
 * 6: Flips up gear flaps
 * 7: 
 * 8: Flips down gear flaps (located adjacently from 6)
 * 9: Starts and stops the winch (to climb)
 * Switch: Starts and stops feeder
 */

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to th ol.e commands and command groups that allow control of the robot.
 */

public class OI {
	///////////instantiate joysticks
	 public static Joystick leftStick = new Joystick(0);
	 public static Joystick rightStick=new Joystick(1);
	 public static Joystick launchpad=new Joystick(2);
	 public static Joystick launchpad2=new Joystick(3);
	 
	 public static LEDButton LEDOne = new LEDButton(RobotMap.pad1[1]);
	 public static LEDButton LEDTwo = new LEDButton(RobotMap.pad2[1]);
	 public static LEDButton LEDThree = new LEDButton(RobotMap.pad3[1]);
	 public static LEDButton LEDFour = new LEDButton(RobotMap.pad4[1]);
	 public static LEDButton LEDFive = new LEDButton(RobotMap.pad5[1]);
	 public static LEDButton LEDSix = new LEDButton(RobotMap.pad6[1]);
	 public static LEDButton LEDSeven = new LEDButton(RobotMap.pad7[1]);
	 public static LEDButton LEDEight = new LEDButton(RobotMap.pad8[1]);
	 public static LEDButton LEDNine = new LEDButton(RobotMap.pad9[1]);
		

	public OI() {
		JoystickButton leftTrigger=new JoystickButton(leftStick,1);
		JoystickButton rightTrigger=new JoystickButton(rightStick,1);	
		JoystickButton leftTwo=new JoystickButton(leftStick,2);
		JoystickButton rightTwo=new JoystickButton(rightStick,2);
		JoystickButton leftThree=new JoystickButton(leftStick,3);
		JoystickButton rightThree=new JoystickButton(rightStick,3);
		
		
		JoystickButton padOne=new JoystickButton(launchpad,RobotMap.pad1[0]);		//These are numbered top down, left to right
		JoystickButton padTwo=new JoystickButton(launchpad,RobotMap.pad2[0]);
		JoystickButton padThree=new JoystickButton(launchpad,RobotMap.pad3[0]);
		JoystickButton padFour=new JoystickButton(launchpad,RobotMap.pad4[0]);
		JoystickButton padFive=new JoystickButton(launchpad,RobotMap.pad5[0]);
		JoystickButton padSix=new JoystickButton(launchpad,RobotMap.pad6[0]);
		JoystickButton padSeven=new JoystickButton(launchpad,RobotMap.pad7[0]);
		JoystickButton padEight=new JoystickButton(launchpad,RobotMap.pad8[0]);
		JoystickButton padNine=new JoystickButton(launchpad,RobotMap.pad9[0]);
		
		
		
		JoystickButton twoWaySwitch=new JoystickButton(launchpad,11);
		
		padOne.toggleWhenPressed(new ClimberUp());
		padTwo.toggleWhenPressed(new ClimberDown());
		padThree.toggleWhenPressed(new Light());
		twoWaySwitch.whenPressed(new FeederFoward());
		twoWaySwitch.whenReleased(new FeederStop());
		//padThree.whenPressed(new ShooterHighGoal());
		padSix.whenPressed(new GearFlapUp());
		padEight.whenPressed(new GearFlapDown());
		padNine.toggleWhenPressed(new ClimberUp());
		
		leftTwo.whenPressed(new FeederFoward());
		rightTwo.whenPressed(new FeederStop());
		
		leftThree.whenPressed(new ShooterHighGoal());
		rightThree.whenPressed(new ShooterStop());
		
		leftTrigger.toggleWhenPressed(new TankDriveReverse());
		rightTrigger.toggleWhenPressed(new TankDriveReverse());
	}
}


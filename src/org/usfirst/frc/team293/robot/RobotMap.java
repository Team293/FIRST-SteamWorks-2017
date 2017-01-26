package org.usfirst.frc.team293.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
		public static int   rightDrive=0, 	//Victors
							leftDrive=1,
							
							shooterTrigger=2,
							ballFeeder=3,
							climber=4;
		
		public static int   Shooter=0; 	//Talons  Encoder Here too
		public static final int Feeder = 2;
		
		
		public static int[] leftEncoder={0,1},
							rightEncoder={2,3};
		
		public static int   leftGear=4,
							rightGear=5,
							limitGear=6;
		
		public static int   climberPot=0;  //analog to read voltage
		
		public static final int visionServoPin = 8,
				LEFT_BANNER_PIN = 7,
				RIGHT_BANNER_PIN = 8,
				HAS_GEAR_BUTTON_PIN = 9;
		
						  
		
							
		
							
		
		
}

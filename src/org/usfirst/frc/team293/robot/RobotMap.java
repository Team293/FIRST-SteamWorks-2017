package org.usfirst.frc.team293.robot;

import com.ctre.CANTalon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

		public static int[]   rightDrive={0,1}, 	//Victors
							leftDrive={2,3};
							
		public static int	ballFeeder=5,
							shooterTrigger=6;
		public static int	visionServoPin = 7; //Pin for camera Servo						
		public static int[]	flapServo={8,9}; 	//Flap Servo
		
		public static int   shooter=2,	//Talons and an Encoder here too
							climber=1,	//Talons for the current monitoring
							imu=3;
		
		public static int[] leftEncoder={0,1}, 	//Drivetrain Encoders
							rightEncoder={2,3};
		
		//limitGear not on final robot, de-comment if added
		//public static int	limitGear=4;		//Optical Limit to see if we have gear.
							
		

				
		///////////////POWER DISTRIBUTION STUFF////////////////////
		public static int[] pdpLeftDrive={0,1,2}; 		//40A
		public static int[] pdpRightDrive={13,14,15};	//40A
		
		public static int pdpShooter=3;					//40A
		public static int pdpClimber=12;				//40A	
		
		public static int pdpShooterTrigger=11,			//30A
						  pdpBallFeeder=4;				//30A
}
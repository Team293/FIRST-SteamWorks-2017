package org.usfirst.frc.team293.robot;

import com.ctre.CANTalon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	
	
    //Butt stuff ([0] = button number, [1] = LED number)
    
    public static final int[]
   	     pad1={1,1},
   	     pad2={6,6},
   	     pad3={8,8},
   	     pad4={10,10},
   	     pad5={11,11},
   	     pad6={2,2},
   	     pad7={3,3},
   	     pad8={5,5},
   	     pad9={4,4};
	
    
		public static int[]   rightDrive={0,1}, 	//Victors
							leftDrive={2,3};
							
		public static int	ballFeeder=5,
							shooterTrigger=4;
		public static int	visionServoPin = 7; //Pin for camera Servo						
		public static int[]	flapServo={8,9}; 	//Flap Servo
		
		public static int   shooter=2,	//Talons and an Encoder here too
							climber=1,	//Talons for the current monitoring
							//climbertwo=3,
							pdp=4,
							imu=5;
		
		public static int[] leftEncoder={0,1}, 	//Drivetrain Encoders
							rightEncoder={2,3};
		
		public static int	limitGear=4;		//Optical Limit to see if we have gear.
							
		

				
		///////////////POWER DISTRIBUTION STUFF////////////////////
		public static int[] pdpLeftDrive={15,14,13}; 	//40A
		public static int[] pdpRightDrive={0,1,2};		//40A
		
		public static int pdpShooter=10;				//40A
		public static int pdpClimber=12;				//40A	
		public static int pdpServo=5;					//20A
		public static int pdpShooterTrigger=11,			//30A
						  pdpBallFeeder=4;				//30A
}
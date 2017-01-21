package org.usfirst.frc.team293.robot.subsystems;
import org.opencv.core.Point;
import org.usfirst.frc.team293.robot.Robot;

//import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team293.robot.RobotMap;
import org.usfirst.frc.team293.robot.Serial;
import org.usfirst.frc.team293.robot.commands.FollowGearVision;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Camera extends Subsystem {

	Serial raspberryPi;
	public long lastReading = System.currentTimeMillis();
    public long lastPIDUpdate = System.currentTimeMillis();
	
	List<Point> goals = new ArrayList<Point>();
	Point myGoal = new Point();
	private static final double frameCenter[] = {160.0,120.0};		//center of screen in pixels
	private static final double PIDGains[] = {0.025/frameCenter[0],0.0,0.0008/frameCenter[0]};
	
	Servo cameraServo = new Servo(RobotMap.visionServoPin);
	public long lastServoSet = System.currentTimeMillis();
	//x servo angle pointed straight forward
    private static final double baseX = 0.402;
	private static double inc = 0.024;
	private static final double servoRange[] = {0.15, 0.74};
	private static final double servoRangeSearch[] = {0.15, 0.74};
    private static double servoAngle = baseX;				//initial Servo angles (0.0-1.0 scale)

	
	private static double error = 0.0;
	private static double lastError = 0.0;
	private static double integralError = 0.0;
	//if it can see the goal
	private static boolean foundGoal = false;
	
	public Camera(){											//Instantiates the Servos and Pi
		raspberryPi = new Serial(Port.kMXP,9600);				//9600 baud
    	goals.clear();
    	myGoal.x = 0;
    	myGoal.y = -1;
	}
	
	public boolean getPiData(){	//Gets the coordinates from the Pi to setup the Rio
    	String x = raspberryPi.getData();
    	//System.out.println(x);
    	String dels = "[.]";
    	String[] inputs = x.split(dels);
    	//System.out.println(x);
    	x = inputs[inputs.length - 1];
    	//System.out.println(x);
    	if(x != "null"){
    		/*String delims = "[;]";
    		String[] centers = x.split(delims);							//split string at spaces
    		delims = "[,()]";
    		List<Point> coords = new ArrayList<Point>();
    		for(int i = 0;i < centers.length;i++){
    			String[] stringCoords = centers[i].split(delims);
    			if(stringCoords.length == 2){
    				coords.add(new Point(Integer.parseInt(stringCoords[0]),
    						Integer.parseInt(stringCoords[1])));
    			}
    		}
   			lastReading = System.currentTimeMillis();					//set time for the last reading
   			//SmartDashboard.putNumber("goal x",goalCoordinates[0]);
   			if(coords.size() == 0){
   				return -1;												//if can't see goal, return -1
   			}*/
    		String delims = "[;]";
    		String[] centers = x.split(delims);							//split string at spaces
    		List<Integer> markers = new ArrayList<Integer>();
    		for(String i : centers){
    			if(i != ""){
    				try{
    					markers.add(Integer.parseInt(i));
    				}catch(java.lang.NumberFormatException nfe){
    					System.out.println("COULD NOT READ SERIAL INPUT");
    				}
    			}
    		}
    		lastReading = System.currentTimeMillis();					//set time for the last reading
    		if(markers.size() == 0){
   				return false;												//if can't see goal, return -1
   			}
    		getGoals(markers);
    		for(Point i : goals){
    			System.out.print(i.y);
    			System.out.print(", ");
    		}
    		System.out.println();
    		return true;													//if can see goal, return 1
    	}
    	return false;														//else return 0
    }
	
	public void getGoals(List<Integer> markers){
		goals.clear();
		for(int i = 0;i < markers.size() - 1;i+=2){
			if(markers.size() > i+1){
				markers.set(i, (int) (markers.get(i) - frameCenter[0]));
				markers.set(i + 1, (int) (markers.get(i + 1) - frameCenter[0]));
				goals.add(new Point((markers.get(i) + markers.get(i+1))/2,Math.abs(markers.get(i)-markers.get(i+1))));
			}else{
				markers.set(i, (int) (markers.get(i) - frameCenter[0]));
				goals.add(new Point(markers.get(i),-1));
			}
		}
		if(goals.size() == 1){
			myGoal.x = goals.get(0).x;
			myGoal.y = goals.get(0).y;
			//myGoal.setLocation((int)goals.get(0).x, (int)goals.get(0).y);
		}
	}
	
	public void updatePID(boolean newData){
    	double Dt = (double)(System.currentTimeMillis() - lastPIDUpdate) / 1000.0;		//gets dt (seconds)
    	double output = 0.0;
    	//if we have new data update the last error
    	if(newData){
    		lastError = error;
    	}
    	//get error (actual - wanted)
    	error = myGoal.x;
    	//weird stuff to make it find the goal faster after it loses it
    	//moves to the side that it lost it on
    	if(error < 0){
    		if(inc > 0){
    			inc *= -1;
    		}
   		}else{
    		if(inc < 0){
    			inc *= -1;
    		}
    	}
    	double derivative = 0.0;
    	if(Dt < 0.400){				//exclude derivative and integral if it has been too long
    		derivative = (error - lastError) / Dt;
    		integralError += error * Dt;
    	}
    	//constrain integral (-1000 to 1000)
    	integralError = Math.min(Math.max(integralError,-1000.0), 1000.0);
    	//set outputs based on PID
    	output = servoAngle + PIDGains[0] * error + PIDGains[1] * integralError + PIDGains[2] * derivative;
    	this.setServoValues(output);							//set the servo values (DOES NOT MOVE SERVOS)
    	lastPIDUpdate = System.currentTimeMillis();
    	foundGoal = true;
    }
	
	public void setServoValues(double val){												//sets the servo values	
    	val = Math.min(Math.max(val,servoRange[0]), servoRange[1]);			//Constrain Servo Values
    	servoAngle = val;								//Set Servo values (Does not actually set servos)
    }
	
	public void setServos(){			//Sets servos to a certain value
    	for(int i = 0;i < 2;i++){
    		cameraServo.set(servoAngle);											//Set Servos
    		//System.out.println("ServoAngle: " + servoAngle);
    	}
    	SmartDashboard.putNumber("x Servo",servoAngle);
    	lastServoSet = System.currentTimeMillis();
    }
	
	public void search(){		//If the camera can't find the goal, it needs to search around
    	double output = 0.0;
    	if(servoAngle + inc < servoRangeSearch[0] && inc < 0 ){			//changes direction (x)
    		inc = -1*inc;
    	}
    	if(servoAngle + inc > servoRangeSearch[1] && inc > 0){				//changes direction (y)
    		inc = -1*inc;
    	}
    	output = servoAngle + inc;											//changes servo values

    	this.setServoValues(output);														//actually moves servos
    	foundGoal = false;
    }
	
	public boolean canSeeSwagadelia(){		//returns if the camera can indeed see the goal or if its searching around
    	SmartDashboard.putBoolean("RobotCanSeeGoal", foundGoal);
    	return foundGoal;
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new FollowGearVision());		//default command is to follow goal
	}
}

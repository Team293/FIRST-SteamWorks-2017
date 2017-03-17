package org.usfirst.frc.team293.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class LEDs {
	
	SerialPort port;
	public String rainbow="0",
			
					blueChasing="155",	//for Auto
					redChasing="154",	//for Auto

					
					needGear="150", //yellowFlashing
					haveGear= "151", //yellow Solid
					readyBalls="152", //orange Solid
							
					whenFeeding="153",//orange chasing
					whenShooting="154", //red Chasing
					
					timeWarning="200",// purple solid	
					
					climbing="201";  //purpleFlashing
					
					//goForward="0",//drivetrain direction
					//goBackwards="1";
				  
	public LEDs(){			//initializes the Serial Port
		port= new SerialPort(9600, Port.kMXP);
	}
    
	public void sendData(String datas){
		port.writeString(datas);
	}
	
    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
    
    

}

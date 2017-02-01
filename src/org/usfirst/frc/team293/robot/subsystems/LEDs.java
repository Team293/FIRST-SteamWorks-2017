package org.usfirst.frc.team293.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class LEDs {
	
	SerialPort port;
	public String rainbow="0", yellowChasing="1", fontledgreen="101";
				  
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

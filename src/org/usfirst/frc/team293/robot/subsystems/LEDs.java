package org.usfirst.frc.team293.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class LEDs {
	
	SerialPort port;
	public String rainbow="0",
					blueChasing="255",
					redChasing="254",
					orangeChasing="253",
					orangeSolid="252",
					redSolid="251",
					yellowSolid="250",
					greenSolid="249",
					whiteSolid="0",
					purpleSolid="1",
					blueFlashing="2";
				  
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

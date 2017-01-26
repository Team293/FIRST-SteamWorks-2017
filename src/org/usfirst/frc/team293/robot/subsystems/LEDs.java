package org.usfirst.frc.team293.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;

public class LEDs {
	public static final byte
	HasGear=(byte) 255,	//red pulsing if on red alliance
	NoGear=(byte) 254,	//blue pulsing if on blue alliance
	GearStuck=(byte) 253,
	GearRemoved=(byte) 252,
	Shooting=(byte) 251;
	
	I2C leds;
	byte[] toSend = new byte[1];
	
private int arduinoAddress = 8;
	
	public LEDs(){											//initializes the i2c port
		leds = new I2C(I2C.Port.kOnboard, arduinoAddress);
	}
    
    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void writeByte(byte toWrite){						//writes 1 byte to the i2c port
    	toSend[0] = toWrite;
    	leds.transaction(toSend, 1, null, 0);
    }
}

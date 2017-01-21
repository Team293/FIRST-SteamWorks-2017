package org.usfirst.frc.team293.robot;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class Serial {

	public SerialPort serial;
//***********************this is for the IMU on one pi on the onboard RS232, and the other port on the MXP serial
	public Serial(Port port, int speed) {
		serial = new SerialPort(speed, port);
		serial.setReadBufferSize(1);// to try data immediately sent to
									// smartdashboard
		this.serial.reset();
	}

	public String getData() {
		if (serial.getBytesReceived() > 0) {
			return serial.readString();
		} else {
			return "null";
		}
	}

	public boolean sendData(byte[] buffer) throws Exception {

		int count = buffer.length;
		this.serial.write(buffer, count);
		return true;
	}

	public void reset() {
		serial.reset();
	}

}
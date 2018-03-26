package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class RobotMap 
{

	//Instantiate SRXs
	public WPI_TalonSRX FL;
	
	public WPI_TalonSRX BL;
	
	public WPI_TalonSRX FR;
	
	public WPI_TalonSRX BR;
	
	public WPI_TalonSRX leftCompliantArm;
	
	public WPI_TalonSRX rightCompliantArm;
	
	public WPI_TalonSRX elevatorWinch;
	
	public WPI_TalonSRX elevatorWinch2;
	
	//Instantiate Sparks and assign PWM Ports
	public Spark leftGripper = new Spark(1);
	
	public Spark rightGripper = new Spark(2);
	
	//Instantiate VictorSP and assign PWM Port
	public VictorSP climber = new VictorSP(0);
	
	//Instantiate and Assign Double Solenoids
	public DoubleSolenoid intakeSolenoidLeft = new DoubleSolenoid(0,1);
	
	public DoubleSolenoid intakeSolenoidRight = new DoubleSolenoid(2,3);
	
	//Instantiate Digital Sensors and assign PWM
	public DigitalInput ElevatorBottomSwitch = new DigitalInput(1);
	
	public DigitalInput cubeSensor = new DigitalInput(0);
	
	public PigeonIMU IMU;
	
	public RobotMap()
	{
		//Assign Device ID's for Talon SRX's
		
		FL = new WPI_TalonSRX(0);
		BL = new WPI_TalonSRX(1);
		FR = new WPI_TalonSRX(2);
		BR = new WPI_TalonSRX(3);
		
		//leftCompliantArm = new WPI_TalonSRX(4);
		//rightCompliantArm = new WPI_TalonSRX(5);
		
		elevatorWinch = new WPI_TalonSRX(4); //6
		elevatorWinch2 = new WPI_TalonSRX(6); 
		
		FL.setSensorPhase(false);
		FR.setSensorPhase(true);
		
		IMU = new PigeonIMU(BR); 
	}
	
}

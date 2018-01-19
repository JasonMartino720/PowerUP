package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

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
	
	//Instantiate Sparks and assign PWM Ports
	public Spark leftGripper = new Spark(0);
	
	public Spark rightGripper = new Spark(1);
	
	//Instantiate VictorSP and assign PWM Port
	public VictorSP climber = new VictorSP(2);
	
	public RobotMap()
	{
		//Assign Device ID's for Talon SRX's
		
		FL = new WPI_TalonSRX(0);
		BL = new WPI_TalonSRX(1);
		FR = new WPI_TalonSRX(2);
		BR = new WPI_TalonSRX(3);
		
		leftCompliantArm = new WPI_TalonSRX(4);
		rightCompliantArm = new WPI_TalonSRX(5);
		
		elevatorWinch = new WPI_TalonSRX(6);
	}
	
}

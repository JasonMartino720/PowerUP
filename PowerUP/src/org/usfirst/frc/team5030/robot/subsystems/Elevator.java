package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;

//TODO input top limit on operatorControl using Robot.robotmap.topHeight
//TODO change invert in constructor if necessary
//TODO Smarter Deadband
public class Elevator extends Subsystem {

	private int operatorSetpoint;
	private boolean decidedPosition;
	
	public void operatorControl(double speed)
	{
		if(Math.abs(speed) > 0.1)
		{
			Robot.robotmap.elevatorWinch.set(speed);
		}
		else
		{
			Robot.robotmap.elevatorWinch.set(0.0);
		}
		System.out.println("Speed " + speed);
	
	}

	public void chooseHallEffect(int operatorPOV)
	{
		/*
		//Receive POV value and turn it into number 0-3 or -1
		//NOTE: When DPAd is not pressed value = -1
		operatorSetpoint = operatorPOV / 90;
		
		if(operatorSetpoint == -1)
		{
			Robot.robotmap.elevatorWinch.set(0.0);
		}
		else
		{	
			switch(operatorSetpoint)
			{
				case 0:
				decidedPosition = Robot.robotmap.switchHeight.get();
				this.elevatorToPosition(decidedPosition);
				break;
				
				case 1:
				decidedPosition = Robot.robotmap.scaleHeight.get();
				this.elevatorToPosition(decidedPosition);
				break; 
			}
		}
	*/					
	}
	
	public void elevatorToPosition(boolean decidedPosition)
	{
		/*if(!decidedPosition)
		{
			Robot.robotmap.elevatorWinch.set(1.0);
		}
		else
		{
			Robot.robotmap.elevatorWinch.set(0.0);
		}
		*/
	}
	
	
	public Elevator()
	{
		Robot.robotmap.climber.setInverted(true);
		Robot.robotmap.climber.enableDeadbandElimination(true);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ElevatorOperation());
    }
}


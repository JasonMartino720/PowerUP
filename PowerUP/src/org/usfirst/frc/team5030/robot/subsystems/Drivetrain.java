package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Drivetrain extends Subsystem 
{

	//Instantiate DifferentialDrive and name it "drive"
	DifferentialDrive drive;
	
	SpeedControllerGroup leftDrive = new SpeedControllerGroup(Robot.robotmap.FL, Robot.robotmap.BL);
	SpeedControllerGroup rightDrive = new SpeedControllerGroup(Robot.robotmap.FR, Robot.robotmap.BR);

	private double deadband = 0.2;
	
	//This method for driving during the teleop phase requires the two doubles provided by the JoystickOperation Command 
	public void UserDrive(double throttle, double rotation)
	{
		drive.arcadeDrive(throttle, rotation);
	}

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickOperation());
    }
    
    public Drivetrain()
    {
    	drive = new DifferentialDrive(leftDrive, rightDrive);
    	drive.setDeadband(this.deadband);
    	drive.setExpiration(0.1);
    }
}


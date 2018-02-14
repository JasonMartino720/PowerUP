package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.*;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

//TODO Test all motors and decide inverts
//TODO figureo out appropriate deadband
//TODO figure out correct values for setSelectedSensorPosition
//TODO figure out set value state
public class Drivetrain extends Subsystem 
{

	//Instantiate DifferentialDrive and name it "drive"
	DifferentialDrive drive;
	
	SpeedControllerGroup leftDrive = new SpeedControllerGroup(Robot.robotmap.FL, Robot.robotmap.BL);
	SpeedControllerGroup rightDrive = new SpeedControllerGroup(Robot.robotmap.FR, Robot.robotmap.BR);

	public double kSensorUnitsPerRotation = 4096;
	private double deadband = 0.2;
	
	//This method for driving during the teleop phase requires the two doubles provided by the JoystickOperation Command 
	public void UserDrive(double throttle, double rotation)
	{
		drive.arcadeDrive(throttle, rotation);
		
	}

	public void AllStop()
	{
		Robot.robotmap.FR.set(0.0);
		Robot.robotmap.FL.set(0.0);
		Robot.robotmap.BR.set(0.0);
		Robot.robotmap.BL.set(0.0);
	}
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickOperation());
    }
    
    public void EncReset()
    {
    	Robot.robotmap.FL.setSelectedSensorPosition(0, 0, 0);
    	Robot.robotmap.FR.setSelectedSensorPosition(0, 0, 0);
    }
    
    public void ClearMotionProfiles()
    {
    	Robot.robotmap.FL.clearMotionProfileTrajectories();
    	Robot.robotmap.FR.clearMotionProfileTrajectories();
    	
    	Robot.robotmap.FL.clearMotionProfileHasUnderrun(0);
    	Robot.robotmap.FR.clearMotionProfileHasUnderrun(0);
    }
    
    public void ConifgMagEncoder()
    {
    	Robot.robotmap.FL.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 5);
    	Robot.robotmap.FR.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 5);
    }
    public Drivetrain()
    {
    	drive = new DifferentialDrive(leftDrive, rightDrive);
    	drive.setDeadband(this.deadband);
    	drive.setExpiration(0.1);
    }
}


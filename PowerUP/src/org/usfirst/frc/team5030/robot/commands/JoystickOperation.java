package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickOperation extends Command {

	//Create doubles for arcade drive values to be passed back to drivetrain subsystem
	private double throttle;
	private double rotation;
	
    public JoystickOperation() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrainSubsystem);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.FL.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 5);
    	Robot.robotmap.FR.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 5);
    
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//call the necessary joystick inputs
    	throttle = Robot.oi.driver.getY();
    	rotation = Robot.oi.driver.getX();
    	
    	//pass values back to UserDrive Method of Drivetrian subsystem
    	Robot.drivetrainSubsystem.UserDrive(throttle, rotation);
    	
    	if(Robot.oi.rbbutton.get())
    	{
    		Robot.robotmap.FR.getSensorCollection().setQuadraturePosition(0, 5);
    		Robot.robotmap.FL.getSensorCollection().setQuadraturePosition(0, 5);
    		
    	}
    	
    	System.out.println("Right Enc " + Robot.robotmap.FR.getSelectedSensorVelocity(1/256));
		System.out.println("Left Enc " + Robot.robotmap.FL.getSelectedSensorVelocity(1/256));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

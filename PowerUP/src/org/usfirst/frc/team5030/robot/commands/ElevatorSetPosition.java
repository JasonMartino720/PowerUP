package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorSetPosition extends Command {

	//Variable to store operator DPad value
	private int operatorPOV;
	
    public ElevatorSetPosition() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Get POV from operator and send it to chooseHallEffect method
    	operatorPOV = Robot.oi.operator.getPOV();
    	
    	Robot.elevatorSubsystem.overPosition(operatorPOV);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	//Kill command when POV = -1 ie. Not Pressed
        if(operatorPOV == -1)
    	{
        	return true;
    	}
        else
        {
        	return Robot.elevatorSubsystem.overHeight;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

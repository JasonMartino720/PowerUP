package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AUTO_CrossLine extends Command {

	private double delay = 0;
	private boolean delayFinished = false;
	
	
    public AUTO_CrossLine() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrainSubsystem.EncReset();
    	Robot.drivetrainSubsystem.ConifgMagEncoder();
    	//Robot.intakeSubsytem.intakeOutPosition();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(timeSinceInitialized() < delay)
    	{
    		Robot.drivetrainSubsystem.AllStop();
    	}
    	else
    	{
    		Robot.drivetrainSubsystem.ArcadeDrive(0.55, 0.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timeSinceInitialized() < (delay + 7))
        {
        	return false;
        }
        else
        {
        	return true;
        }
        		
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrainSubsystem.AllStop();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
